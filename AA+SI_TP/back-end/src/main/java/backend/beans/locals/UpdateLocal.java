package backend.beans.locals;


import backend.dao.Resources;
import backend.json.CreateUpdateJSON;
import backend.json.SimpleStateJSON;
import backend.json.UpdateJSON;

import javax.ejb.Local;

@Local
public interface UpdateLocal {
    UpdateJSON[] getUpdatesUser(int idUser);
    UpdateJSON[] getUpdates();
    UpdateJSON createUpdate(int idUser, String state, Resources r, java.sql.Timestamp ts);
    UpdateJSON[] changeState(int idResource, SimpleStateJSON state);
}
