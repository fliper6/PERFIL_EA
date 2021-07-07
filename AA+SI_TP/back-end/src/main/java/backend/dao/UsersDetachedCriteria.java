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

public class UsersDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public UsersDetachedCriteria() {
		super(Users.class, UsersCriteria.class);
		idUser = new IntegerExpression("idUser", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		level = new StringExpression("level", this.getDetachedCriteria());
		registerDate = new TimestampExpression("registerDate", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		picture = new StringExpression("picture", this.getDetachedCriteria());
		blocked = new BooleanExpression("blocked", this.getDetachedCriteria());
		idRoleId = new IntegerExpression("idRole.idRole", this.getDetachedCriteria());
		idRole = new AssociationExpression("idRole", this.getDetachedCriteria());
		comments = new CollectionExpression("ORM_Comments", this.getDetachedCriteria());
		posts = new CollectionExpression("ORM_Posts", this.getDetachedCriteria());
		ratings = new CollectionExpression("ORM_Ratings", this.getDetachedCriteria());
		updates = new CollectionExpression("ORM_Updates", this.getDetachedCriteria());
	}
	
	public UsersDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, UsersCriteria.class);
		idUser = new IntegerExpression("idUser", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		level = new StringExpression("level", this.getDetachedCriteria());
		registerDate = new TimestampExpression("registerDate", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		picture = new StringExpression("picture", this.getDetachedCriteria());
		blocked = new BooleanExpression("blocked", this.getDetachedCriteria());
		idRoleId = new IntegerExpression("idRole.idRole", this.getDetachedCriteria());
		idRole = new AssociationExpression("idRole", this.getDetachedCriteria());
		comments = new CollectionExpression("ORM_Comments", this.getDetachedCriteria());
		posts = new CollectionExpression("ORM_Posts", this.getDetachedCriteria());
		ratings = new CollectionExpression("ORM_Ratings", this.getDetachedCriteria());
		updates = new CollectionExpression("ORM_Updates", this.getDetachedCriteria());
	}
	
	public RolesDetachedCriteria createIdRoleCriteria() {
		return new RolesDetachedCriteria(createCriteria("idRole"));
	}
	
	public CommentsDetachedCriteria createCommentsCriteria() {
		return new CommentsDetachedCriteria(createCriteria("ORM_Comments"));
	}
	
	public PostsDetachedCriteria createPostsCriteria() {
		return new PostsDetachedCriteria(createCriteria("ORM_Posts"));
	}
	
	public RatingsDetachedCriteria createRatingsCriteria() {
		return new RatingsDetachedCriteria(createCriteria("ORM_Ratings"));
	}
	
	public UpdatesDetachedCriteria createUpdatesCriteria() {
		return new UpdatesDetachedCriteria(createCriteria("ORM_Updates"));
	}
	
	public Users uniqueUsers(PersistentSession session) {
		return (Users) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Users[] listUsers(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Users[]) list.toArray(new Users[list.size()]);
	}
}

