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
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ResourcetypesCriteria extends AbstractORMCriteria {
	public final IntegerExpression idResourceType;
	public final StringExpression type;
	public final CollectionExpression resources;
	
	public ResourcetypesCriteria(Criteria criteria) {
		super(criteria);
		idResourceType = new IntegerExpression("idResourceType", this);
		type = new StringExpression("type", this);
		resources = new CollectionExpression("ORM_Resources", this);
	}
	
	public ResourcetypesCriteria(PersistentSession session) {
		this(session.createCriteria(Resourcetypes.class));
	}
	
	public ResourcetypesCriteria() throws PersistentException {
		this(UntitledPersistentManager.instance().getSession());
	}
	
	public ResourcesCriteria createResourcesCriteria() {
		return new ResourcesCriteria(createCriteria("ORM_Resources"));
	}
	
	public Resourcetypes uniqueResourcetypes() {
		return (Resourcetypes) super.uniqueResult();
	}
	
	public Resourcetypes[] listResourcetypes() {
		java.util.List list = super.list();
		return (Resourcetypes[]) list.toArray(new Resourcetypes[list.size()]);
	}
}

