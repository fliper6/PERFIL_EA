/**
 * Licensee: Filipa Santos(Universidade do Minho)
 * License Type: Academic
 */
import org.orm.*;
public class RetrieveAndUpdateUntitledData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = UntitledPersistentManager.instance().getSession().beginTransaction();
		try {
			Comments comments = CommentsDAO.loadCommentsByQuery(null, null);
			// Update the properties of the persistent object
			CommentsDAO.save(comments);
			Files files = FilesDAO.loadFilesByQuery(null, null);
			// Update the properties of the persistent object
			FilesDAO.save(files);
			Posts posts = PostsDAO.loadPostsByQuery(null, null);
			// Update the properties of the persistent object
			PostsDAO.save(posts);
			Ratings ratings = RatingsDAO.loadRatingsByQuery(null, null);
			// Update the properties of the persistent object
			RatingsDAO.save(ratings);
			Resources resources = ResourcesDAO.loadResourcesByQuery(null, null);
			// Update the properties of the persistent object
			ResourcesDAO.save(resources);
			Resourcetypes resourcetypes = ResourcetypesDAO.loadResourcetypesByQuery(null, null);
			// Update the properties of the persistent object
			ResourcetypesDAO.save(resourcetypes);
			Roles roles = RolesDAO.loadRolesByQuery(null, null);
			// Update the properties of the persistent object
			RolesDAO.save(roles);
			Updates updates = UpdatesDAO.loadUpdatesByQuery(null, null);
			// Update the properties of the persistent object
			UpdatesDAO.save(updates);
			Users users = UsersDAO.loadUsersByQuery(null, null);
			// Update the properties of the persistent object
			UsersDAO.save(users);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Comments by CommentsCriteria");
		CommentsCriteria commentsCriteria = new CommentsCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//commentsCriteria.idComment.eq();
		System.out.println(commentsCriteria.uniqueComments());
		
		System.out.println("Retrieving Files by FilesCriteria");
		FilesCriteria filesCriteria = new FilesCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//filesCriteria.idFile.eq();
		System.out.println(filesCriteria.uniqueFiles());
		
		System.out.println("Retrieving Posts by PostsCriteria");
		PostsCriteria postsCriteria = new PostsCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//postsCriteria.idPost.eq();
		System.out.println(postsCriteria.uniquePosts());
		
		System.out.println("Retrieving Ratings by RatingsCriteria");
		RatingsCriteria ratingsCriteria = new RatingsCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ratingsCriteria.idRatings.eq();
		System.out.println(ratingsCriteria.uniqueRatings());
		
		System.out.println("Retrieving Resources by ResourcesCriteria");
		ResourcesCriteria resourcesCriteria = new ResourcesCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//resourcesCriteria.idResource.eq();
		System.out.println(resourcesCriteria.uniqueResources());
		
		System.out.println("Retrieving Resourcetypes by ResourcetypesCriteria");
		ResourcetypesCriteria resourcetypesCriteria = new ResourcetypesCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//resourcetypesCriteria.idResourceType.eq();
		System.out.println(resourcetypesCriteria.uniqueResourcetypes());
		
		System.out.println("Retrieving Roles by RolesCriteria");
		RolesCriteria rolesCriteria = new RolesCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//rolesCriteria.idRole.eq();
		System.out.println(rolesCriteria.uniqueRoles());
		
		System.out.println("Retrieving Updates by UpdatesCriteria");
		UpdatesCriteria updatesCriteria = new UpdatesCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//updatesCriteria.idUpdate.eq();
		System.out.println(updatesCriteria.uniqueUpdates());
		
		System.out.println("Retrieving Users by UsersCriteria");
		UsersCriteria usersCriteria = new UsersCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//usersCriteria.idUser.eq();
		System.out.println(usersCriteria.uniqueUsers());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateUntitledData retrieveAndUpdateUntitledData = new RetrieveAndUpdateUntitledData();
			try {
				retrieveAndUpdateUntitledData.retrieveAndUpdateTestData();
				//retrieveAndUpdateUntitledData.retrieveByCriteria();
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
