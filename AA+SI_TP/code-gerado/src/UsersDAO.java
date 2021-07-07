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

public class UsersDAO {
	public static Users loadUsersByORMID(int idUser) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadUsersByORMID(session, idUser);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Users getUsersByORMID(int idUser) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return getUsersByORMID(session, idUser);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Users loadUsersByORMID(int idUser, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadUsersByORMID(session, idUser, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Users getUsersByORMID(int idUser, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return getUsersByORMID(session, idUser, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Users loadUsersByORMID(PersistentSession session, int idUser) throws PersistentException {
		try {
			return (Users) session.load(Users.class, new Integer(idUser));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Users getUsersByORMID(PersistentSession session, int idUser) throws PersistentException {
		try {
			return (Users) session.get(Users.class, new Integer(idUser));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Users loadUsersByORMID(PersistentSession session, int idUser, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Users) session.load(Users.class, new Integer(idUser), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Users getUsersByORMID(PersistentSession session, int idUser, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Users) session.get(Users.class, new Integer(idUser), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsers(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return queryUsers(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsers(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return queryUsers(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Users[] listUsersByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return listUsersByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Users[] listUsersByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return listUsersByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsers(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Users as Users");
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
	
	public static List queryUsers(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Users as Users");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Users", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Users[] listUsersByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryUsers(session, condition, orderBy);
			return (Users[]) list.toArray(new Users[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Users[] listUsersByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryUsers(session, condition, orderBy, lockMode);
			return (Users[]) list.toArray(new Users[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Users loadUsersByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadUsersByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Users loadUsersByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadUsersByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Users loadUsersByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Users[] userses = listUsersByQuery(session, condition, orderBy);
		if (userses != null && userses.length > 0)
			return userses[0];
		else
			return null;
	}
	
	public static Users loadUsersByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Users[] userses = listUsersByQuery(session, condition, orderBy, lockMode);
		if (userses != null && userses.length > 0)
			return userses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUsersByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return iterateUsersByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsersByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return iterateUsersByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsersByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Users as Users");
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
	
	public static java.util.Iterator iterateUsersByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Users as Users");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Users", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Users createUsers() {
		return new Users();
	}
	
	public static boolean save(Users users) throws PersistentException {
		try {
			UntitledPersistentManager.instance().saveObject(users);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Users users) throws PersistentException {
		try {
			UntitledPersistentManager.instance().deleteObject(users);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Users users)throws PersistentException {
		try {
			if (users.getIdRole() != null) {
				users.getIdRole().users.remove(users);
			}
			
			Comments[] lCommentss = users.comments.toArray();
			for(int i = 0; i < lCommentss.length; i++) {
				lCommentss[i].setIdUser(null);
			}
			Posts[] lPostss = users.posts.toArray();
			for(int i = 0; i < lPostss.length; i++) {
				lPostss[i].setIdUser(null);
			}
			Ratings[] lRatingss = users.ratings.toArray();
			for(int i = 0; i < lRatingss.length; i++) {
				lRatingss[i].setIdUser(null);
			}
			Updates[] lUpdatess = users.updates.toArray();
			for(int i = 0; i < lUpdatess.length; i++) {
				lUpdatess[i].setIdUser(null);
			}
			return delete(users);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Users users, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (users.getIdRole() != null) {
				users.getIdRole().users.remove(users);
			}
			
			Comments[] lCommentss = users.comments.toArray();
			for(int i = 0; i < lCommentss.length; i++) {
				lCommentss[i].setIdUser(null);
			}
			Posts[] lPostss = users.posts.toArray();
			for(int i = 0; i < lPostss.length; i++) {
				lPostss[i].setIdUser(null);
			}
			Ratings[] lRatingss = users.ratings.toArray();
			for(int i = 0; i < lRatingss.length; i++) {
				lRatingss[i].setIdUser(null);
			}
			Updates[] lUpdatess = users.updates.toArray();
			for(int i = 0; i < lUpdatess.length; i++) {
				lUpdatess[i].setIdUser(null);
			}
			try {
				session.delete(users);
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
	
	public static boolean refresh(Users users) throws PersistentException {
		try {
			UntitledPersistentManager.instance().getSession().refresh(users);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Users users) throws PersistentException {
		try {
			UntitledPersistentManager.instance().getSession().evict(users);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Users loadUsersByCriteria(UsersCriteria usersCriteria) {
		Users[] userses = listUsersByCriteria(usersCriteria);
		if(userses == null || userses.length == 0) {
			return null;
		}
		return userses[0];
	}
	
	public static Users[] listUsersByCriteria(UsersCriteria usersCriteria) {
		return usersCriteria.listUsers();
	}
}
