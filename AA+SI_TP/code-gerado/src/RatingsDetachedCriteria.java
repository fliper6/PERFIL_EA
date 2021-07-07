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

public class RatingsDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idRatings;
	public final IntegerExpression rating;
	public final IntegerExpression idResourceId;
	public final AssociationExpression idResource;
	public final IntegerExpression idUserId;
	public final AssociationExpression idUser;
	
	public RatingsDetachedCriteria() {
		super(Ratings.class, RatingsCriteria.class);
		idRatings = new IntegerExpression("idRatings", this.getDetachedCriteria());
		rating = new IntegerExpression("rating", this.getDetachedCriteria());
		idResourceId = new IntegerExpression("idResource.idResource", this.getDetachedCriteria());
		idResource = new AssociationExpression("idResource", this.getDetachedCriteria());
		idUserId = new IntegerExpression("idUser.idUser", this.getDetachedCriteria());
		idUser = new AssociationExpression("idUser", this.getDetachedCriteria());
	}
	
	public RatingsDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, RatingsCriteria.class);
		idRatings = new IntegerExpression("idRatings", this.getDetachedCriteria());
		rating = new IntegerExpression("rating", this.getDetachedCriteria());
		idResourceId = new IntegerExpression("idResource.idResource", this.getDetachedCriteria());
		idResource = new AssociationExpression("idResource", this.getDetachedCriteria());
		idUserId = new IntegerExpression("idUser.idUser", this.getDetachedCriteria());
		idUser = new AssociationExpression("idUser", this.getDetachedCriteria());
	}
	
	public ResourcesDetachedCriteria createIdResourceCriteria() {
		return new ResourcesDetachedCriteria(createCriteria("idResource"));
	}
	
	public UsersDetachedCriteria createIdUserCriteria() {
		return new UsersDetachedCriteria(createCriteria("idUser"));
	}
	
	public Ratings uniqueRatings(PersistentSession session) {
		return (Ratings) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ratings[] listRatings(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ratings[]) list.toArray(new Ratings[list.size()]);
	}
}

