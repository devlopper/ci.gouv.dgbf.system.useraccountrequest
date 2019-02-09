package ci.gouv.dgbf.system.useraccountrequest.server.persistence.impl;

import java.io.Serializable;

import javax.inject.Singleton;

import org.cyk.utility.server.persistence.jpa.AbstractPersistenceEntityImpl;

import ci.gouv.dgbf.system.useraccountrequest.server.persistence.api.UserAccountRequestPersistence;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequest;

@Singleton
public class UserAccountRequestPersistenceImpl extends AbstractPersistenceEntityImpl<UserAccountRequest> implements UserAccountRequestPersistence,Serializable {
	private static final long serialVersionUID = 1L;

}
