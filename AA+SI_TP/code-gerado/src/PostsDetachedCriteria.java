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

public class PostsDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idPost;
	public final StringExpression body;
	public final TimestampExpression createdAt;
	public final IntegerExpression idUserId;
	public final AssociationExpression idUser;
	public final IntegerExpression idResourceId;
	public final AssociationExpression idResource;
	public final CollectionExpression comments;
	
	public PostsDetachedCriteria() {
		super(Posts.class, PostsCriteria.class);
		idPost = new IntegerExpression("idPost", this.getDetachedCriteria());
		body = new StringExpression("body", this.getDetachedCriteria());
		createdAt = new TimestampExpression("createdAt", this.getDetachedCriteria());
		idUserId = new IntegerExpression("idUser.idUser", this.getDetachedCriteria());
		idUser = new AssociationExpression("idUser", this.getDetachedCriteria());
		idResourceId = new IntegerExpression("idResource.idResource", this.getDetachedCriteria());
		idResource = new AssociationExpression("idResource", this.getDetachedCriteria());
		comments = new CollectionExpression("ORM_Comments", this.getDetachedCriteria());
	}
	
	public PostsDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, PostsCriteria.class);
		idPost = new IntegerExpression("idPost", this.getDetachedCriteria());
		body = new StringExpression("body", this.getDetachedCriteria());
		createdAt = new TimestampExpression("createdAt", this.getDetachedCriteria());
		idUserId = new IntegerExpression("idUser.idUser", this.getDetachedCriteria());
		idUser = new AssociationExpression("idUser", this.getDetachedCriteria());
		idResourceId = new IntegerExpression("idResource.idResource", this.getDetachedCriteria());
		idResource = new AssociationExpression("idResource", this.getDetachedCriteria());
		comments = new CollectionExpression("ORM_Comments", this.getDetachedCriteria());
	}
	
	public UsersDetachedCriteria createIdUserCriteria() {
		return new UsersDetachedCriteria(createCriteria("idUser"));
	}
	
	public ResourcesDetachedCriteria createIdResourceCriteria() {
		return new ResourcesDetachedCriteria(createCriteria("idResource"));
	}
	
	public CommentsDetachedCriteria createCommentsCriteria() {
		return new CommentsDetachedCriteria(createCriteria("ORM_Comments"));
	}
	
	public Posts uniquePosts(PersistentSession session) {
		return (Posts) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Posts[] listPosts(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Posts[]) list.toArray(new Posts[list.size()]);
	}
}

