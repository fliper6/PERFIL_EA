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

public class UpdatesDAO {
	public static Updates loadUpdatesByORMID(int idUpdate) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadUpdatesByORMID(session, idUpdate);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Updates getUpdatesByORMID(int idUpdate) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return getUpdatesByORMID(session, idUpdate);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Updates loadUpdatesByORMID(int idUpdate, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadUpdatesByORMID(session, idUpdate, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Updates getUpdatesByORMID(int idUpdate, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return getUpdatesByORMID(session, idUpdate, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Updates loadUpdatesByORMID(PersistentSession session, int idUpdate) throws PersistentException {
		try {
			return (Updates) session.load(Updates.class, new Integer(idUpdate));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Updates getUpdatesByORMID(PersistentSession session, int idUpdate) throws PersistentException {
		try {
			return (Updates) session.get(Updates.class, new Integer(idUpdate));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Updates loadUpdatesByORMID(PersistentSession session, int idUpdate, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Updates) session.load(Updates.class, new Integer(idUpdate), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Updates getUpdatesByORMID(PersistentSession session, int idUpdate, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Updates) session.get(Updates.class, new Integer(idUpdate), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUpdates(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return queryUpdates(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUpdates(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return queryUpdates(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Updates[] listUpdatesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return listUpdatesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Updates[] listUpdatesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return listUpdatesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUpdates(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Updates as Updates");
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
	
	public static List queryUpdates(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Updates as Updates");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Updates", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Updates[] listUpdatesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryUpdates(session, condition, orderBy);
			return (Updates[]) list.toArray(new Updates[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Updates[] listUpdatesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryUpdates(session, condition, orderBy, lockMode);
			return (Updates[]) list.toArray(new Updates[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Updates loadUpdatesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadUpdatesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Updates loadUpdatesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadUpdatesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Updates loadUpdatesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Updates[] updateses = listUpdatesByQuery(session, condition, orderBy);
		if (updateses != null && updateses.length > 0)
			return updateses[0];
		else
			return null;
	}
	
	public static Updates loadUpdatesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Updates[] updateses = listUpdatesByQuery(session, condition, orderBy, lockMode);
		if (updateses != null && updateses.length > 0)
			return updateses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUpdatesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return iterateUpdatesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUpdatesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return iterateUpdatesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUpdatesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Updates as Updates");
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
	
	public static java.util.Iterator iterateUpdatesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Updates as Updates");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Updates", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Updates createUpdates() {
		return new Updates();
	}
	
	public static boolean save(Updates updates) throws PersistentException {
		try {
			UntitledPersistentManager.instance().saveObject(updates);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Updates updates) throws PersistentException {
		try {
			UntitledPersistentManager.instance().deleteObject(updates);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Updates updates)throws PersistentException {
		try {
			if (updates.getIdUser() != null) {
				updates.getIdUser().updates.remove(updates);
			}
			
			if (updates.getIdResource() != null) {
				updates.getIdResource().updates.remove(updates);
			}
			
			return delete(updates);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Updates updates, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (updates.getIdUser() != null) {
				updates.getIdUser().updates.remove(updates);
			}
			
			if (updates.getIdResource() != null) {
				updates.getIdResource().updates.remove(updates);
			}
			
			try {
				session.delete(updates);
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
	
	public static boolean refresh(Updates updates) throws PersistentException {
		try {
			UntitledPersistentManager.instance().getSession().refresh(updates);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Updates updates) throws PersistentException {
		try {
			UntitledPersistentManager.instance().getSession().evict(updates);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Updates loadUpdatesByCriteria(UpdatesCriteria updatesCriteria) {
		Updates[] updateses = listUpdatesByCriteria(updatesCriteria);
		if(updateses == null || updateses.length == 0) {
			return null;
		}
		return updateses[0];
	}
	
	public static Updates[] listUpdatesByCriteria(UpdatesCriteria updatesCriteria) {
		return updatesCriteria.listUpdates();
	}
}
