package backend.controllers;

import backend.beans.PostBean;
import backend.json.*;
import backend.util.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.*;

import javax.ejb.EJB;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/post")
public class PostController {
    @EJB
    PostBean pb;

    @GetMapping("/")
    public PostJSON[] getPosts(){
        return pb.getPosts();
    }

    @GetMapping("/{id}")
    public PostJSON getPost(@PathVariable int id){
        return pb.getPost(id);
    }

    @PostMapping("/")
    public PostJSON create(@RequestHeader(value="Authorization") String token, @RequestParam String title, @RequestParam String body, @RequestParam java.sql.Timestamp createdAt, @RequestParam int idResource){
        Claims cl = JWTUtil.decodeJWT(token);
        if(cl==null) return null;
        return pb.createPost(new CreatePostJSON(title,body,createdAt,(int) cl.get("idUser"),idResource));
    }

    @PostMapping("/update/{id}")
    public PostJSON updatePost(@RequestHeader(value="Authorization") String token, @PathVariable int id, @RequestBody UpdatePostJSON upj){
        Claims cl = JWTUtil.decodeJWT(token);
        if(cl==null) return null;
        return pb.updatePost(id,new CreatePostJSON(upj.getTitle(), upj.getBody(),null,(int) cl.get("idUser"),0));
    }

    @PostMapping("/comment/update/{id}")
    public PostJSON changeComment(@RequestHeader(value="Authorization") String token, @PathVariable int id, @RequestBody SimpleCommentJSON scj){
        Claims cl = JWTUtil.decodeJWT(token);
        if(cl==null) return null;
        return pb.changeComment(id,(int) cl.get("idUser"),scj);
    }

    @PostMapping("/comment/delete/{id}")
    public PostJSON deleteComment(@RequestHeader(value="Authorization") String token, @PathVariable int id){
        Claims cl = JWTUtil.decodeJWT(token);
        if(cl==null) return null;
        return pb.deleteComment(id,(int) cl.get("idUser"));
    }

    @PostMapping("/delete/{id}")
    public PostJSON deletePost(@RequestHeader(value="Authorization") String token, @PathVariable int id){
        Claims cl = JWTUtil.decodeJWT(token);
        if(cl==null) return null;
        return pb.deletePost(id,(int) cl.get("idUser"));
    }

    @PostMapping("/comment/{id}")
    public PostJSON commentPost(@RequestHeader(value="Authorization") String token, @PathVariable int id, @RequestBody SimpleCommentJSON scj){
        Claims cl = JWTUtil.decodeJWT(token);
        if(cl==null) return null;
        return pb.addComment(id,(int) cl.get("idUser"),scj);
    }
}
