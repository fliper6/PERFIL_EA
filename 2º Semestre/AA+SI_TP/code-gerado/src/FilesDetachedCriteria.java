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

public class FilesDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idFile;
	public final StringExpression name;
	public final StringExpression mimetype;
	public final StringExpression path;
	public final IntegerExpression idResourceId;
	public final AssociationExpression idResource;
	
	public FilesDetachedCriteria() {
		super(Files.class, FilesCriteria.class);
		idFile = new IntegerExpression("idFile", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		mimetype = new StringExpression("mimetype", this.getDetachedCriteria());
		path = new StringExpression("path", this.getDetachedCriteria());
		idResourceId = new IntegerExpression("idResource.idResource", this.getDetachedCriteria());
		idResource = new AssociationExpression("idResource", this.getDetachedCriteria());
	}
	
	public FilesDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, FilesCriteria.class);
		idFile = new IntegerExpression("idFile", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		mimetype = new StringExpression("mimetype", this.getDetachedCriteria());
		path = new StringExpression("path", this.getDetachedCriteria());
		idResourceId = new IntegerExpression("idResource.idResource", this.getDetachedCriteria());
		idResource = new AssociationExpression("idResource", this.getDetachedCriteria());
	}
	
	public ResourcesDetachedCriteria createIdResourceCriteria() {
		return new ResourcesDetachedCriteria(createCriteria("idResource"));
	}
	
	public Files uniqueFiles(PersistentSession session) {
		return (Files) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Files[] listFiles(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Files[]) list.toArray(new Files[list.size()]);
	}
}

