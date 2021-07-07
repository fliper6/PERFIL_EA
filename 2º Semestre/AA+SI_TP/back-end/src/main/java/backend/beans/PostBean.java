package backend.beans;

import backend.beans.locals.PostLocal;
import backend.dao.*;
import backend.json.*;
import org.springframework.stereotype.Component;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.time.Instant;

@Stateless(name = "PostBeanEJB")
@Local(PostLocal.class)
@Component
public class PostBean {
    @EJB
    UpdateBean ub;

    public PostJSON[] getPosts(){
        try{
            Posts[] us = PostsDAO.listPostsByQuery(null,null);
            PostJSON[] s = new PostJSON[us.length];
            for(int i = 0; i < us.length; i++){
                Comments[] ps = CommentsDAO.listCommentsByQuery("idPost="+us[i].getIdPost(),null);
                CommentJSON[] cs = new CommentJSON[ps.length];
                for(int x = 0; x < ps.length; x++){
                    cs[x] = new CommentJSON(ps[x]);
                }
                s[i] = new PostJSON(us[i],cs);
            }
            return s;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public PostJSON createPost(CreatePostJSON cpj) {
        try{
            Posts p = new Posts();
            p.setTitle(cpj.getTitle());
            p.setBody(cpj.getBody());
            p.setCreatedAt(cpj.getCreatedAt());
            p.setIdResource(ResourcesDAO.getResourcesByORMID(cpj.getIdResource()));
            p.setIdUser(UsersDAO.getUsersByORMID(cpj.getIdUser()));
            PostsDAO.save(p);
            ub.createUpdate(cpj.getIdUser(),"Novo Post",ResourcesDAO.getResourcesByORMID(cpj.getIdResource()),java.sql.Timestamp.from(Instant.now()));
            return new PostJSON(p, new CommentJSON[0]);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public PostJSON updatePost(int id, CreatePostJSON cpj) {
        try{
            Posts p = PostsDAO.getPostsByORMID(id);
            if(p.getIdUser().getIdUser() != cpj.getIdUser()) return null;
            p.setTitle(cpj.getTitle());
            p.setBody(cpj.getBody());
            p.setIdUser(UsersDAO.getUsersByORMID(cpj.getIdUser()));
            PostsDAO.save(p);
            return new PostJSON(p, new CommentJSON[0]);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public PostJSON getPost(int id){
        try {
            Posts u = PostsDAO.getPostsByORMID(id);
            Comments[] ps = CommentsDAO.listCommentsByQuery("idPost="+id,null);
            CommentJSON[] s = new CommentJSON[ps.length];
            for(int i = 0; i < ps.length; i++){
                s[i] = new CommentJSON(ps[i]);
            }
            if(u!=null){
                return new PostJSON(u,s);
            }
            else {
                return null;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public PostJSON addComment(int id, int idUser, SimpleCommentJSON cj){
        try{
            Posts p = PostsDAO.getPostsByORMID(id);
            Users u = UsersDAO.getUsersByORMID(idUser);
            Comments c = new Comments();
            c.setBody(cj.getBody());
            c.setIdPost(p);
            c.setCreatedAt(cj.getCreatedAt());
            c.setIdUser(u);
            CommentsDAO.save(c);
            Comments[] ps = CommentsDAO.listCommentsByQuery("idPost="+id,null);
            CommentJSON[] s = new CommentJSON[ps.length];
            for(int i = 0; i < ps.length; i++){
                s[i] = new CommentJSON(ps[i]);
            }
            return new PostJSON(p,s);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public PostJSON changeComment(int id, int idUser, SimpleCommentJSON cj){
        try{
            Comments c = CommentsDAO.getCommentsByORMID(id);
            if (c.getIdUser().getIdUser() != idUser) return null;
            c.setBody(cj.getBody());
            c.setCreatedAt(cj.getCreatedAt());
            CommentsDAO.save(c);
            Comments[] ps = CommentsDAO.listCommentsByQuery("idPost="+c.getIdPost().getIdPost(),null);
            CommentJSON[] s = new CommentJSON[ps.length];
            for(int i = 0; i < ps.length; i++){
                s[i] = new CommentJSON(ps[i]);
            }
            return new PostJSON(c.getIdPost(),s);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public PostJSON deleteComment(int id, int idUser){
        try{
            Comments c = CommentsDAO.getCommentsByORMID(id);
            if (c.getIdUser().getIdUser() != idUser) return null;
            Posts p = c.getIdPost();
            int post = p.getIdPost();
            CommentsDAO.deleteAndDissociate(c);
            Comments[] cs = CommentsDAO.listCommentsByQuery("idPost="+post,null);
            CommentJSON[] s = new CommentJSON[cs.length];
            for(int i = 0; i < cs.length; i++){
                s[i] = new CommentJSON(cs[i]);
            }
            return new PostJSON(p,s);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public PostJSON deletePost(int id, int idUser){
        try{
            Posts p = PostsDAO.getPostsByORMID(id);
            if(p.getIdUser().getIdUser() != idUser) return null;
            Comments[] cs = CommentsDAO.listCommentsByQuery("idPost="+id,null);
            CommentJSON[] s = new CommentJSON[cs.length];
            for(int i = 0; i < cs.length; i++){
                s[i] = new CommentJSON(cs[i]);
                CommentsDAO.deleteAndDissociate(cs[i]);
            }
            PostsDAO.deleteAndDissociate(p);
            return new PostJSON(p, s);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
