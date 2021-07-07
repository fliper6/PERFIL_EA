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
public class Posts {
	public Posts() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_POSTS_COMMENTS) {
			return ORM_comments;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_POSTS_IDUSER) {
			this.idUser = (Users) owner;
		}
		
		else if (key == ORMConstants.KEY_POSTS_IDRESOURCE) {
			this.idResource = (Resources) owner;
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
	
	private int idPost;

	private String title;

	private String body;
	
	private java.sql.Timestamp createdAt;
	
	private Users idUser;
	
	private Resources idResource;
	
	private java.util.Set ORM_comments = new java.util.HashSet();
	
	private void setIdPost(int value) {
		this.idPost = value;
	}
	
	public int getIdPost() {
		return idPost;
	}
	
	public int getORMID() {
		return getIdPost();
	}
	
	public void setBody(String value) {
		this.body = value;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setCreatedAt(java.sql.Timestamp value) {
		this.createdAt = value;
	}
	
	public java.sql.Timestamp getCreatedAt() {
		return createdAt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setIdUser(Users value) {
		if (idUser != null) {
			idUser.posts.remove(this);
		}
		if (value != null) {
			value.posts.add(this);
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
			idResource.posts.remove(this);
		}
		if (value != null) {
			value.posts.add(this);
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
	
	private void setORM_Comments(java.util.Set value) {
		this.ORM_comments = value;
	}
	
	private java.util.Set getORM_Comments() {
		return ORM_comments;
	}
	
	public final CommentsSetCollection comments = new CommentsSetCollection(this, _ormAdapter, ORMConstants.KEY_POSTS_COMMENTS, ORMConstants.KEY_COMMENTS_IDPOST, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdPost());
	}
	
}
