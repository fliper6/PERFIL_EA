package backend.dao; /**
 * Licensee: Filipa Santos(Universidade do Minho)
 * License Type: Academic
 */
import org.orm.*;
public class DeleteUntitledData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = UntitledPersistentManager.instance().getSession().beginTransaction();
		try {
			Comments comments = CommentsDAO.loadCommentsByQuery(null, null);
			// Delete the persistent object
			CommentsDAO.delete(comments);
			Files files = FilesDAO.loadFilesByQuery(null, null);
			// Delete the persistent object
			FilesDAO.delete(files);
			Posts posts = PostsDAO.loadPostsByQuery(null, null);
			// Delete the persistent object
			PostsDAO.delete(posts);
			Ratings ratings = RatingsDAO.loadRatingsByQuery(null, null);
			// Delete the persistent object
			RatingsDAO.delete(ratings);
			Resources resources = ResourcesDAO.loadResourcesByQuery(null, null);
			// Delete the persistent object
			ResourcesDAO.delete(resources);
			Resourcetypes resourcetypes = ResourcetypesDAO.loadResourcetypesByQuery(null, null);
			// Delete the persistent object
			ResourcetypesDAO.delete(resourcetypes);
			Roles roles = RolesDAO.loadRolesByQuery(null, null);
			// Delete the persistent object
			RolesDAO.delete(roles);
			Updates updates = UpdatesDAO.loadUpdatesByQuery(null, null);
			// Delete the persistent object
			UpdatesDAO.delete(updates);
			Users users = UsersDAO.loadUsersByQuery(null, null);
			// Delete the persistent object
			UsersDAO.delete(users);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteUntitledData deleteUntitledData = new DeleteUntitledData();
			try {
				deleteUntitledData.deleteTestData();
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
