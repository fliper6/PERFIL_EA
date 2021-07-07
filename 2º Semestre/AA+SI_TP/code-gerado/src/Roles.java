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
public class Roles {
	public Roles() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_ROLES_USERS) {
			return ORM_users;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int idRole;
	
	private String type;
	
	private String affiliation;
	
	private java.util.Set ORM_users = new java.util.HashSet();
	
	private void setIdRole(int value) {
		this.idRole = value;
	}
	
	public int getIdRole() {
		return idRole;
	}
	
	public int getORMID() {
		return getIdRole();
	}
	
	public void setType(String value) {
		this.type = value;
	}
	
	public String getType() {
		return type;
	}
	
	public void setAffiliation(String value) {
		this.affiliation = value;
	}
	
	public String getAffiliation() {
		return affiliation;
	}
	
	private void setORM_Users(java.util.Set value) {
		this.ORM_users = value;
	}
	
	private java.util.Set getORM_Users() {
		return ORM_users;
	}
	
	public final UsersSetCollection users = new UsersSetCollection(this, _ormAdapter, ORMConstants.KEY_ROLES_USERS, ORMConstants.KEY_USERS_IDROLE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdRole());
	}
	
}
