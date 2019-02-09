package ci.gouv.dgbf.system.useraccountrequest.server.persistence.api;

import java.util.Collection;

import org.cyk.utility.server.persistence.jpa.PersistenceEntity;

import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequest;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequestPerson;

public interface UserAccountRequestPersonPersistence extends PersistenceEntity<UserAccountRequestPerson> {

	Collection<UserAccountRequestPerson> readByUserAccountRequest(UserAccountRequest userAccountRequest);
	
}
