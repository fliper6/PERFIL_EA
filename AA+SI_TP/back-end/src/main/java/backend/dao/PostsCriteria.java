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

public class PostsCriteria extends AbstractORMCriteria {
	public final IntegerExpression idPost;
	public final StringExpression title;
	public final StringExpression body;
	public final TimestampExpression createdAt;
	public final IntegerExpression idUserId;
	public final AssociationExpression idUser;
	public final IntegerExpression idResourceId;
	public final AssociationExpression idResource;
	public final CollectionExpression comments;
	
	public PostsCriteria(Criteria criteria) {
		super(criteria);
		idPost = new IntegerExpression("idPost", this);
		title = new StringExpression("title", this);
		body = new StringExpression("body", this);
		createdAt = new TimestampExpression("createdAt", this);
		idUserId = new IntegerExpression("idUser.idUser", this);
		idUser = new AssociationExpression("idUser", this);
		idResourceId = new IntegerExpression("idResource.idResource", this);
		idResource = new AssociationExpression("idResource", this);
		comments = new CollectionExpression("ORM_Comments", this);
	}
	
	public PostsCriteria(PersistentSession session) {
		this(session.createCriteria(Posts.class));
	}
	
	public PostsCriteria() throws PersistentException {
		this(UntitledPersistentManager.instance().getSession());
	}
	
	public UsersCriteria createIdUserCriteria() {
		return new UsersCriteria(createCriteria("idUser"));
	}
	
	public ResourcesCriteria createIdResourceCriteria() {
		return new ResourcesCriteria(createCriteria("idResource"));
	}
	
	public CommentsCriteria createCommentsCriteria() {
		return new CommentsCriteria(createCriteria("ORM_Comments"));
	}
	
	public Posts uniquePosts() {
		return (Posts) super.uniqueResult();
	}
	
	public Posts[] listPosts() {
		java.util.List list = super.list();
		return (Posts[]) list.toArray(new Posts[list.size()]);
	}
}

