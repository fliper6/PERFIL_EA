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

public class CommentsDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idComment;
	public final StringExpression body;
	public final TimestampExpression createdAt;
	public final IntegerExpression idUserId;
	public final AssociationExpression idUser;
	public final IntegerExpression idPostId;
	public final AssociationExpression idPost;
	
	public CommentsDetachedCriteria() {
		super(Comments.class, CommentsCriteria.class);
		idComment = new IntegerExpression("idComment", this.getDetachedCriteria());
		body = new StringExpression("body", this.getDetachedCriteria());
		createdAt = new TimestampExpression("createdAt", this.getDetachedCriteria());
		idUserId = new IntegerExpression("idUser.idUser", this.getDetachedCriteria());
		idUser = new AssociationExpression("idUser", this.getDetachedCriteria());
		idPostId = new IntegerExpression("idPost.idPost", this.getDetachedCriteria());
		idPost = new AssociationExpression("idPost", this.getDetachedCriteria());
	}
	
	public CommentsDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, CommentsCriteria.class);
		idComment = new IntegerExpression("idComment", this.getDetachedCriteria());
		body = new StringExpression("body", this.getDetachedCriteria());
		createdAt = new TimestampExpression("createdAt", this.getDetachedCriteria());
		idUserId = new IntegerExpression("idUser.idUser", this.getDetachedCriteria());
		idUser = new AssociationExpression("idUser", this.getDetachedCriteria());
		idPostId = new IntegerExpression("idPost.idPost", this.getDetachedCriteria());
		idPost = new AssociationExpression("idPost", this.getDetachedCriteria());
	}
	
	public UsersDetachedCriteria createIdUserCriteria() {
		return new UsersDetachedCriteria(createCriteria("idUser"));
	}
	
	public PostsDetachedCriteria createIdPostCriteria() {
		return new PostsDetachedCriteria(createCriteria("idPost"));
	}
	
	public Comments uniqueComments(PersistentSession session) {
		return (Comments) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Comments[] listComments(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Comments[]) list.toArray(new Comments[list.size()]);
	}
}

