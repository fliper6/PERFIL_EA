package backend.beans;

import backend.beans.locals.FileSystemLocal;
import backend.dao.*;
import backend.json.DownloadJSON;
import org.apache.tika.Tika;
import org.apache.tika.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


@Stateless(name = "FileSystemEJB")
@Local(FileSystemLocal.class)
@Component
public class FileSystemBean {
    private final String imagesDirectory = System.getProperty("user.dir")+"/uploads/images";
    private final String resourceDirectory = System.getProperty("user.dir")+"/uploads/files";

    public backend.dao.Files[] delFiles(int[] delete, Resources r){
        try{
            for(int i: delete){
                backend.dao.Files f = FilesDAO.getFilesByORMID(i);
                File ff = new File(resourceDirectory + "/" + f.getPath());
                if(f.getIdResource().getIdResource() == r.getIdResource()) {
                    FilesDAO.deleteAndDissociate(f);
                    ff.delete();
                }
            }
            return FilesDAO.listFilesByQuery("idResource="+r.getIdResource(),null);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public backend.dao.Files[] saveFiles(MultipartFile[] files, Resources r) {
        try{
            for (MultipartFile file : files) {
                String[] arr = file.getOriginalFilename().split("[.]");
                String time = Long.toString(System.currentTimeMillis());
                String name = arr[0] + time + "." + arr[1];
                Path fileNameAndPath = Paths.get(resourceDirectory, name);
                Tika tika = new Tika();
                String mimeType = tika.detect(file.getOriginalFilename());
                long size = file.getSize();
                Files.write(fileNameAndPath, file.getBytes());
                backend.dao.Files f = new backend.dao.Files();
                f.setName(file.getOriginalFilename());
                f.setMimetype(mimeType);
                f.setIdResource(r);
                f.setPath(name);
                f.setSize(size);
                FilesDAO.save(f);
            }
            return FilesDAO.listFilesByQuery("idResource="+r.getIdResource(),null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new backend.dao.Files[0];
    }

    public String savePicture(MultipartFile file, int id){
        String[] arr = file.getOriginalFilename().split("[.]");
        String time = Long.toString(System.currentTimeMillis());
        String name = arr[0] + time + "." + arr[1];
        Path fileNameAndPath = Paths.get(imagesDirectory, name);
        try {
            Files.write(fileNameAndPath, file.getBytes());
            Users u = UsersDAO.getUsersByORMID(id);
            u.setPicture(name);
            UsersDAO.save(u);
            return "{\"image\":\"" + name + "\"}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public File getFile(int id){
        try{
            return new File(resourceDirectory + "/" + FilesDAO.getFilesByORMID(id).getPath());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private File getFileByPath(String path){
        try{
            return new File(resourceDirectory + "/" + path);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private HashMap<String, File> getFilesFromResource(int id){
        try{
            HashMap<String,File> hm = new HashMap<>();
            backend.dao.Files[] files = backend.dao.FilesDAO.listFilesByQuery("idResource="+id,null);
            for(int i = 0; i < files.length; i++){
                File f = getFileByPath(files[i].getPath());
                hm.put(files[i].getName(), f);
            }

            return hm;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private void zipResource(int id, ZipOutputStream zipOutputStream){
        HashMap<String,File> hm = getFilesFromResource(id);
        try{
            Resources r = ResourcesDAO.getResourcesByORMID(id);
            for (Map.Entry<String,File> file : hm.entrySet()) {
                zipOutputStream.putNextEntry(new ZipEntry( r.getTitle()+"/"+ file.getKey()));
                FileInputStream fileInputStream = new FileInputStream(file.getValue());

                IOUtils.copy(fileInputStream, zipOutputStream);

                fileInputStream.close();
                zipOutputStream.closeEntry();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void zipResources(DownloadJSON idResources, ZipOutputStream zipOutputStream){
        int[] ids = idResources.getIds();
        for(int id: ids){
            zipResource(id,zipOutputStream);
        }
    }

    public File getImage(String name){
        return new File(imagesDirectory + "/" + name);
    }

}
