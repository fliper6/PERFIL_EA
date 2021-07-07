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

public class ResourcesCriteria extends AbstractORMCriteria {
	public final IntegerExpression idResource;
	public final StringExpression title;
	public final StringExpression description;
	public final TimestampExpression createdAt;
	public final TimestampExpression registeredAt;
	public final TimestampExpression lastModifiedAt;
	public final BooleanExpression visibility;
	public final IntegerExpression nDownloads;
	public final BooleanExpression available;
	public final IntegerExpression idResourceTypeId;
	public final AssociationExpression idResourceType;
	public final IntegerExpression idUserId;
	public final AssociationExpression idUser;
	public final CollectionExpression files;
	public final CollectionExpression posts;
	public final CollectionExpression ratings;
	public final CollectionExpression updates;
	
	public ResourcesCriteria(Criteria criteria) {
		super(criteria);
		idResource = new IntegerExpression("idResource", this);
		title = new StringExpression("title", this);
		description = new StringExpression("description", this);
		createdAt = new TimestampExpression("createdAt", this);
		registeredAt = new TimestampExpression("registeredAt", this);
		lastModifiedAt = new TimestampExpression("lastModifiedAt", this);
		visibility = new BooleanExpression("visibility", this);
		nDownloads = new IntegerExpression("nDownloads", this);
		available = new BooleanExpression("available", this);
		idResourceTypeId = new IntegerExpression("idResourceType.idResourceType", this);
		idResourceType = new AssociationExpression("idResourceType", this);
		idUserId = new IntegerExpression("idUser.idUser", this);
		idUser = new AssociationExpression("idUser", this);
		files = new CollectionExpression("ORM_Files", this);
		posts = new CollectionExpression("ORM_Posts", this);
		ratings = new CollectionExpression("ORM_Ratings", this);
		updates = new CollectionExpression("ORM_Updates", this);
	}
	
	public ResourcesCriteria(PersistentSession session) {
		this(session.createCriteria(Resources.class));
	}
	
	public ResourcesCriteria() throws PersistentException {
		this(UntitledPersistentManager.instance().getSession());
	}
	
	public ResourcetypesCriteria createIdResourceTypeCriteria() {
		return new ResourcetypesCriteria(createCriteria("idResourceType"));
	}
	
	public FilesCriteria createFilesCriteria() {
		return new FilesCriteria(createCriteria("ORM_Files"));
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
	
	public Resources uniqueResources() {
		return (Resources) super.uniqueResult();
	}
	
	public Resources[] listResources() {
		java.util.List list = super.list();
		return (Resources[]) list.toArray(new Resources[list.size()]);
	}
}

