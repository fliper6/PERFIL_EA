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
public class Users {
	public Users() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_USERS_COMMENTS) {
			return ORM_comments;
		}
		else if (key == ORMConstants.KEY_USERS_POSTS) {
			return ORM_posts;
		}
		else if (key == ORMConstants.KEY_USERS_RATINGS) {
			return ORM_ratings;
		}
		else if (key == ORMConstants.KEY_USERS_UPDATES) {
			return ORM_updates;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_USERS_IDROLE) {
			this.idRole = (Roles) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int idUser;
	
	private String email;
	
	private String password;
	
	private String level;
	
	private java.sql.Timestamp registerDate;
	
	private String description;
	
	private String picture;
	
	private boolean blocked;
	
	private Roles idRole;
	
	private java.util.Set ORM_comments = new java.util.HashSet();
	
	private java.util.Set ORM_posts = new java.util.HashSet();
	
	private java.util.Set ORM_ratings = new java.util.HashSet();
	
	private java.util.Set ORM_updates = new java.util.HashSet();
	
	private void setIdUser(int value) {
		this.idUser = value;
	}
	
	public int getIdUser() {
		return idUser;
	}
	
	public int getORMID() {
		return getIdUser();
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setLevel(String value) {
		this.level = value;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setRegisterDate(java.sql.Timestamp value) {
		this.registerDate = value;
	}
	
	public java.sql.Timestamp getRegisterDate() {
		return registerDate;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setPicture(String value) {
		this.picture = value;
	}
	
	public String getPicture() {
		return picture;
	}
	
	public void setBlocked(boolean value) {
		this.blocked = value;
	}
	
	public boolean getBlocked() {
		return blocked;
	}
	
	public void setIdRole(Roles value) {
		if (idRole != null) {
			idRole.users.remove(this);
		}
		if (value != null) {
			value.users.add(this);
		}
	}
	
	public Roles getIdRole() {
		return idRole;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_IdRole(Roles value) {
		this.idRole = value;
	}
	
	private Roles getORM_IdRole() {
		return idRole;
	}
	
	private void setORM_Comments(java.util.Set value) {
		this.ORM_comments = value;
	}
	
	private java.util.Set getORM_Comments() {
		return ORM_comments;
	}
	
	public final CommentsSetCollection comments = new CommentsSetCollection(this, _ormAdapter, ORMConstants.KEY_USERS_COMMENTS, ORMConstants.KEY_COMMENTS_IDUSER, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Posts(java.util.Set value) {
		this.ORM_posts = value;
	}
	
	private java.util.Set getORM_Posts() {
		return ORM_posts;
	}
	
	public final PostsSetCollection posts = new PostsSetCollection(this, _ormAdapter, ORMConstants.KEY_USERS_POSTS, ORMConstants.KEY_POSTS_IDUSER, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Ratings(java.util.Set value) {
		this.ORM_ratings = value;
	}
	
	private java.util.Set getORM_Ratings() {
		return ORM_ratings;
	}
	
	public final RatingsSetCollection ratings = new RatingsSetCollection(this, _ormAdapter, ORMConstants.KEY_USERS_RATINGS, ORMConstants.KEY_RATINGS_IDUSER, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Updates(java.util.Set value) {
		this.ORM_updates = value;
	}
	
	private java.util.Set getORM_Updates() {
		return ORM_updates;
	}
	
	public final UpdatesSetCollection updates = new UpdatesSetCollection(this, _ormAdapter, ORMConstants.KEY_USERS_UPDATES, ORMConstants.KEY_UPDATES_IDUSER, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdUser());
	}
	
}
