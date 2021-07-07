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
public class Updates {
	public Updates() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_UPDATES_IDUSER) {
			this.idUser = (Users) owner;
		}
		
		else if (key == ORMConstants.KEY_UPDATES_IDRESOURCE) {
			this.idResource = (Resources) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int idUpdate;
	
	private String state;
	
	private java.sql.Timestamp createdAt;
	
	private Users idUser;
	
	private Resources idResource;
	
	private void setIdUpdate(int value) {
		this.idUpdate = value;
	}
	
	public int getIdUpdate() {
		return idUpdate;
	}
	
	public int getORMID() {
		return getIdUpdate();
	}
	
	public void setState(String value) {
		this.state = value;
	}
	
	public String getState() {
		return state;
	}
	
	public void setCreatedAt(java.sql.Timestamp value) {
		this.createdAt = value;
	}
	
	public java.sql.Timestamp getCreatedAt() {
		return createdAt;
	}
	
	public void setIdUser(Users value) {
		if (idUser != null) {
			idUser.updates.remove(this);
		}
		if (value != null) {
			value.updates.add(this);
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
	
	public void setIdResource(Resources value) {
		if (idResource != null) {
			idResource.updates.remove(this);
		}
		if (value != null) {
			value.updates.add(this);
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
	
	public String toString() {
		return String.valueOf(getIdUpdate());
	}
	
}
