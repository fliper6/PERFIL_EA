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

public class UpdatesDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idUpdate;
	public final StringExpression state;
	public final TimestampExpression createdAt;
	public final IntegerExpression idUserId;
	public final AssociationExpression idUser;
	public final IntegerExpression idResourceId;
	public final AssociationExpression idResource;
	
	public UpdatesDetachedCriteria() {
		super(Updates.class, UpdatesCriteria.class);
		idUpdate = new IntegerExpression("idUpdate", this.getDetachedCriteria());
		state = new StringExpression("state", this.getDetachedCriteria());
		createdAt = new TimestampExpression("createdAt", this.getDetachedCriteria());
		idUserId = new IntegerExpression("idUser.idUser", this.getDetachedCriteria());
		idUser = new AssociationExpression("idUser", this.getDetachedCriteria());
		idResourceId = new IntegerExpression("idResource.idResource", this.getDetachedCriteria());
		idResource = new AssociationExpression("idResource", this.getDetachedCriteria());
	}
	
	public UpdatesDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, UpdatesCriteria.class);
		idUpdate = new IntegerExpression("idUpdate", this.getDetachedCriteria());
		state = new StringExpression("state", this.getDetachedCriteria());
		createdAt = new TimestampExpression("createdAt", this.getDetachedCriteria());
		idUserId = new IntegerExpression("idUser.idUser", this.getDetachedCriteria());
		idUser = new AssociationExpression("idUser", this.getDetachedCriteria());
		idResourceId = new IntegerExpression("idResource.idResource", this.getDetachedCriteria());
		idResource = new AssociationExpression("idResource", this.getDetachedCriteria());
	}
	
	public UsersDetachedCriteria createIdUserCriteria() {
		return new UsersDetachedCriteria(createCriteria("idUser"));
	}
	
	public ResourcesDetachedCriteria createIdResourceCriteria() {
		return new ResourcesDetachedCriteria(createCriteria("idResource"));
	}
	
	public Updates uniqueUpdates(PersistentSession session) {
		return (Updates) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Updates[] listUpdates(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Updates[]) list.toArray(new Updates[list.size()]);
	}
}

