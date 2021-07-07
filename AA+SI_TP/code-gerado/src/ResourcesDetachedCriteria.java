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

public class ResourcesDetachedCriteria extends AbstractORMDetachedCriteria {
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
	public final CollectionExpression files;
	public final CollectionExpression posts;
	public final CollectionExpression ratings;
	public final CollectionExpression updates;
	
	public ResourcesDetachedCriteria() {
		super(Resources.class, ResourcesCriteria.class);
		idResource = new IntegerExpression("idResource", this.getDetachedCriteria());
		title = new StringExpression("title", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		createdAt = new TimestampExpression("createdAt", this.getDetachedCriteria());
		registeredAt = new TimestampExpression("registeredAt", this.getDetachedCriteria());
		lastModifiedAt = new TimestampExpression("lastModifiedAt", this.getDetachedCriteria());
		visibility = new BooleanExpression("visibility", this.getDetachedCriteria());
		nDownloads = new IntegerExpression("nDownloads", this.getDetachedCriteria());
		available = new BooleanExpression("available", this.getDetachedCriteria());
		idResourceTypeId = new IntegerExpression("idResourceType.idResourceType", this.getDetachedCriteria());
		idResourceType = new AssociationExpression("idResourceType", this.getDetachedCriteria());
		files = new CollectionExpression("ORM_Files", this.getDetachedCriteria());
		posts = new CollectionExpression("ORM_Posts", this.getDetachedCriteria());
		ratings = new CollectionExpression("ORM_Ratings", this.getDetachedCriteria());
		updates = new CollectionExpression("ORM_Updates", this.getDetachedCriteria());
	}
	
	public ResourcesDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ResourcesCriteria.class);
		idResource = new IntegerExpression("idResource", this.getDetachedCriteria());
		title = new StringExpression("title", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		createdAt = new TimestampExpression("createdAt", this.getDetachedCriteria());
		registeredAt = new TimestampExpression("registeredAt", this.getDetachedCriteria());
		lastModifiedAt = new TimestampExpression("lastModifiedAt", this.getDetachedCriteria());
		visibility = new BooleanExpression("visibility", this.getDetachedCriteria());
		nDownloads = new IntegerExpression("nDownloads", this.getDetachedCriteria());
		available = new BooleanExpression("available", this.getDetachedCriteria());
		idResourceTypeId = new IntegerExpression("idResourceType.idResourceType", this.getDetachedCriteria());
		idResourceType = new AssociationExpression("idResourceType", this.getDetachedCriteria());
		files = new CollectionExpression("ORM_Files", this.getDetachedCriteria());
		posts = new CollectionExpression("ORM_Posts", this.getDetachedCriteria());
		ratings = new CollectionExpression("ORM_Ratings", this.getDetachedCriteria());
		updates = new CollectionExpression("ORM_Updates", this.getDetachedCriteria());
	}
	
	public ResourcetypesDetachedCriteria createIdResourceTypeCriteria() {
		return new ResourcetypesDetachedCriteria(createCriteria("idResourceType"));
	}
	
	public FilesDetachedCriteria createFilesCriteria() {
		return new FilesDetachedCriteria(createCriteria("ORM_Files"));
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
	
	public Resources uniqueResources(PersistentSession session) {
		return (Resources) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Resources[] listResources(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Resources[]) list.toArray(new Resources[list.size()]);
	}
}

