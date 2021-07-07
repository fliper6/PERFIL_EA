package backend.beans;

import backend.beans.locals.UserLocal;
import backend.dao.*;
import backend.json.*;
import backend.util.JWTUtil;
import org.springframework.stereotype.Component;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Stateless(name = "UserEJB")
@Local(UserLocal.class)
@Component
public class UserBean {

    public UserJSON[] getUsers(){
        try{
            Users[] us = UsersDAO.listUsersByQuery(null,null);
            UserJSON[] s = new UserJSON[us.length];
            for(int i = 0; i < us.length; i++){
                s[i] = new UserJSON(us[i]);
            }
            return s;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public UserJSON getUser(int id){
        try {
            Users u = UsersDAO.getUsersByORMID(id);
            if(u!=null){
                return new UserJSON(u);
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

    public String getUserPicture(int id){
        try {
            String u = UsersDAO.getUsersByORMID(id).getPicture();
            return "{\"picture\":\"" + u + "\"}";
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public UserJSON changeUserInfo(Integer id, UserProfileJSON upj){
        try{
            Roles r = new Roles();
            r.setAffiliation(upj.getAffiliation());
            r.setType(upj.getType());
            RolesDAO.save(r);
            Users u = UsersDAO.getUsersByORMID(id);
            u.setDescription(upj.getDescription());
            u.setName(upj.getName());
            u.setIdRole(r);
            UsersDAO.save(u);
            return new UserJSON(u);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String login(AuthenticationJSON aj) {
        try{
            Users u = UsersDAO.loadUsersByQuery("email = '" + aj.getEmail() + "'", null);
            return JWTUtil.createJWT("Grupo 03", "EA", 0, u);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public UserJSON register(RegisterJSON rj) {
        try{
            Roles r = new Roles();
            r.setType(rj.getType());
            r.setAffiliation(rj.getAffiliation());
            RolesDAO.save(r);
            Users u = new Users();
            u.setIdRole(r);
            u.setPicture("1.jpg");
            u.setName(rj.getName());
            u.setEmail(rj.getEmail());
            u.setPassword(rj.getPassword());
            u.setLevel("produtor");
            u.setRegisterDate(rj.getRegisterDate());
            u.setDescription(rj.getDescription());
            u.setBlocked(false);
            UsersDAO.save(u);
            return new UserJSON(u);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public TimelineJSON[] getTimeline(int id){
        try{
            Updates[] us = UpdatesDAO.listUpdatesByQuery("idUser="+id,"createdAt DESC");
            HashMap<String, ArrayList<SingleTimeline>> hm = new HashMap<>();
            for(Updates u : us){
                String[] datetime = u.getCreatedAt().toString().split(" ");
                String date = datetime[0];
                String time = datetime[1].split("[.]")[0];
                String state = u.getState();
                if(!hm.containsKey(date)){
                    hm.put(date,new ArrayList<>());
                }
                hm.get(date).add(new SingleTimeline(state,time));
            }
            int i = 0;
            TimelineJSON[] tj = new TimelineJSON[hm.size()];
            for(Map.Entry<String,ArrayList<SingleTimeline>> entry : hm.entrySet()){
                ArrayList<SingleTimeline> a = entry.getValue();
                SingleTimeline[] stl = new SingleTimeline[a.size()];
                for(int j = 0; j < a.size(); j++){
                    stl[j] = a.get(j);
                }
                tj[i] = new TimelineJSON(entry.getKey(), stl);
                i++;
            }
            return tj;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
