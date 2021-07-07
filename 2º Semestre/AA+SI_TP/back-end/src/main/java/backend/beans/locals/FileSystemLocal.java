package backend.beans.locals;

import backend.dao.Resources;
import backend.json.DownloadJSON;
import org.springframework.web.multipart.MultipartFile;

import javax.ejb.Local;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipOutputStream;

@Local
public interface FileSystemLocal {
    backend.dao.Files[] saveFiles(MultipartFile[] files, Resources r);
    backend.dao.Files[] delFiles(int[] delete, Resources r);
    String savePicture(MultipartFile file, int id);
    File getImage(String name);
    File getFile(int id);
    void zipResources(DownloadJSON idResources, ZipOutputStream zipOutputStream);
}
