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

public class ResourcesDAO {
	public static Resources loadResourcesByORMID(int idResource) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadResourcesByORMID(session, idResource);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resources getResourcesByORMID(int idResource) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return getResourcesByORMID(session, idResource);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resources loadResourcesByORMID(int idResource, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadResourcesByORMID(session, idResource, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resources getResourcesByORMID(int idResource, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return getResourcesByORMID(session, idResource, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resources loadResourcesByORMID(PersistentSession session, int idResource) throws PersistentException {
		try {
			return (Resources) session.load(Resources.class, new Integer(idResource));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resources getResourcesByORMID(PersistentSession session, int idResource) throws PersistentException {
		try {
			return (Resources) session.get(Resources.class, new Integer(idResource));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resources loadResourcesByORMID(PersistentSession session, int idResource, LockMode lockMode) throws PersistentException {
		try {
			return (Resources) session.load(Resources.class, new Integer(idResource), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resources getResourcesByORMID(PersistentSession session, int idResource, LockMode lockMode) throws PersistentException {
		try {
			return (Resources) session.get(Resources.class, new Integer(idResource), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResources(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return queryResources(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResources(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return queryResources(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resources[] listResourcesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return listResourcesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resources[] listResourcesByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return listResourcesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResources(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Resources as Resources");
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
	
	public static List queryResources(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Resources as Resources");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Resources", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resources[] listResourcesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryResources(session, condition, orderBy);
			return (Resources[]) list.toArray(new Resources[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resources[] listResourcesByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			List list = queryResources(session, condition, orderBy, lockMode);
			return (Resources[]) list.toArray(new Resources[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resources loadResourcesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadResourcesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resources loadResourcesByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadResourcesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resources loadResourcesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Resources[] resourceses = listResourcesByQuery(session, condition, orderBy);
		if (resourceses != null && resourceses.length > 0)
			return resourceses[0];
		else
			return null;
	}
	
	public static Resources loadResourcesByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		Resources[] resourceses = listResourcesByQuery(session, condition, orderBy, lockMode);
		if (resourceses != null && resourceses.length > 0)
			return resourceses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateResourcesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return iterateResourcesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateResourcesByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return iterateResourcesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateResourcesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Resources as Resources");
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
	
	public static java.util.Iterator iterateResourcesByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Resources as Resources");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Resources", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resources createResources() {
		return new Resources();
	}
	
	public static boolean save(Resources resources) throws PersistentException {
		try {
			UntitledPersistentManager.instance().saveObject(resources);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Resources resources) throws PersistentException {
		try {
			UntitledPersistentManager.instance().deleteObject(resources);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Resources resources)throws PersistentException {
		try {
			if (resources.getIdResourceType() != null) {
				resources.getIdResourceType().resources.remove(resources);
			}
			
			Files[] lFiless = resources.files.toArray();
			for(int i = 0; i < lFiless.length; i++) {
				lFiless[i].setIdResource(null);
			}
			Posts[] lPostss = resources.posts.toArray();
			for(int i = 0; i < lPostss.length; i++) {
				lPostss[i].setIdResource(null);
			}
			Ratings[] lRatingss = resources.ratings.toArray();
			for(int i = 0; i < lRatingss.length; i++) {
				lRatingss[i].setIdResource(null);
			}
			Updates[] lUpdatess = resources.updates.toArray();
			for(int i = 0; i < lUpdatess.length; i++) {
				lUpdatess[i].setIdResource(null);
			}
			return delete(resources);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Resources resources, PersistentSession session)throws PersistentException {
		try {
			if (resources.getIdResourceType() != null) {
				resources.getIdResourceType().resources.remove(resources);
			}
			
			Files[] lFiless = resources.files.toArray();
			for(int i = 0; i < lFiless.length; i++) {
				lFiless[i].setIdResource(null);
			}
			Posts[] lPostss = resources.posts.toArray();
			for(int i = 0; i < lPostss.length; i++) {
				lPostss[i].setIdResource(null);
			}
			Ratings[] lRatingss = resources.ratings.toArray();
			for(int i = 0; i < lRatingss.length; i++) {
				lRatingss[i].setIdResource(null);
			}
			Updates[] lUpdatess = resources.updates.toArray();
			for(int i = 0; i < lUpdatess.length; i++) {
				lUpdatess[i].setIdResource(null);
			}
			try {
				session.delete(resources);
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
	
	public static boolean refresh(Resources resources) throws PersistentException {
		try {
			UntitledPersistentManager.instance().getSession().refresh(resources);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Resources resources) throws PersistentException {
		try {
			UntitledPersistentManager.instance().getSession().evict(resources);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resources loadResourcesByCriteria(ResourcesCriteria resourcesCriteria) {
		Resources[] resourceses = listResourcesByCriteria(resourcesCriteria);
		if(resourceses == null || resourceses.length == 0) {
			return null;
		}
		return resourceses[0];
	}
	
	public static Resources[] listResourcesByCriteria(ResourcesCriteria resourcesCriteria) {
		return resourcesCriteria.listResources();
	}
}
