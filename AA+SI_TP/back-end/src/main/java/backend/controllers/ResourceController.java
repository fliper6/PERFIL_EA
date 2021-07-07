package backend.controllers;

import backend.beans.FileSystemBean;
import backend.beans.ResourceBean;
import backend.dao.*;
import backend.json.*;
import backend.util.JWTUtil;
import io.jsonwebtoken.Claims;
import org.apache.tika.Tika;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.ejb.EJB;
import java.io.File;
import java.util.zip.ZipOutputStream;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/resource")
public class ResourceController {

    @EJB
    ResourceBean rb;
    @EJB
    FileSystemBean fsb;
    // atualizar
    @GetMapping("/")
    public ResourceJSON[] getResources(@RequestHeader(value="Authorization", required = false) String token){
        int idUser = -1;
        if(token!=null){
            Claims cl = JWTUtil.decodeJWT(token);
            if(cl==null) return null;
            idUser = (int) cl.get("idUser");
        }
        return rb.getResources(idUser);
    }

    @RequestMapping(value="/file/{id}", method=RequestMethod.GET)
    public ResponseEntity<byte[]> getFile(@PathVariable int id){
        HttpHeaders headers = new HttpHeaders();
        File img = fsb.getFile(id);
        Tika tika = new Tika();
        headers.add("Content-Disposition", "inline; filename=" + img.getName());
        try{
            String type = tika.detect(img);
            headers.setContentType(MediaType.parseMediaType(type));
            ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(java.nio.file.Files.readAllBytes(img.toPath()), headers, HttpStatus.OK);
            return response;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/type/{type}")
    public ResourceJSON[] getResourcesOfType(@RequestHeader(value="Authorization", required = false) String token, @PathVariable String type){
        int idUser = -1;
        if(token!=null){
            Claims cl = JWTUtil.decodeJWT(token);
            if(cl==null) return null;
            idUser = (int) cl.get("idUser");
        }
        return rb.getResourcesOfType(type ,idUser);
    }

    @GetMapping("/recent/")
    public ResourceJSON[] getRecentResources(@RequestHeader(value="Authorization", required = false) String token){
        int idUser = -1;
        if(token!=null){
            Claims cl = JWTUtil.decodeJWT(token);
            if(cl==null) return null;
            idUser = (int) cl.get("idUser");
        }
        return rb.getRecentResources(idUser);
    }

    @PostMapping( "/download/")
    public ResponseEntity<StreamingResponseBody> downloadResources(@RequestBody DownloadJSON ids){
        String time = Long.toString(System.currentTimeMillis());
        return ResponseEntity
                .ok()
                .header("Content-Disposition", "attachment; filename=\"" + time + ".zip\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(out -> {
                    var zipOutputStream = new ZipOutputStream(out);
                    fsb.zipResources(ids,zipOutputStream);
                    for (int id : ids.getIds()) {
                        rb.incDownloads(id);
                    }
                    zipOutputStream.close();
                });
    }

    @GetMapping("/{id}")
    public ResourceJSON getResource(@RequestHeader(value="Authorization", required = false) String token, @PathVariable int id){
        int idUser = -1;
        if (token!=null){
            Claims cl = JWTUtil.decodeJWT(token);
            if(cl==null) return null;
            idUser = (int) cl.get("idUser");
        }
        return rb.getResource(id,idUser);
    }

    @GetMapping("/types")
    public TypesJSON getResourcesTypes(){
        return rb.getResourceTypes();
    }

    @PostMapping("/rate/{id}")
    public RatingsJSON rateResource(@RequestHeader(value="Authorization") String token, @PathVariable int id, @RequestBody RateResourceJSON rrj){
        Claims cl = JWTUtil.decodeJWT(token);
        if(cl==null) return null;
        return rb.rateResource(id,(int) cl.get("idUser"),rrj);
    }

    @PostMapping("/")
    public ResourceJSON upload(@RequestHeader(value="Authorization") String token, @RequestParam String title, @RequestParam String description, @RequestParam java.sql.Timestamp registeredAt, @RequestParam boolean visibility, @RequestParam String type, @RequestParam("file") MultipartFile[] files){
        Claims cl = JWTUtil.decodeJWT(token);
        if(cl==null) return null;
        Resources r = rb.createResource(new CreateResourceJSON(title,description,registeredAt,visibility,(int)cl.get("idUser"),type));
        Files[] fs = fsb.saveFiles(files,r);
        return new ResourceJSON(r,new Ratings[0], fs, new PostJSON[0]);
    }

    @PostMapping("/update/{id}")
    public ResourceJSON update(@RequestHeader(value="Authorization") String token, @PathVariable int id, @RequestParam String title, @RequestParam String description, @RequestParam java.sql.Timestamp registeredAt, @RequestParam boolean visibility, @RequestParam String type, @RequestParam int[] delete, @RequestParam("file") MultipartFile[] files){
        Claims cl = JWTUtil.decodeJWT(token);
        if(cl==null) return null;
        Resources r = rb.updateResource(new UpdateResourceJSON(id,title,description,registeredAt,visibility,(int)cl.get("idUser"),type,delete), (int)cl.get("idUser"));
        fsb.saveFiles(files,r);
        Files[] fs = fsb.delFiles(delete,r);
        try{
            Ratings[] rs = RatingsDAO.listRatingsByQuery("idResource="+id,null);
            Posts[] ps = PostsDAO.listPostsByQuery("idResource="+id,null);
            PostJSON[] pjs = new PostJSON[ps.length];
            for(int j = 0 ; j < ps.length; j++){
                Comments[] cs = CommentsDAO.listCommentsByQuery("idPost="+ps[j].getIdPost(),null);
                CommentJSON[] cjs = new CommentJSON[cs.length];
                for(int x = 0; x < cs.length; x++){
                    cjs[x] = new CommentJSON(cs[x]);
                }
                pjs[j] = new PostJSON(ps[j],cjs);
            }
            return new ResourceJSON(r,rs,fs,pjs);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/delete/{id}")
    public ResourceJSON deleteResource(@RequestHeader(value="Authorization") String token, @PathVariable int id){
        Claims cl = JWTUtil.decodeJWT(token);
        if(cl==null) return null;
        return rb.delResource(id, (int) cl.get("idUser"));
    }

}
