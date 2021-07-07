/**
 * Licensee: Filipa Santos(Universidade do Minho)
 * License Type: Academic
 */
import org.orm.*;
public class CreateUntitledData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = UntitledPersistentManager.instance().getSession().beginTransaction();
		try {
			Comments comments = CommentsDAO.createComments();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : idPost, idUser, createdAt, body
			CommentsDAO.save(comments);
			Files files = FilesDAO.createFiles();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : idResource, path, mimetype, name
			FilesDAO.save(files);
			Posts posts = PostsDAO.createPosts();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : comments, idResource, idUser, createdAt, body
			PostsDAO.save(posts);
			Ratings ratings = RatingsDAO.createRatings();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : idUser, idResource, rating
			RatingsDAO.save(ratings);
			Resources resources = ResourcesDAO.createResources();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : updates, ratings, posts, files, idResourceType, available, nDownloads, visibility, lastModifiedAt, registeredAt, createdAt, description, title
			ResourcesDAO.save(resources);
			Resourcetypes resourcetypes = ResourcetypesDAO.createResourcetypes();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : resources, type
			ResourcetypesDAO.save(resourcetypes);
			Roles roles = RolesDAO.createRoles();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : users, affiliation, type
			RolesDAO.save(roles);
			Updates updates = UpdatesDAO.createUpdates();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : idResource, idUser, createdAt, state
			UpdatesDAO.save(updates);
			Users users = UsersDAO.createUsers();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : updates, ratings, posts, comments, idRole, blocked, picture, description, registerDate, level, password, email
			UsersDAO.save(users);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateUntitledData createUntitledData = new CreateUntitledData();
			try {
				createUntitledData.createTestData();
			}
			finally {
				UntitledPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
