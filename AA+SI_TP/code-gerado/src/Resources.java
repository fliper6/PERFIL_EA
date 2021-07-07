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
public class Resources {
	public Resources() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_RESOURCES_FILES) {
			return ORM_files;
		}
		else if (key == ORMConstants.KEY_RESOURCES_POSTS) {
			return ORM_posts;
		}
		else if (key == ORMConstants.KEY_RESOURCES_RATINGS) {
			return ORM_ratings;
		}
		else if (key == ORMConstants.KEY_RESOURCES_UPDATES) {
			return ORM_updates;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_RESOURCES_IDRESOURCETYPE) {
			this.idResourceType = (Resourcetypes) owner;
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
	
	private int idResource;
	
	private String title;
	
	private String description;
	
	private java.sql.Timestamp createdAt;
	
	private java.sql.Timestamp registeredAt;
	
	private java.sql.Timestamp lastModifiedAt;
	
	private boolean visibility;
	
	private int nDownloads;
	
	private boolean available;
	
	private Resourcetypes idResourceType;
	
	private java.util.Set ORM_files = new java.util.HashSet();
	
	private java.util.Set ORM_posts = new java.util.HashSet();
	
	private java.util.Set ORM_ratings = new java.util.HashSet();
	
	private java.util.Set ORM_updates = new java.util.HashSet();
	
	private void setIdResource(int value) {
		this.idResource = value;
	}
	
	public int getIdResource() {
		return idResource;
	}
	
	public int getORMID() {
		return getIdResource();
	}
	
	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setCreatedAt(java.sql.Timestamp value) {
		this.createdAt = value;
	}
	
	public java.sql.Timestamp getCreatedAt() {
		return createdAt;
	}
	
	public void setRegisteredAt(java.sql.Timestamp value) {
		this.registeredAt = value;
	}
	
	public java.sql.Timestamp getRegisteredAt() {
		return registeredAt;
	}
	
	public void setLastModifiedAt(java.sql.Timestamp value) {
		this.lastModifiedAt = value;
	}
	
	public java.sql.Timestamp getLastModifiedAt() {
		return lastModifiedAt;
	}
	
	public void setVisibility(boolean value) {
		this.visibility = value;
	}
	
	public boolean getVisibility() {
		return visibility;
	}
	
	public void setnDownloads(int value) {
		this.nDownloads = value;
	}
	
	public int getnDownloads() {
		return nDownloads;
	}
	
	public void setAvailable(boolean value) {
		this.available = value;
	}
	
	public boolean getAvailable() {
		return available;
	}
	
	public void setIdResourceType(Resourcetypes value) {
		if (idResourceType != null) {
			idResourceType.resources.remove(this);
		}
		if (value != null) {
			value.resources.add(this);
		}
	}
	
	public Resourcetypes getIdResourceType() {
		return idResourceType;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_IdResourceType(Resourcetypes value) {
		this.idResourceType = value;
	}
	
	private Resourcetypes getORM_IdResourceType() {
		return idResourceType;
	}
	
	private void setORM_Files(java.util.Set value) {
		this.ORM_files = value;
	}
	
	private java.util.Set getORM_Files() {
		return ORM_files;
	}
	
	public final FilesSetCollection files = new FilesSetCollection(this, _ormAdapter, ORMConstants.KEY_RESOURCES_FILES, ORMConstants.KEY_FILES_IDRESOURCE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Posts(java.util.Set value) {
		this.ORM_posts = value;
	}
	
	private java.util.Set getORM_Posts() {
		return ORM_posts;
	}
	
	public final PostsSetCollection posts = new PostsSetCollection(this, _ormAdapter, ORMConstants.KEY_RESOURCES_POSTS, ORMConstants.KEY_POSTS_IDRESOURCE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Ratings(java.util.Set value) {
		this.ORM_ratings = value;
	}
	
	private java.util.Set getORM_Ratings() {
		return ORM_ratings;
	}
	
	public final RatingsSetCollection ratings = new RatingsSetCollection(this, _ormAdapter, ORMConstants.KEY_RESOURCES_RATINGS, ORMConstants.KEY_RATINGS_IDRESOURCE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Updates(java.util.Set value) {
		this.ORM_updates = value;
	}
	
	private java.util.Set getORM_Updates() {
		return ORM_updates;
	}
	
	public final UpdatesSetCollection updates = new UpdatesSetCollection(this, _ormAdapter, ORMConstants.KEY_RESOURCES_UPDATES, ORMConstants.KEY_UPDATES_IDRESOURCE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdResource());
	}
	
}
