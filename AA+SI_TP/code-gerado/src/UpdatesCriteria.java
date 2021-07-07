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

public class UpdatesCriteria extends AbstractORMCriteria {
	public final IntegerExpression idUpdate;
	public final StringExpression state;
	public final TimestampExpression createdAt;
	public final IntegerExpression idUserId;
	public final AssociationExpression idUser;
	public final IntegerExpression idResourceId;
	public final AssociationExpression idResource;
	
	public UpdatesCriteria(Criteria criteria) {
		super(criteria);
		idUpdate = new IntegerExpression("idUpdate", this);
		state = new StringExpression("state", this);
		createdAt = new TimestampExpression("createdAt", this);
		idUserId = new IntegerExpression("idUser.idUser", this);
		idUser = new AssociationExpression("idUser", this);
		idResourceId = new IntegerExpression("idResource.idResource", this);
		idResource = new AssociationExpression("idResource", this);
	}
	
	public UpdatesCriteria(PersistentSession session) {
		this(session.createCriteria(Updates.class));
	}
	
	public UpdatesCriteria() throws PersistentException {
		this(UntitledPersistentManager.instance().getSession());
	}
	
	public UsersCriteria createIdUserCriteria() {
		return new UsersCriteria(createCriteria("idUser"));
	}
	
	public ResourcesCriteria createIdResourceCriteria() {
		return new ResourcesCriteria(createCriteria("idResource"));
	}
	
	public Updates uniqueUpdates() {
		return (Updates) super.uniqueResult();
	}
	
	public Updates[] listUpdates() {
		java.util.List list = super.list();
		return (Updates[]) list.toArray(new Updates[list.size()]);
	}
}

