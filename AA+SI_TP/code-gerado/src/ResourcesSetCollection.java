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
import org.orm.*;

public class ResourcesSetCollection extends org.orm.util.ORMSet {
	public ResourcesSetCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int targetKey, int collType) {
		super(owner, adapter, ownerKey, targetKey, true, collType);
	}
	
	public ResourcesSetCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int collType) {
		super(owner, adapter, ownerKey, -1, false, collType);
	}
	
	/**
	* Return an iterator over the persistent objects
	* @return The persistent objects iterator
	*/
	public java.util.Iterator getIterator() {
		return super.getIterator(_ownerAdapter);
	}
	
	/**
	 * Add the specified persistent object to ORMSet
	 * @param value the persistent object
	 */
	public void add(Resources value) {
		if (value != null) {
			super.add(value, value._ormAdapter);
		}
	}
	
	/**
	 * Remove the specified persistent object from ORMSet
	 * @param value the persistent object
	 */
	public void remove(Resources value) {
		super.remove(value, value._ormAdapter);
	}
	
	/**
	 * Return true if ORMSet contains the specified persistent object
	 * @param value the persistent object
	 * @return True if this contains the specified persistent object
	 */
	public boolean contains(Resources value) {
		return super.contains(value);
	}
	
	/**
	 * Return an array containing all of the persistent objects in ORMSet
	 * @return The persistent objects array
	 */
	public Resources[] toArray() {
		return (Resources[]) super.toArray(new Resources[size()]);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMSet
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>idResource</li>
	 * <li>title</li>
	 * <li>description</li>
	 * <li>createdAt</li>
	 * <li>registeredAt</li>
	 * <li>lastModifiedAt</li>
	 * <li>visibility</li>
	 * <li>nDownloads</li>
	 * <li>available</li>
	 * </ul>
	 * @return The persistent objects sorted array
	 */
	public Resources[] toArray(String propertyName) {
		return toArray(propertyName, true);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMSet
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>idResource</li>
	 * <li>title</li>
	 * <li>description</li>
	 * <li>createdAt</li>
	 * <li>registeredAt</li>
	 * <li>lastModifiedAt</li>
	 * <li>visibility</li>
	 * <li>nDownloads</li>
	 * <li>available</li>
	 * </ul>
	 * @param ascending true for ascending, false for descending
	 * @return The persistent objects sorted array
	 */
	public Resources[] toArray(String propertyName, boolean ascending) {
		return (Resources[]) super.toArray(new Resources[size()], propertyName, ascending);
	}
	
	protected PersistentManager getPersistentManager() throws PersistentException {
		return UntitledPersistentManager.instance();
	}
	
}

