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
public class Ratings {
	public Ratings() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_RATINGS_IDRESOURCE) {
			this.idResource = (Resources) owner;
		}
		
		else if (key == ORMConstants.KEY_RATINGS_IDUSER) {
			this.idUser = (Users) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int idRatings;
	
	private int rating;
	
	private Resources idResource;
	
	private Users idUser;
	
	private void setIdRatings(int value) {
		this.idRatings = value;
	}
	
	public int getIdRatings() {
		return idRatings;
	}
	
	public int getORMID() {
		return getIdRatings();
	}
	
	public void setRating(int value) {
		this.rating = value;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setIdResource(Resources value) {
		if (idResource != null) {
			idResource.ratings.remove(this);
		}
		if (value != null) {
			value.ratings.add(this);
		}
	}
	
	public Resources getIdResource() {
		return idResource;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_IdResource(Resources value) {
		this.idResource = value;
	}
	
	private Resources getORM_IdResource() {
		return idResource;
	}
	
	public void setIdUser(Users value) {
		if (idUser != null) {
			idUser.ratings.remove(this);
		}
		if (value != null) {
			value.ratings.add(this);
		}
	}
	
	public Users getIdUser() {
		return idUser;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_IdUser(Users value) {
		this.idUser = value;
	}
	
	private Users getORM_IdUser() {
		return idUser;
	}
	
	public String toString() {
		return String.valueOf(getIdRatings());
	}
	
}
