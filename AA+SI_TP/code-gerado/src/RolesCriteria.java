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

public class RolesCriteria extends AbstractORMCriteria {
	public final IntegerExpression idRole;
	public final StringExpression type;
	public final StringExpression affiliation;
	public final CollectionExpression users;
	
	public RolesCriteria(Criteria criteria) {
		super(criteria);
		idRole = new IntegerExpression("idRole", this);
		type = new StringExpression("type", this);
		affiliation = new StringExpression("affiliation", this);
		users = new CollectionExpression("ORM_Users", this);
	}
	
	public RolesCriteria(PersistentSession session) {
		this(session.createCriteria(Roles.class));
	}
	
	public RolesCriteria() throws PersistentException {
		this(UntitledPersistentManager.instance().getSession());
	}
	
	public UsersCriteria createUsersCriteria() {
		return new UsersCriteria(createCriteria("ORM_Users"));
	}
	
	public Roles uniqueRoles() {
		return (Roles) super.uniqueResult();
	}
	
	public Roles[] listRoles() {
		java.util.List list = super.list();
		return (Roles[]) list.toArray(new Roles[list.size()]);
	}
}

