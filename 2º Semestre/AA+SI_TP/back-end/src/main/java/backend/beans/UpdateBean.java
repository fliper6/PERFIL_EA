package backend.beans;

import backend.beans.locals.UpdateLocal;
import backend.dao.*;
import backend.json.*;
import org.springframework.stereotype.Component;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "FileSystemEJB")
@Local(UpdateLocal.class)
@Component
public class UpdateBean {

    public UpdateJSON[] getUpdates(){
        try{
            Updates[] us = UpdatesDAO.listUpdatesByQuery(null,null);
            UpdateJSON[] s = new UpdateJSON[us.length];
            for(int i = 0; i < us.length; i++){
                s[i] = new UpdateJSON(us[i]);
            }
            return s;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public UpdateJSON[] getUpdatesUser(int idUser){
        try{
            Updates[] us = UpdatesDAO.listUpdatesByQuery("idUser="+idUser,null);
            UpdateJSON[] s = new UpdateJSON[us.length];
            for(int i = 0; i < us.length; i++){
                s[i] = new UpdateJSON(us[i]);
            }
            return s;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public UpdateJSON createUpdate(int idUser, String state, Resources r, java.sql.Timestamp ts) {
        try{
            Updates up = new Updates();
            up.setCreatedAt(ts);
            up.setIdResource(r);
            up.setIdUser(UsersDAO.getUsersByORMID(idUser));
            up.setState(state);
            UpdatesDAO.save(up);
            return new UpdateJSON(up);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public UpdateJSON[] changeState(int idResource, SimpleStateJSON state){
        try{
            Updates[] us = UpdatesDAO.listUpdatesByQuery("idResource="+idResource,null);
            UpdateJSON[] j = new UpdateJSON[us.length];
            for(int i = 0; i < us.length; i++){
                us[i].setState(state.getState());
                us[i].setCreatedAt(state.getCreatedAt());
                UpdatesDAO.save(us[i]);
                j[i] = new UpdateJSON(us[i]);
            }
            return j;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
