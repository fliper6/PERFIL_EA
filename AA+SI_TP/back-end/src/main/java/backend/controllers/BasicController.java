package backend.controllers;

import backend.dao.Users;
import backend.dao.UsersDAO;
import backend.json.UserJSON;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.ejb.EJB;
import java.nio.file.*;

@RestController
public class BasicController {
    private static String uploadDirectory = System.getProperty("user.dir")+"\\uploads";

    @GetMapping("/test")
    public UserJSON helloWorld() throws Exception{
        //Context c = new InitialContext();
        //AuthenticationBean aBean = (AuthenticationBean) c.lookup("java:module/AuthenticationEJB");
        Users u = UsersDAO.getUsersByORMID(13);
        //ab.login(u.getEmail(),u.getPassword());
        return new UserJSON(u);
    }

    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String customerSubmit(@RequestParam("files") MultipartFile[] files) {
        System.out.println(uploadDirectory);
        StringBuilder fileNames = new StringBuilder();
        String path1 = "";
        for (MultipartFile file : files) {
            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
            fileNames.append(file.getOriginalFilename()+" ");
            try {
                Files.write(fileNameAndPath, file.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
            path1=fileNameAndPath.toString();
        }

        return path1;
    }

}
