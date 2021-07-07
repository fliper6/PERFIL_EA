package backend.beans.locals;

import backend.json.*;

import javax.ejb.Local;

@Local
public interface UserLocal {
    UserJSON[] getUsers();
    UserJSON getUser(int id);
    String getUserPicture(int id);
    UserJSON changeUserInfo(Integer id, UserProfileJSON upj);
    String login(AuthenticationJSON aj);
    UserJSON register(RegisterJSON rj);
    TimelineJSON[] getTimeline(int id);
}
