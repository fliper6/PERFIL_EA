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
public class Files {
	public Files() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_FILES_IDRESOURCE) {
			this.idResource = (Resources) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int idFile;
	
	private String name;
	
	private String mimetype;
	
	private String path;

	private long size;
	
	private Resources idResource;

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	private void setIdFile(int value) {
		this.idFile = value;
	}
	
	public int getIdFile() {
		return idFile;
	}
	
	public int getORMID() {
		return getIdFile();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setMimetype(String value) {
		this.mimetype = value;
	}
	
	public String getMimetype() {
		return mimetype;
	}
	
	public void setPath(String value) {
		this.path = value;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setIdResource(Resources value) {
		if (idResource != null) {
			idResource.files.remove(this);
		}
		if (value != null) {
			value.files.add(this);
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
		return String.valueOf(getIdFile());
	}
	
}
