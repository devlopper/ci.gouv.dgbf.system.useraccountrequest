package ci.gouv.dgbf.system.useraccountrequest.server.representation.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import org.cyk.utility.collection.CollectionHelper;
import org.cyk.utility.instance.AbstractInstanceBuilderFunctionRunnableImpl;
import org.cyk.utility.instance.InstanceHelper;
import org.cyk.utility.string.StringHelper;

import ci.gouv.dgbf.system.useraccountrequest.server.business.api.PersonBusiness;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.api.UserAccountRequestPersonPersistence;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.api.UserAccountRequestRolePersistence;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.api.UserAccountRequestServicePersistence;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.Person;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequest;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequestPerson;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequestRole;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequestService;
import ci.gouv.dgbf.system.useraccountrequest.server.representation.entities.PersonDto;
import ci.gouv.dgbf.system.useraccountrequest.server.representation.entities.UserAccountRequestDto;

public class InstanceBuilderFunctionRunnableImpl extends AbstractInstanceBuilderFunctionRunnableImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void __copy__(Object source, Object destination) {
		if(source instanceof UserAccountRequestDto && destination instanceof UserAccountRequest) {
			UserAccountRequestDto representation = (UserAccountRequestDto) source;
			UserAccountRequest persistence = (UserAccountRequest) destination;
			persistence.setCode(representation.getCode());
			persistence.setLetter(representation.getLetter());
			persistence.setIsNotify(representation.getIsNotify());
			
			if(representation.getRoles()!=null && __inject__(CollectionHelper.class).isNotEmpty(representation.getRoles().getCollection())) {
				persistence.setRoles(null);
				for(String index : representation.getRoles().getCollection()) {
					if(__inject__(StringHelper.class).isNotBlank(index))
						persistence.getRoles(Boolean.TRUE).add(index);
				}
			}
			
			if(__inject__(CollectionHelper.class).isNotEmpty(representation.getPersons())) {
				persistence.setPersons(null);
				for(PersonDto index : representation.getPersons()) {
					Person person = null;
					if(__inject__(StringHelper.class).isBlank(index.getCode()))
						person = __inject__(InstanceHelper.class).buildOne(Person.class, index);
					else
						person = __inject__(PersonBusiness.class).findOneByBusinessIdentifier(index.getCode());
					persistence.getPersons(Boolean.TRUE).add(person);
				}
			}
			
			if(representation.getServices()!=null && __inject__(CollectionHelper.class).isNotEmpty(representation.getServices().getCollection())) {
				persistence.setServices(null);
				for(String index : representation.getServices().getCollection())
					persistence.getServices(Boolean.TRUE).add(index);	
			}
		}else if(source instanceof UserAccountRequest && destination instanceof UserAccountRequestDto) {
			UserAccountRequest persistence = (UserAccountRequest) source;
			UserAccountRequestDto representation = (UserAccountRequestDto) destination;
			representation.setIdentifier(persistence.getIdentifier().toString());
			representation.setCode(persistence.getCode());
			representation.setLetter(persistence.getLetter());
			representation.setCreationDate(new SimpleDateFormat("dd/MM/yyyy hh:mm", Locale.FRANCE).format(persistence.getCreationDate()));
			
			Collection<UserAccountRequestRole> userAccountRequestRoles = __inject__(UserAccountRequestRolePersistence.class).readByUserAccountRequest(persistence);
			if(__inject__(CollectionHelper.class).isNotEmpty(userAccountRequestRoles)) {
				for(UserAccountRequestRole index : userAccountRequestRoles)
					representation.addRoles(index.getRole());
			}
			
			Collection<UserAccountRequestPerson> userAccountRequestPersons = __inject__(UserAccountRequestPersonPersistence.class).readByUserAccountRequest(persistence);
			if(__inject__(CollectionHelper.class).isNotEmpty(userAccountRequestPersons)) {
				representation.setPersons(new ArrayList<>());
				for(UserAccountRequestPerson index : userAccountRequestPersons) {
					PersonDto person = __inject__(InstanceHelper.class).buildOne(PersonDto.class, index.getPerson());
					person.setAdministrativeUnit(index.getAdministrativeUnit());
					person.setFunction(index.getFunction());
					representation.getPersons().add(person);
				}
			}
			
			Collection<UserAccountRequestService> userAccountRequestServices = __inject__(UserAccountRequestServicePersistence.class).readByUserAccountRequest(persistence);
			if(__inject__(CollectionHelper.class).isNotEmpty(userAccountRequestServices)) {
				for(UserAccountRequestService index : userAccountRequestServices)
					representation.addServices(index.getService());
			}
		}else
			super.__copy__(source, destination);
	}
	
}
