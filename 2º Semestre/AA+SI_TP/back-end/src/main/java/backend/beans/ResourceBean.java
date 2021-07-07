package backend.beans;

import backend.beans.locals.ResourceLocal;
import backend.dao.*;
import backend.json.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.time.Instant;
import java.util.ArrayList;

@Stateless(name = "PostBeanEJB")
@Local(ResourceLocal.class)
@Component
public class ResourceBean {
    @EJB
    UpdateBean ub;

    public Resources createResource(CreateResourceJSON crj){
        try{
           java.sql.Timestamp ts = java.sql.Timestamp.from(Instant.now());
           Resources r = new Resources();
           r.setTitle(crj.getTitle());
           r.setDescription(crj.getDescription());
           r.setCreatedAt(ts);
           r.setRegisteredAt(crj.getRegisteredAt());
           r.setLastModifiedAt(ts);
           r.setVisibility(crj.getVisibility());
           r.setnDownloads(0);
           r.setAvailable(true);
           r.setIdUser(UsersDAO.getUsersByORMID(crj.getIdUser()));
           Resourcetypes rt = ResourcetypesDAO.loadResourcetypesByQuery("type='"+crj.getType()+"'",null);
           if(rt==null){
               rt = new Resourcetypes();
               rt.setType(crj.getType());
               ResourcetypesDAO.save(rt);
           }
           r.setIdResourceType(rt);
           ResourcesDAO.save(r);
           ub.createUpdate(crj.getIdUser(),"Novo Recurso",r,ts);
           return r;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Resources updateResource(UpdateResourceJSON crj, int idUser){
        try{
            if(crj.getIdUser()!=idUser) return null;
            java.sql.Timestamp ts = java.sql.Timestamp.from(Instant.now());
            Resources r = ResourcesDAO.getResourcesByORMID(crj.getIdResource());
            r.setTitle(crj.getTitle());
            r.setDescription(crj.getDescription());
            r.setRegisteredAt(crj.getRegisteredAt());
            r.setLastModifiedAt(ts);
            r.setVisibility(crj.getVisibility());
            r.setAvailable(true);
            Resourcetypes rt = ResourcetypesDAO.loadResourcetypesByQuery("type='"+crj.getType()+"'",null);
            if(rt==null){
                rt = new Resourcetypes();
                rt.setType(crj.getType());
                ResourcetypesDAO.save(rt);
            }
            r.setIdResourceType(rt);
            ResourcesDAO.save(r);
            ub.createUpdate(crj.getIdUser(),"Update Recurso",r,ts);
            return r;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResourceJSON[] getResources(int idUser) {
        try{
            Resources[] us;
            if(idUser == -1){
                us = ResourcesDAO.listResourcesByQuery("visibility=1",null);
            }
            else {
                us = ResourcesDAO.listResourcesByQuery("visibility=1 or idUser="+idUser,null);
            }
            ResourceJSON[] s = new ResourceJSON[us.length];
            for(int i = 0; i < us.length; i++){
                Ratings[] rs = RatingsDAO.listRatingsByQuery("idResource="+us[i].getIdResource(),null);
                Files[] fs = FilesDAO.listFilesByQuery("idResource="+us[i],null);
                Posts[] ps = PostsDAO.listPostsByQuery("idResource="+us[i],null);
                PostJSON[] pjs = new PostJSON[ps.length];
                for(int j = 0 ; j < ps.length; j++){
                    Comments[] cs = CommentsDAO.listCommentsByQuery("idPost="+ps[j].getIdPost(),null);
                    CommentJSON[] cjs = new CommentJSON[cs.length];
                    for(int x = 0; x < cs.length; x++){
                        cjs[x] = new CommentJSON(cs[x]);
                    }
                    pjs[j] = new PostJSON(ps[j],cjs);
                }
                s[i] = new ResourceJSON(us[i],rs,fs,pjs);
            }
            return s;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResourceJSON[] getResourcesOfType(String t, int idUser) {
        try{
            Resources[] us;
            if(idUser == -1){
                us = ResourcesDAO.listResourcesByQuery("visibility=1",null);
            }
            else {
                us = ResourcesDAO.listResourcesByQuery("visibility=1 or idUser="+idUser,null);
            }
            ArrayList<Resources>  al = new ArrayList<>();
            for(Resources rr : us){
                if(rr.getIdResourceType().getType().equals(t)){
                    al.add(rr);
                }
            }
            us = new Resources[al.size()];
            for(int i = 0; i < al.size(); i++){
                us[i] = al.get(i);
            }
            ResourceJSON[] s = new ResourceJSON[us.length];
            for(int i = 0; i < us.length; i++){
                Posts[] ps = PostsDAO.listPostsByQuery("idResource="+us[i],null);
                PostJSON[] pjs = new PostJSON[ps.length];
                Ratings[] rs = RatingsDAO.listRatingsByQuery("idResource="+us[i].getIdResource(),null);
                Files[] fs = FilesDAO.listFilesByQuery("idResource="+us[i],null);
                for(int j = 0 ; j < ps.length; j++){
                    Comments[] cs = CommentsDAO.listCommentsByQuery("idPost="+ps[j].getIdPost(),null);
                    CommentJSON[] cjs = new CommentJSON[cs.length];
                    for(int x = 0; x < cs.length; x++){
                        cjs[x] = new CommentJSON(cs[x]);
                    }
                    pjs[j] = new PostJSON(ps[j],cjs);
                }
                s[i] = new ResourceJSON(us[i],rs,fs,pjs);
            }
            return s;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResourceJSON getResource(int id, int idUser){
        try {
            Resources u = ResourcesDAO.getResourcesByORMID(id);
            if(u==null) return null;
            if(idUser == -1 && !u.getVisibility()) return null;
            if(idUser!= u.getIdUser().getIdUser() && !u.getVisibility()) return null;
            Ratings[] rs = RatingsDAO.listRatingsByQuery("idResource="+id,null);
            Files[] fs = FilesDAO.listFilesByQuery("idResource="+id,null);
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
            return new ResourceJSON(u,rs,fs,pjs);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public TypesJSON getResourceTypes(){
        try{
            Resourcetypes[] rs = ResourcetypesDAO.listResourcetypesByQuery(null,null);
            String[] s = new String[rs.length];
            for(int i = 0; i < rs.length; i++){
                s[i] = rs[i].getType();
            }
            return new TypesJSON(s);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public RatingsJSON rateResource(int id, int idUser, RateResourceJSON rrj){
        try{
            Ratings r = RatingsDAO.loadRatingsByQuery("idUser=" + idUser + " and idResource="+id,null);
            if(r==null){
                r = new Ratings();
                r.setIdResource(ResourcesDAO.getResourcesByORMID(id));
                r.setIdUser(UsersDAO.getUsersByORMID(idUser));
            }
            r.setRating(rrj.getRating());
            RatingsDAO.save(r);
            return new RatingsJSON(r);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResourceJSON incDownloads(int id){
        try{
            Resources r = ResourcesDAO.getResourcesByORMID(id);
            r.setnDownloads(r.getnDownloads()+1);
            ResourcesDAO.save(r);
            Ratings[] rs = RatingsDAO.listRatingsByQuery("idResource="+id,null);
            Files[] fs = FilesDAO.listFilesByQuery("idResource="+id,null);
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
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResourceJSON delResource(int id, int idUser){
        // FILESYSTEM BEAN REMOVER OS FICHEIROS DO FILESYSTEM
        try{
            Resources r = ResourcesDAO.getResourcesByORMID(id);
            if(r.getIdUser().getIdUser()!=idUser) return null;
            Ratings[] rs = RatingsDAO.listRatingsByQuery("idResource="+id,null);
            Updates[] us = UpdatesDAO.listUpdatesByQuery("idResource="+id,null);
            Files[] fs = FilesDAO.listFilesByQuery("idResource="+id,null);
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
            for (Ratings rr : rs){
                RatingsDAO.delete(rr);
            }
            for (Updates rr : us){
                UpdatesDAO.delete(rr);
            }
            for (Files rr : fs){
                FilesDAO.delete(rr);
            }
            ResourcesDAO.delete(r);
            return new ResourceJSON(r,rs,fs,pjs);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResourceJSON[] getRecentResources(int idUser){
        try{
            Resources[] us1;
            if(idUser == -1){
                us1 = ResourcesDAO.listResourcesByQuery("visibility=1","lastModifiedAt DESC");
            }
            else {
                us1 = ResourcesDAO.listResourcesByQuery("visibility=1 or idUser="+idUser,"lastModifiedAt DESC");
            }
            Resources[] us = new Resources[3];
            for(int i = 0; i < 3; i++){
                us[i] = us1[i];
            }
            ResourceJSON[] s = new ResourceJSON[us.length];
            for(int i = 0; i < us.length; i++){
                Ratings[] rs = RatingsDAO.listRatingsByQuery("idResource="+us[i].getIdResource(),null);
                Files[] fs = FilesDAO.listFilesByQuery("idResource="+us[i],null);
                Posts[] ps = PostsDAO.listPostsByQuery("idResource="+us[i],null);
                PostJSON[] pjs = new PostJSON[ps.length];
                for(int j = 0 ; j < ps.length; j++){
                    Comments[] cs = CommentsDAO.listCommentsByQuery("idPost="+ps[j].getIdPost(),null);
                    CommentJSON[] cjs = new CommentJSON[cs.length];
                    for(int x = 0; x < cs.length; x++){
                        cjs[x] = new CommentJSON(cs[x]);
                    }
                    pjs[j] = new PostJSON(ps[j],cjs);
                }
                s[i] = new ResourceJSON(us[i],rs,fs,pjs);
            }
            return s;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
