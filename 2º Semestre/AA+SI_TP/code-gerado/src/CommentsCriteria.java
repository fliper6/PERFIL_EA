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

public class CommentsCriteria extends AbstractORMCriteria {
	public final IntegerExpression idComment;
	public final StringExpression body;
	public final TimestampExpression createdAt;
	public final IntegerExpression idUserId;
	public final AssociationExpression idUser;
	public final IntegerExpression idPostId;
	public final AssociationExpression idPost;
	
	public CommentsCriteria(Criteria criteria) {
		super(criteria);
		idComment = new IntegerExpression("idComment", this);
		body = new StringExpression("body", this);
		createdAt = new TimestampExpression("createdAt", this);
		idUserId = new IntegerExpression("idUser.idUser", this);
		idUser = new AssociationExpression("idUser", this);
		idPostId = new IntegerExpression("idPost.idPost", this);
		idPost = new AssociationExpression("idPost", this);
	}
	
	public CommentsCriteria(PersistentSession session) {
		this(session.createCriteria(Comments.class));
	}
	
	public CommentsCriteria() throws PersistentException {
		this(UntitledPersistentManager.instance().getSession());
	}
	
	public UsersCriteria createIdUserCriteria() {
		return new UsersCriteria(createCriteria("idUser"));
	}
	
	public PostsCriteria createIdPostCriteria() {
		return new PostsCriteria(createCriteria("idPost"));
	}
	
	public Comments uniqueComments() {
		return (Comments) super.uniqueResult();
	}
	
	public Comments[] listComments() {
		java.util.List list = super.list();
		return (Comments[]) list.toArray(new Comments[list.size()]);
	}
}

