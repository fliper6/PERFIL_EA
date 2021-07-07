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
public class Comments {
	public Comments() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_COMMENTS_IDUSER) {
			this.idUser = (Users) owner;
		}
		
		else if (key == ORMConstants.KEY_COMMENTS_IDPOST) {
			this.idPost = (Posts) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int idComment;
	
	private String body;
	
	private java.sql.Timestamp createdAt;
	
	private Users idUser;
	
	private Posts idPost;
	
	private void setIdComment(int value) {
		this.idComment = value;
	}
	
	public int getIdComment() {
		return idComment;
	}
	
	public int getORMID() {
		return getIdComment();
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
	
	public void setIdUser(Users value) {
		if (idUser != null) {
			idUser.comments.remove(this);
		}
		if (value != null) {
			value.comments.add(this);
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
	
	public void setIdPost(Posts value) {
		if (idPost != null) {
			idPost.comments.remove(this);
		}
		if (value != null) {
			value.comments.add(this);
		}
	}
	
	public Posts getIdPost() {
		return idPost;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_IdPost(Posts value) {
		this.idPost = value;
	}
	
	private Posts getORM_IdPost() {
		return idPost;
	}
	
	public String toString() {
		return String.valueOf(getIdComment());
	}
	
}
