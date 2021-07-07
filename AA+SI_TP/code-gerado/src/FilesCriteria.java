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

public class FilesCriteria extends AbstractORMCriteria {
	public final IntegerExpression idFile;
	public final StringExpression name;
	public final StringExpression mimetype;
	public final StringExpression path;
	public final IntegerExpression idResourceId;
	public final AssociationExpression idResource;
	
	public FilesCriteria(Criteria criteria) {
		super(criteria);
		idFile = new IntegerExpression("idFile", this);
		name = new StringExpression("name", this);
		mimetype = new StringExpression("mimetype", this);
		path = new StringExpression("path", this);
		idResourceId = new IntegerExpression("idResource.idResource", this);
		idResource = new AssociationExpression("idResource", this);
	}
	
	public FilesCriteria(PersistentSession session) {
		this(session.createCriteria(Files.class));
	}
	
	public FilesCriteria() throws PersistentException {
		this(UntitledPersistentManager.instance().getSession());
	}
	
	public ResourcesCriteria createIdResourceCriteria() {
		return new ResourcesCriteria(createCriteria("idResource"));
	}
	
	public Files uniqueFiles() {
		return (Files) super.uniqueResult();
	}
	
	public Files[] listFiles() {
		java.util.List list = super.list();
		return (Files[]) list.toArray(new Files[list.size()]);
	}
}

