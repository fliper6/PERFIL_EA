package backend.dao; /**
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

public class CommentsDAO {
	public static Comments loadCommentsByORMID(int idComment) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadCommentsByORMID(session, idComment);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Comments getCommentsByORMID(int idComment) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return getCommentsByORMID(session, idComment);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Comments loadCommentsByORMID(int idComment, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadCommentsByORMID(session, idComment, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Comments getCommentsByORMID(int idComment, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return getCommentsByORMID(session, idComment, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Comments loadCommentsByORMID(PersistentSession session, int idComment) throws PersistentException {
		try {
			return (Comments) session.load(Comments.class, new Integer(idComment));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Comments getCommentsByORMID(PersistentSession session, int idComment) throws PersistentException {
		try {
			return (Comments) session.get(Comments.class, new Integer(idComment));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Comments loadCommentsByORMID(PersistentSession session, int idComment, LockMode lockMode) throws PersistentException {
		try {
			return (Comments) session.load(Comments.class, new Integer(idComment), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Comments getCommentsByORMID(PersistentSession session, int idComment, LockMode lockMode) throws PersistentException {
		try {
			return (Comments) session.get(Comments.class, new Integer(idComment), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryComments(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return queryComments(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryComments(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return queryComments(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Comments[] listCommentsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return listCommentsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Comments[] listCommentsByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return listCommentsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryComments(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Comments as Comments");
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
	
	public static List queryComments(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Comments as Comments");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Comments", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Comments[] listCommentsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryComments(session, condition, orderBy);
			return (Comments[]) list.toArray(new Comments[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Comments[] listCommentsByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			List list = queryComments(session, condition, orderBy, lockMode);
			return (Comments[]) list.toArray(new Comments[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Comments loadCommentsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadCommentsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Comments loadCommentsByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadCommentsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Comments loadCommentsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Comments[] commentses = listCommentsByQuery(session, condition, orderBy);
		if (commentses != null && commentses.length > 0)
			return commentses[0];
		else
			return null;
	}
	
	public static Comments loadCommentsByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		Comments[] commentses = listCommentsByQuery(session, condition, orderBy, lockMode);
		if (commentses != null && commentses.length > 0)
			return commentses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCommentsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return iterateCommentsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCommentsByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return iterateCommentsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCommentsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Comments as Comments");
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
	
	public static java.util.Iterator iterateCommentsByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Comments as Comments");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Comments", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Comments createComments() {
		return new Comments();
	}
	
	public static boolean save(Comments comments) throws PersistentException {
		try {
			UntitledPersistentManager.instance().saveObject(comments);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Comments comments) throws PersistentException {
		try {
			UntitledPersistentManager.instance().deleteObject(comments);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Comments comments)throws PersistentException {
		try {
			if (comments.getIdUser() != null) {
				comments.getIdUser().comments.remove(comments);
			}
			
			if (comments.getIdPost() != null) {
				comments.getIdPost().comments.remove(comments);
			}
			
			return delete(comments);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Comments comments, PersistentSession session)throws PersistentException {
		try {
			if (comments.getIdUser() != null) {
				comments.getIdUser().comments.remove(comments);
			}
			
			if (comments.getIdPost() != null) {
				comments.getIdPost().comments.remove(comments);
			}
			
			try {
				session.delete(comments);
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
	
	public static boolean refresh(Comments comments) throws PersistentException {
		try {
			UntitledPersistentManager.instance().getSession().refresh(comments);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Comments comments) throws PersistentException {
		try {
			UntitledPersistentManager.instance().getSession().evict(comments);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Comments loadCommentsByCriteria(CommentsCriteria commentsCriteria) {
		Comments[] commentses = listCommentsByCriteria(commentsCriteria);
		if(commentses == null || commentses.length == 0) {
			return null;
		}
		return commentses[0];
	}
	
	public static Comments[] listCommentsByCriteria(CommentsCriteria commentsCriteria) {
		return commentsCriteria.listComments();
	}
}
