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
public class Resourcetypes {
	public Resourcetypes() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_RESOURCETYPES_RESOURCES) {
			return ORM_resources;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int idResourceType;
	
	private String type;
	
	private java.util.Set ORM_resources = new java.util.HashSet();
	
	private void setIdResourceType(int value) {
		this.idResourceType = value;
	}
	
	public int getIdResourceType() {
		return idResourceType;
	}
	
	public int getORMID() {
		return getIdResourceType();
	}
	
	public void setType(String value) {
		this.type = value;
	}
	
	public String getType() {
		return type;
	}
	
	private void setORM_Resources(java.util.Set value) {
		this.ORM_resources = value;
	}
	
	private java.util.Set getORM_Resources() {
		return ORM_resources;
	}
	
	public final ResourcesSetCollection resources = new ResourcesSetCollection(this, _ormAdapter, ORMConstants.KEY_RESOURCETYPES_RESOURCES, ORMConstants.KEY_RESOURCES_IDRESOURCETYPE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdResourceType());
	}
	
}
