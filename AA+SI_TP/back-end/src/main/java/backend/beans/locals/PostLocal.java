package backend.beans.locals;
import backend.json.CreatePostJSON;
import backend.json.PostJSON;
import backend.json.SimpleCommentJSON;

import javax.ejb.Local;

@Local
public interface PostLocal {
    PostJSON[] getPosts();
    PostJSON createPost(CreatePostJSON cpj);
    PostJSON updatePost(int id, CreatePostJSON cpj);
    PostJSON getPost(int id);
    PostJSON addComment(int id, int idUser, SimpleCommentJSON cj);
    PostJSON changeComment(int id, int idUser, SimpleCommentJSON cj);
    PostJSON deleteComment(int id, int idUser);
}
