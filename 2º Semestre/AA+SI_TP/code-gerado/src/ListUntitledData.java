/**
 * Licensee: Filipa Santos(Universidade do Minho)
 * License Type: Academic
 */
import org.orm.*;
public class ListUntitledData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Comments...");
		Comments[] commentses = CommentsDAO.listCommentsByQuery(null, null);
		int length = Math.min(commentses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commentses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Files...");
		Files[] fileses = FilesDAO.listFilesByQuery(null, null);
		length = Math.min(fileses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(fileses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Posts...");
		Posts[] postses = PostsDAO.listPostsByQuery(null, null);
		length = Math.min(postses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(postses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Ratings...");
		Ratings[] ratingses = RatingsDAO.listRatingsByQuery(null, null);
		length = Math.min(ratingses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ratingses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Resources...");
		Resources[] resourceses = ResourcesDAO.listResourcesByQuery(null, null);
		length = Math.min(resourceses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(resourceses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Resourcetypes...");
		Resourcetypes[] resourcetypeses = ResourcetypesDAO.listResourcetypesByQuery(null, null);
		length = Math.min(resourcetypeses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(resourcetypeses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Roles...");
		Roles[] roleses = RolesDAO.listRolesByQuery(null, null);
		length = Math.min(roleses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(roleses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Updates...");
		Updates[] updateses = UpdatesDAO.listUpdatesByQuery(null, null);
		length = Math.min(updateses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(updateses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Users...");
		Users[] userses = UsersDAO.listUsersByQuery(null, null);
		length = Math.min(userses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(userses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Comments by Criteria...");
		CommentsCriteria commentsCriteria = new CommentsCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//commentsCriteria.idComment.eq();
		commentsCriteria.setMaxResults(ROW_COUNT);
		Comments[] commentses = commentsCriteria.listComments();
		int length =commentses== null ? 0 : Math.min(commentses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commentses[i]);
		}
		System.out.println(length + " Comments record(s) retrieved."); 
		
		System.out.println("Listing Files by Criteria...");
		FilesCriteria filesCriteria = new FilesCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//filesCriteria.idFile.eq();
		filesCriteria.setMaxResults(ROW_COUNT);
		Files[] fileses = filesCriteria.listFiles();
		length =fileses== null ? 0 : Math.min(fileses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(fileses[i]);
		}
		System.out.println(length + " Files record(s) retrieved."); 
		
		System.out.println("Listing Posts by Criteria...");
		PostsCriteria postsCriteria = new PostsCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//postsCriteria.idPost.eq();
		postsCriteria.setMaxResults(ROW_COUNT);
		Posts[] postses = postsCriteria.listPosts();
		length =postses== null ? 0 : Math.min(postses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(postses[i]);
		}
		System.out.println(length + " Posts record(s) retrieved."); 
		
		System.out.println("Listing Ratings by Criteria...");
		RatingsCriteria ratingsCriteria = new RatingsCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ratingsCriteria.idRatings.eq();
		ratingsCriteria.setMaxResults(ROW_COUNT);
		Ratings[] ratingses = ratingsCriteria.listRatings();
		length =ratingses== null ? 0 : Math.min(ratingses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ratingses[i]);
		}
		System.out.println(length + " Ratings record(s) retrieved."); 
		
		System.out.println("Listing Resources by Criteria...");
		ResourcesCriteria resourcesCriteria = new ResourcesCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//resourcesCriteria.idResource.eq();
		resourcesCriteria.setMaxResults(ROW_COUNT);
		Resources[] resourceses = resourcesCriteria.listResources();
		length =resourceses== null ? 0 : Math.min(resourceses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(resourceses[i]);
		}
		System.out.println(length + " Resources record(s) retrieved."); 
		
		System.out.println("Listing Resourcetypes by Criteria...");
		ResourcetypesCriteria resourcetypesCriteria = new ResourcetypesCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//resourcetypesCriteria.idResourceType.eq();
		resourcetypesCriteria.setMaxResults(ROW_COUNT);
		Resourcetypes[] resourcetypeses = resourcetypesCriteria.listResourcetypes();
		length =resourcetypeses== null ? 0 : Math.min(resourcetypeses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(resourcetypeses[i]);
		}
		System.out.println(length + " Resourcetypes record(s) retrieved."); 
		
		System.out.println("Listing Roles by Criteria...");
		RolesCriteria rolesCriteria = new RolesCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//rolesCriteria.idRole.eq();
		rolesCriteria.setMaxResults(ROW_COUNT);
		Roles[] roleses = rolesCriteria.listRoles();
		length =roleses== null ? 0 : Math.min(roleses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(roleses[i]);
		}
		System.out.println(length + " Roles record(s) retrieved."); 
		
		System.out.println("Listing Updates by Criteria...");
		UpdatesCriteria updatesCriteria = new UpdatesCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//updatesCriteria.idUpdate.eq();
		updatesCriteria.setMaxResults(ROW_COUNT);
		Updates[] updateses = updatesCriteria.listUpdates();
		length =updateses== null ? 0 : Math.min(updateses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(updateses[i]);
		}
		System.out.println(length + " Updates record(s) retrieved."); 
		
		System.out.println("Listing Users by Criteria...");
		UsersCriteria usersCriteria = new UsersCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//usersCriteria.idUser.eq();
		usersCriteria.setMaxResults(ROW_COUNT);
		Users[] userses = usersCriteria.listUsers();
		length =userses== null ? 0 : Math.min(userses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(userses[i]);
		}
		System.out.println(length + " Users record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListUntitledData listUntitledData = new ListUntitledData();
			try {
				listUntitledData.listTestData();
				//listUntitledData.listByCriteria();
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
