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

public class RatingsDAO {
	public static Ratings loadRatingsByORMID(int idRatings) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadRatingsByORMID(session, idRatings);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings getRatingsByORMID(int idRatings) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return getRatingsByORMID(session, idRatings);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings loadRatingsByORMID(int idRatings, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadRatingsByORMID(session, idRatings, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings getRatingsByORMID(int idRatings, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return getRatingsByORMID(session, idRatings, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings loadRatingsByORMID(PersistentSession session, int idRatings) throws PersistentException {
		try {
			return (Ratings) session.load(Ratings.class, new Integer(idRatings));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings getRatingsByORMID(PersistentSession session, int idRatings) throws PersistentException {
		try {
			return (Ratings) session.get(Ratings.class, new Integer(idRatings));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings loadRatingsByORMID(PersistentSession session, int idRatings, LockMode lockMode) throws PersistentException {
		try {
			return (Ratings) session.load(Ratings.class, new Integer(idRatings), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings getRatingsByORMID(PersistentSession session, int idRatings, LockMode lockMode) throws PersistentException {
		try {
			return (Ratings) session.get(Ratings.class, new Integer(idRatings), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRatings(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return queryRatings(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRatings(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return queryRatings(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings[] listRatingsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return listRatingsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings[] listRatingsByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return listRatingsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRatings(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Ratings as Ratings");
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
	
	public static List queryRatings(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Ratings as Ratings");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ratings", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings[] listRatingsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryRatings(session, condition, orderBy);
			return (Ratings[]) list.toArray(new Ratings[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings[] listRatingsByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			List list = queryRatings(session, condition, orderBy, lockMode);
			return (Ratings[]) list.toArray(new Ratings[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings loadRatingsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadRatingsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings loadRatingsByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return loadRatingsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings loadRatingsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Ratings[] ratingses = listRatingsByQuery(session, condition, orderBy);
		if (ratingses != null && ratingses.length > 0)
			return ratingses[0];
		else
			return null;
	}
	
	public static Ratings loadRatingsByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		Ratings[] ratingses = listRatingsByQuery(session, condition, orderBy, lockMode);
		if (ratingses != null && ratingses.length > 0)
			return ratingses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateRatingsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return iterateRatingsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRatingsByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = UntitledPersistentManager.instance().getSession();
			return iterateRatingsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRatingsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Ratings as Ratings");
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
	
	public static java.util.Iterator iterateRatingsByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Ratings as Ratings");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Ratings", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings createRatings() {
		return new Ratings();
	}
	
	public static boolean save(Ratings ratings) throws PersistentException {
		try {
			UntitledPersistentManager.instance().saveObject(ratings);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Ratings ratings) throws PersistentException {
		try {
			UntitledPersistentManager.instance().deleteObject(ratings);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Ratings ratings)throws PersistentException {
		try {
			if (ratings.getIdResource() != null) {
				ratings.getIdResource().ratings.remove(ratings);
			}
			
			if (ratings.getIdUser() != null) {
				ratings.getIdUser().ratings.remove(ratings);
			}
			
			return delete(ratings);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Ratings ratings, PersistentSession session)throws PersistentException {
		try {
			if (ratings.getIdResource() != null) {
				ratings.getIdResource().ratings.remove(ratings);
			}
			
			if (ratings.getIdUser() != null) {
				ratings.getIdUser().ratings.remove(ratings);
			}
			
			try {
				session.delete(ratings);
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
	
	public static boolean refresh(Ratings ratings) throws PersistentException {
		try {
			UntitledPersistentManager.instance().getSession().refresh(ratings);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Ratings ratings) throws PersistentException {
		try {
			UntitledPersistentManager.instance().getSession().evict(ratings);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Ratings loadRatingsByCriteria(RatingsCriteria ratingsCriteria) {
		Ratings[] ratingses = listRatingsByCriteria(ratingsCriteria);
		if(ratingses == null || ratingses.length == 0) {
			return null;
		}
		return ratingses[0];
	}
	
	public static Ratings[] listRatingsByCriteria(RatingsCriteria ratingsCriteria) {
		return ratingsCriteria.listRatings();
	}
}
