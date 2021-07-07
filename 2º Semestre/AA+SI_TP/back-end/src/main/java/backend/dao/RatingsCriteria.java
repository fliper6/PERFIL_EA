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
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RatingsCriteria extends AbstractORMCriteria {
	public final IntegerExpression idRatings;
	public final IntegerExpression rating;
	public final IntegerExpression idResourceId;
	public final AssociationExpression idResource;
	public final IntegerExpression idUserId;
	public final AssociationExpression idUser;
	
	public RatingsCriteria(Criteria criteria) {
		super(criteria);
		idRatings = new IntegerExpression("idRatings", this);
		rating = new IntegerExpression("rating", this);
		idResourceId = new IntegerExpression("idResource.idResource", this);
		idResource = new AssociationExpression("idResource", this);
		idUserId = new IntegerExpression("idUser.idUser", this);
		idUser = new AssociationExpression("idUser", this);
	}
	
	public RatingsCriteria(PersistentSession session) {
		this(session.createCriteria(Ratings.class));
	}
	
	public RatingsCriteria() throws PersistentException {
		this(UntitledPersistentManager.instance().getSession());
	}
	
	public ResourcesCriteria createIdResourceCriteria() {
		return new ResourcesCriteria(createCriteria("idResource"));
	}
	
	public UsersCriteria createIdUserCriteria() {
		return new UsersCriteria(createCriteria("idUser"));
	}
	
	public Ratings uniqueRatings() {
		return (Ratings) super.uniqueResult();
	}
	
	public Ratings[] listRatings() {
		java.util.List list = super.list();
		return (Ratings[]) list.toArray(new Ratings[list.size()]);
	}
}

