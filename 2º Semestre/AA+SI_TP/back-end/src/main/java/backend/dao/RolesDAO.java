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

public class RolesDAO {
	public static Roles loadRolesByORMID(int idRole) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadRolesByORMID(session, idRole);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Roles getRolesByORMID(int idRole) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return getRolesByORMID(session, idRole);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Roles loadRolesByORMID(int idRole, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadRolesByORMID(session, idRole, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Roles getRolesByORMID(int idRole, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return getRolesByORMID(session, idRole, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Roles loadRolesByORMID(PersistentSession session, int idRole) throws PersistentException {
		try {
			return (Roles) session.load(Roles.class, new Integer(idRole));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Roles getRolesByORMID(PersistentSession session, int idRole) throws PersistentException {
		try {
			return (Roles) session.get(Roles.class, new Integer(idRole));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Roles loadRolesByORMID(PersistentSession session, int idRole, LockMode lockMode) throws PersistentException {
		try {
			return (Roles) session.load(Roles.class, new Integer(idRole), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Roles getRolesByORMID(PersistentSession session, int idRole, LockMode lockMode) throws PersistentException {
		try {
			return (Roles) session.get(Roles.class, new Integer(idRole), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRoles(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return queryRoles(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRoles(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return queryRoles(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Roles[] listRolesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return listRolesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Roles[] listRolesByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return listRolesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRoles(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Roles as Roles");
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
	
	public static List queryRoles(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Roles as Roles");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Roles", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Roles[] listRolesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryRoles(session, condition, orderBy);
			return (Roles[]) list.toArray(new Roles[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Roles[] listRolesByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			List list = queryRoles(session, condition, orderBy, lockMode);
			return (Roles[]) list.toArray(new Roles[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Roles loadRolesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadRolesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Roles loadRolesByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadRolesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Roles loadRolesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Roles[] roleses = listRolesByQuery(session, condition, orderBy);
		if (roleses != null && roleses.length > 0)
			return roleses[0];
		else
			return null;
	}
	
	public static Roles loadRolesByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		Roles[] roleses = listRolesByQuery(session, condition, orderBy, lockMode);
		if (roleses != null && roleses.length > 0)
			return roleses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateRolesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return iterateRolesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRolesByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return iterateRolesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRolesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Roles as Roles");
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
	
	public static java.util.Iterator iterateRolesByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Roles as Roles");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Roles", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Roles createRoles() {
		return new Roles();
	}
	
	public static boolean save(Roles roles) throws PersistentException {
		try {
			UntitledPersistentManager.instance().saveObject(roles);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Roles roles) throws PersistentException {
		try {
			UntitledPersistentManager.instance().deleteObject(roles);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Roles roles)throws PersistentException {
		try {
			Users[] lUserss = roles.users.toArray();
			for(int i = 0; i < lUserss.length; i++) {
				lUserss[i].setIdRole(null);
			}
			return delete(roles);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Roles roles, PersistentSession session)throws PersistentException {
		try {
			Users[] lUserss = roles.users.toArray();
			for(int i = 0; i < lUserss.length; i++) {
				lUserss[i].setIdRole(null);
			}
			try {
				session.delete(roles);
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
	
	public static boolean refresh(Roles roles) throws PersistentException {
		try {
			UntitledPersistentManager.instance().getSession().refresh(roles);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Roles roles) throws PersistentException {
		try {
			UntitledPersistentManager.instance().getSession().evict(roles);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Roles loadRolesByCriteria(RolesCriteria rolesCriteria) {
		Roles[] roleses = listRolesByCriteria(rolesCriteria);
		if(roleses == null || roleses.length == 0) {
			return null;
		}
		return roleses[0];
	}
	
	public static Roles[] listRolesByCriteria(RolesCriteria rolesCriteria) {
		return rolesCriteria.listRoles();
	}
}
