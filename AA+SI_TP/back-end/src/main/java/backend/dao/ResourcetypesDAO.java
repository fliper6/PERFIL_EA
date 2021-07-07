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

public class ResourcetypesDAO {
	public static Resourcetypes loadResourcetypesByORMID(int idResourceType) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadResourcetypesByORMID(session, idResourceType);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resourcetypes getResourcetypesByORMID(int idResourceType) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return getResourcetypesByORMID(session, idResourceType);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resourcetypes loadResourcetypesByORMID(int idResourceType, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadResourcetypesByORMID(session, idResourceType, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resourcetypes getResourcetypesByORMID(int idResourceType, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return getResourcetypesByORMID(session, idResourceType, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resourcetypes loadResourcetypesByORMID(PersistentSession session, int idResourceType) throws PersistentException {
		try {
			return (Resourcetypes) session.load(Resourcetypes.class, new Integer(idResourceType));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resourcetypes getResourcetypesByORMID(PersistentSession session, int idResourceType) throws PersistentException {
		try {
			return (Resourcetypes) session.get(Resourcetypes.class, new Integer(idResourceType));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resourcetypes loadResourcetypesByORMID(PersistentSession session, int idResourceType, LockMode lockMode) throws PersistentException {
		try {
			return (Resourcetypes) session.load(Resourcetypes.class, new Integer(idResourceType), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resourcetypes getResourcetypesByORMID(PersistentSession session, int idResourceType, LockMode lockMode) throws PersistentException {
		try {
			return (Resourcetypes) session.get(Resourcetypes.class, new Integer(idResourceType), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResourcetypes(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return queryResourcetypes(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResourcetypes(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return queryResourcetypes(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resourcetypes[] listResourcetypesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return listResourcetypesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resourcetypes[] listResourcetypesByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return listResourcetypesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResourcetypes(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Resourcetypes as Resourcetypes");
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
	
	public static List queryResourcetypes(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Resourcetypes as Resourcetypes");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Resourcetypes", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resourcetypes[] listResourcetypesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryResourcetypes(session, condition, orderBy);
			return (Resourcetypes[]) list.toArray(new Resourcetypes[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resourcetypes[] listResourcetypesByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			List list = queryResourcetypes(session, condition, orderBy, lockMode);
			return (Resourcetypes[]) list.toArray(new Resourcetypes[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resourcetypes loadResourcetypesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadResourcetypesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resourcetypes loadResourcetypesByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadResourcetypesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resourcetypes loadResourcetypesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Resourcetypes[] resourcetypeses = listResourcetypesByQuery(session, condition, orderBy);
		if (resourcetypeses != null && resourcetypeses.length > 0)
			return resourcetypeses[0];
		else
			return null;
	}
	
	public static Resourcetypes loadResourcetypesByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		Resourcetypes[] resourcetypeses = listResourcetypesByQuery(session, condition, orderBy, lockMode);
		if (resourcetypeses != null && resourcetypeses.length > 0)
			return resourcetypeses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateResourcetypesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return iterateResourcetypesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateResourcetypesByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return iterateResourcetypesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateResourcetypesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Resourcetypes as Resourcetypes");
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
	
	public static java.util.Iterator iterateResourcetypesByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Resourcetypes as Resourcetypes");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Resourcetypes", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resourcetypes createResourcetypes() {
		return new Resourcetypes();
	}
	
	public static boolean save(Resourcetypes resourcetypes) throws PersistentException {
		try {
			UntitledPersistentManager.instance().saveObject(resourcetypes);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Resourcetypes resourcetypes) throws PersistentException {
		try {
			UntitledPersistentManager.instance().deleteObject(resourcetypes);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Resourcetypes resourcetypes)throws PersistentException {
		try {
			Resources[] lResourcess = resourcetypes.resources.toArray();
			for(int i = 0; i < lResourcess.length; i++) {
				lResourcess[i].setIdResourceType(null);
			}
			return delete(resourcetypes);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Resourcetypes resourcetypes, PersistentSession session)throws PersistentException {
		try {
			Resources[] lResourcess = resourcetypes.resources.toArray();
			for(int i = 0; i < lResourcess.length; i++) {
				lResourcess[i].setIdResourceType(null);
			}
			try {
				session.delete(resourcetypes);
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
	
	public static boolean refresh(Resourcetypes resourcetypes) throws PersistentException {
		try {
			UntitledPersistentManager.instance().getSession().refresh(resourcetypes);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Resourcetypes resourcetypes) throws PersistentException {
		try {
			UntitledPersistentManager.instance().getSession().evict(resourcetypes);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Resourcetypes loadResourcetypesByCriteria(ResourcetypesCriteria resourcetypesCriteria) {
		Resourcetypes[] resourcetypeses = listResourcetypesByCriteria(resourcetypesCriteria);
		if(resourcetypeses == null || resourcetypeses.length == 0) {
			return null;
		}
		return resourcetypeses[0];
	}
	
	public static Resourcetypes[] listResourcetypesByCriteria(ResourcetypesCriteria resourcetypesCriteria) {
		return resourcetypesCriteria.listResourcetypes();
	}
}
