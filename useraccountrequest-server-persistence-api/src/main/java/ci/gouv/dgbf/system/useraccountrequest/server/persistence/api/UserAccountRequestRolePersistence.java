package ci.gouv.dgbf.system.useraccountrequest.server.persistence.api;

import java.util.Collection;

import org.cyk.utility.server.persistence.jpa.PersistenceEntity;

import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequest;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequestRole;

public interface UserAccountRequestRolePersistence extends PersistenceEntity<UserAccountRequestRole> {

	Collection<UserAccountRequestRole> readByUserAccountRequest(UserAccountRequest userAccountRequest);
	
}
