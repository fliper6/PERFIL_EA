/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Filipa Santos(Universidade do Minho)
 * License Type: Academic
 */
import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class PostsDAO {
	public static Posts loadPostsByORMID(int idPost) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadPostsByORMID(session, idPost);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Posts getPostsByORMID(int idPost) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return getPostsByORMID(session, idPost);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Posts loadPostsByORMID(int idPost, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadPostsByORMID(session, idPost, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Posts getPostsByORMID(int idPost, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return getPostsByORMID(session, idPost, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Posts loadPostsByORMID(PersistentSession session, int idPost) throws PersistentException {
		try {
			return (Posts) session.load(Posts.class, new Integer(idPost));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Posts getPostsByORMID(PersistentSession session, int idPost) throws PersistentException {
		try {
			return (Posts) session.get(Posts.class, new Integer(idPost));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Posts loadPostsByORMID(PersistentSession session, int idPost, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Posts) session.load(Posts.class, new Integer(idPost), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Posts getPostsByORMID(PersistentSession session, int idPost, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Posts) session.get(Posts.class, new Integer(idPost), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPosts(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return queryPosts(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPosts(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return queryPosts(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Posts[] listPostsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return listPostsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Posts[] listPostsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return listPostsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPosts(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Posts as Posts");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPosts(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Posts as Posts");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Posts", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Posts[] listPostsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPosts(session, condition, orderBy);
			return (Posts[]) list.toArray(new Posts[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Posts[] listPostsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPosts(session, condition, orderBy, lockMode);
			return (Posts[]) list.toArray(new Posts[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Posts loadPostsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadPostsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Posts loadPostsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadPostsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Posts loadPostsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Posts[] postses = listPostsByQuery(session, condition, orderBy);
		if (postses != null && postses.length > 0)
			return postses[0];
		else
			return null;
	}
	
	public static Posts loadPostsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Posts[] postses = listPostsByQuery(session, condition, orderBy, lockMode);
		if (postses != null && postses.length > 0)
			return postses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePostsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return iteratePostsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePostsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return iteratePostsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePostsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Posts as Posts");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePostsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Posts as Posts");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Posts", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Posts createPosts() {
		return new Posts();
	}
	
	public static boolean save(Posts posts) throws PersistentException {
		try {
			UntitledPersistentManager.instance().saveObject(posts);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Posts posts) throws PersistentException {
		try {
			UntitledPersistentManager.instance().deleteObject(posts);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Posts posts)throws PersistentException {
		try {
			if (posts.getIdUser() != null) {
				posts.getIdUser().posts.remove(posts);
			}
			
			if (posts.getIdResource() != null) {
				posts.getIdResource().posts.remove(posts);
			}
			
			Comments[] lCommentss = posts.comments.toArray();
			for(int i = 0; i < lCommentss.length; i++) {
				lCommentss[i].setIdPost(null);
			}
			return delete(posts);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Posts posts, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (posts.getIdUser() != null) {
				posts.getIdUser().posts.remove(posts);
			}
			
			if (posts.getIdResource() != null) {
				posts.getIdResource().posts.remove(posts);
			}
			
			Comments[] lCommentss = posts.comments.toArray();
			for(int i = 0; i < lCommentss.length; i++) {
				lCommentss[i].setIdPost(null);
			}
			try {
				session.delete(posts);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(Posts posts) throws PersistentException {
		try {
			UntitledPersistentManager.instance().getSession().refresh(posts);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Posts posts) throws PersistentException {
		try {
			UntitledPersistentManager.instance().getSession().evict(posts);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Posts loadPostsByCriteria(PostsCriteria postsCriteria) {
		Posts[] postses = listPostsByCriteria(postsCriteria);
		if(postses == null || postses.length == 0) {
			return null;
		}
		return postses[0];
	}
	
	public static Posts[] listPostsByCriteria(PostsCriteria postsCriteria) {
		return postsCriteria.listPosts();
	}
}
