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
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RolesDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idRole;
	public final StringExpression type;
	public final StringExpression affiliation;
	public final CollectionExpression users;
	
	public RolesDetachedCriteria() {
		super(Roles.class, RolesCriteria.class);
		idRole = new IntegerExpression("idRole", this.getDetachedCriteria());
		type = new StringExpression("type", this.getDetachedCriteria());
		affiliation = new StringExpression("affiliation", this.getDetachedCriteria());
		users = new CollectionExpression("ORM_Users", this.getDetachedCriteria());
	}
	
	public RolesDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, RolesCriteria.class);
		idRole = new IntegerExpression("idRole", this.getDetachedCriteria());
		type = new StringExpression("type", this.getDetachedCriteria());
		affiliation = new StringExpression("affiliation", this.getDetachedCriteria());
		users = new CollectionExpression("ORM_Users", this.getDetachedCriteria());
	}
	
	public UsersDetachedCriteria createUsersCriteria() {
		return new UsersDetachedCriteria(createCriteria("ORM_Users"));
	}
	
	public Roles uniqueRoles(PersistentSession session) {
		return (Roles) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Roles[] listRoles(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Roles[]) list.toArray(new Roles[list.size()]);
	}
}

