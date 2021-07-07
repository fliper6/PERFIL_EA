/**
 * Licensee: Filipa Santos(Universidade do Minho)
 * License Type: Academic
 */
import org.orm.*;
public class CreateUntitledDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(UntitledPersistentManager.instance());
			UntitledPersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
