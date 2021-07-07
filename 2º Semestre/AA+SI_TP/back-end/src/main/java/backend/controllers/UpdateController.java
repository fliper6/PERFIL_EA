package backend.controllers;

import backend.beans.UpdateBean;
import backend.json.CreateUpdateJSON;
import backend.json.SimpleStateJSON;
import backend.json.UpdateJSON;
import org.springframework.web.bind.annotation.*;

import javax.ejb.EJB;
import javax.ws.rs.Path;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/update")
public class UpdateController {
    @EJB
    UpdateBean ub;

    @GetMapping("/")
    public UpdateJSON[] getUpdates(){
        return ub.getUpdates();
    }

    @GetMapping("/{idUser}")
    public UpdateJSON[] getUpdatesUser(@PathVariable int idUser){
        return ub.getUpdatesUser(idUser);
    }

    /*
    @PostMapping("/")
    public UpdateJSON createUpdate(@RequestBody CreateUpdateJSON cuj){
        return ub.createUpdate(cuj);
    }

    @PostMapping("/changestate/{idResource}")
    public UpdateJSON[] changeState(@PathVariable int idResource, @RequestBody SimpleStateJSON ssj){
        return ub.changeState(idResource,ssj);
    }
    */
}
