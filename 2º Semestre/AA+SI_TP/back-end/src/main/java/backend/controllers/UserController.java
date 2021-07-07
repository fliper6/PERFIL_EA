package backend.controllers;

import backend.beans.FileSystemBean;
import backend.beans.UserBean;
import backend.json.*;
import backend.util.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.activation.FileTypeMap;
import javax.ejb.EJB;
import java.io.File;
import java.nio.file.Files;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/user")
public class UserController {

    @EJB
    UserBean ub;
    @EJB
    FileSystemBean fsb;

    @GetMapping("/")
    public UserJSON[] getUsers(){
        return ub.getUsers();
    }

    @GetMapping( "/image/thumbnail/{name}")
    public ResponseEntity<byte[]> getImage(@PathVariable String name) throws Exception{
        File img = fsb.getImage(name);
        return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));
    }

    @GetMapping("/image/{id}")
    public String getImage(@PathVariable Integer id){
        String u = ub.getUserPicture(id);
        if(u!=null){
            return u;
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        }
    }
    
    @GetMapping("/{id}")
    public UserJSON getUser(@PathVariable Integer id){
        UserJSON u = ub.getUser(id);
        if(u!=null){
            return u;
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        }
    }

    @GetMapping("/timeline/{id}")
    public TimelineJSON[] getTimeline(@PathVariable int id){
        return ub.getTimeline(id);
    }

    @PostMapping("/update/{id}")
    public UserJSON changeUserInfo(@RequestHeader(value="Authorization") String token, @PathVariable Integer id, @RequestBody UserProfileJSON upj){
        Claims cl = JWTUtil.decodeJWT(token);
        if(cl==null || id!=(int)cl.get("idUser")) return null;
        return ub.changeUserInfo(id,upj);
    }

    @PostMapping("/image/{id}")
    public String changePicture(@RequestHeader(value="Authorization") String token, @PathVariable Integer id,@RequestParam("image") MultipartFile image){
        Claims cl = JWTUtil.decodeJWT(token);
        if(cl==null || id!=(int)cl.get("idUser")) return null;
        return fsb.savePicture(image, id);
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthenticationJSON aj){
        String token = ub.login(aj);
        if(token!=null){
            return token;
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        }
    }

    @PostMapping("/register")
    public UserJSON register(@RequestBody RegisterJSON rj){
        UserJSON uj = ub.register(rj);
        if( uj !=null) {
            //fsb.savePicture(image,uj.getIdUser());
            return uj;
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        }
    }

    @PostMapping("/token")
    public Claims decodeToken(@RequestBody String token){
        return JWTUtil.decodeJWT(token);
    }

}
