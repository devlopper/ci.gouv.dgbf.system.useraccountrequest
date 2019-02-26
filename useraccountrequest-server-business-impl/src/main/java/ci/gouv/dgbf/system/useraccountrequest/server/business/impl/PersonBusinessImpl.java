package ci.gouv.dgbf.system.useraccountrequest.server.business.impl;

import javax.inject.Singleton;

import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

import ci.gouv.dgbf.system.useraccountrequest.server.business.api.PersonBusiness;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.api.PersonPersistence;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.Person;

@Singleton
public class PersonBusinessImpl extends AbstractBusinessEntityImpl<Person, PersonPersistence> implements PersonBusiness {
	private static final long serialVersionUID = 1L;

	@Override
	protected Class<Person> __getPersistenceEntityClass__() {
		return Person.class;
	}
	
}
