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

public class UsersCriteria extends AbstractORMCriteria {
	public final IntegerExpression idUser;
	public final StringExpression email;
	public final StringExpression password;
	public final StringExpression level;
	public final TimestampExpression registerDate;
	public final StringExpression description;
	public final StringExpression picture;
	public final BooleanExpression blocked;
	public final IntegerExpression idRoleId;
	public final AssociationExpression idRole;
	public final CollectionExpression comments;
	public final CollectionExpression posts;
	public final CollectionExpression ratings;
	public final CollectionExpression updates;
	
	public UsersCriteria(Criteria criteria) {
		super(criteria);
		idUser = new IntegerExpression("idUser", this);
		email = new StringExpression("email", this);
		password = new StringExpression("password", this);
		level = new StringExpression("level", this);
		registerDate = new TimestampExpression("registerDate", this);
		description = new StringExpression("description", this);
		picture = new StringExpression("picture", this);
		blocked = new BooleanExpression("blocked", this);
		idRoleId = new IntegerExpression("idRole.idRole", this);
		idRole = new AssociationExpression("idRole", this);
		comments = new CollectionExpression("ORM_Comments", this);
		posts = new CollectionExpression("ORM_Posts", this);
		ratings = new CollectionExpression("ORM_Ratings", this);
		updates = new CollectionExpression("ORM_Updates", this);
	}
	
	public UsersCriteria(PersistentSession session) {
		this(session.createCriteria(Users.class));
	}
	
	public UsersCriteria() throws PersistentException {
		this(UntitledPersistentManager.instance().getSession());
	}
	
	public RolesCriteria createIdRoleCriteria() {
		return new RolesCriteria(createCriteria("idRole"));
	}
	
	public CommentsCriteria createCommentsCriteria() {
		return new CommentsCriteria(createCriteria("ORM_Comments"));
	}
	
	public PostsCriteria createPostsCriteria() {
		return new PostsCriteria(createCriteria("ORM_Posts"));
	}
	
	public RatingsCriteria createRatingsCriteria() {
		return new RatingsCriteria(createCriteria("ORM_Ratings"));
	}
	
	public UpdatesCriteria createUpdatesCriteria() {
		return new UpdatesCriteria(createCriteria("ORM_Updates"));
	}
	
	public Users uniqueUsers() {
		return (Users) super.uniqueResult();
	}
	
	public Users[] listUsers() {
		java.util.List list = super.list();
		return (Users[]) list.toArray(new Users[list.size()]);
	}
}

