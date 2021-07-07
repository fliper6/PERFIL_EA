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
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ResourcetypesDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idResourceType;
	public final StringExpression type;
	public final CollectionExpression resources;
	
	public ResourcetypesDetachedCriteria() {
		super(Resourcetypes.class, ResourcetypesCriteria.class);
		idResourceType = new IntegerExpression("idResourceType", this.getDetachedCriteria());
		type = new StringExpression("type", this.getDetachedCriteria());
		resources = new CollectionExpression("ORM_Resources", this.getDetachedCriteria());
	}
	
	public ResourcetypesDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ResourcetypesCriteria.class);
		idResourceType = new IntegerExpression("idResourceType", this.getDetachedCriteria());
		type = new StringExpression("type", this.getDetachedCriteria());
		resources = new CollectionExpression("ORM_Resources", this.getDetachedCriteria());
	}
	
	public ResourcesDetachedCriteria createResourcesCriteria() {
		return new ResourcesDetachedCriteria(createCriteria("ORM_Resources"));
	}
	
	public Resourcetypes uniqueResourcetypes(PersistentSession session) {
		return (Resourcetypes) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Resourcetypes[] listResourcetypes(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Resourcetypes[]) list.toArray(new Resourcetypes[list.size()]);
	}
}

