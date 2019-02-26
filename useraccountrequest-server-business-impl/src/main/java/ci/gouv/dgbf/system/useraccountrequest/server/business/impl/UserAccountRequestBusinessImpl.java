package ci.gouv.dgbf.system.useraccountrequest.server.business.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.inject.Singleton;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.random.RandomHelper;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;
import org.cyk.utility.server.business.BusinessServiceProvider;
import org.cyk.utility.string.StringHelper;
import org.cyk.utility.string.Strings;

import ci.gouv.dgbf.system.useraccountrequest.server.business.api.UserAccountRequestBusiness;
import ci.gouv.dgbf.system.useraccountrequest.server.business.api.UserAccountRequestPersonBusiness;
import ci.gouv.dgbf.system.useraccountrequest.server.business.api.UserAccountRequestRoleBusiness;
import ci.gouv.dgbf.system.useraccountrequest.server.business.api.UserAccountRequestServiceBusiness;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.api.UserAccountRequestPersistence;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.api.UserAccountRequestPersonPersistence;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.api.UserAccountRequestRolePersistence;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.api.UserAccountRequestServicePersistence;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.Person;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.Persons;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequest;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequestPerson;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequestRole;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequestService;

@Singleton
public class UserAccountRequestBusinessImpl extends AbstractBusinessEntityImpl<UserAccountRequest, UserAccountRequestPersistence> implements UserAccountRequestBusiness,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected Class<UserAccountRequest> __getPersistenceEntityClass__() {
		return UserAccountRequest.class;
	}
	
	@Override
	public BusinessServiceProvider<UserAccountRequest> create(UserAccountRequest userAccountRequest, Properties properties) {
		if(__injectStringHelper__().isBlank(userAccountRequest.getCode()))
			userAccountRequest.setCode(__inject__(RandomHelper.class).getAlphanumeric(3));
		userAccountRequest.setCreationDate(new Date());
		super.create(userAccountRequest, properties);
		
		Strings roles = userAccountRequest.getRoles();
		if(__injectCollectionHelper__().isNotEmpty(roles)) {
			Collection<UserAccountRequestRole> userAccountRequestRoles = new ArrayList<>();
			for(String index : roles.get())
				if(index!=null)
					userAccountRequestRoles.add(new UserAccountRequestRole().setUserAccountRequest(userAccountRequest).setRole(index));
			__inject__(UserAccountRequestRoleBusiness.class).createMany(userAccountRequestRoles);
		}
		
		Strings services = userAccountRequest.getServices();
		if(__injectCollectionHelper__().isNotEmpty(services)) {
			Collection<UserAccountRequestService> userAccountRequestServices = new ArrayList<>();
			for(String index : services.get())
				if(__inject__(StringHelper.class).isNotBlank(index))
					userAccountRequestServices.add(new UserAccountRequestService().setUserAccountRequest(userAccountRequest).setService(index));
			__inject__(UserAccountRequestServiceBusiness.class).createMany(userAccountRequestServices);
		}
		
		Persons persons = userAccountRequest.getPersons();
		if(__injectCollectionHelper__().isNotEmpty(persons)) {
			Collection<UserAccountRequestPerson> userAccountRequestPersons = new ArrayList<>();
			for(Person index : persons.get())
				if(index!=null) {
					UserAccountRequestPerson userAccountRequestPerson = new UserAccountRequestPerson().setUserAccountRequest(userAccountRequest).setPerson(index)
						.setAdministrativeUnit(index.getAdministrativeUnit()).setFunction(index.getFunction());
					
					userAccountRequestPersons.add(userAccountRequestPerson);
				}
			__inject__(UserAccountRequestPersonBusiness.class).createMany(userAccountRequestPersons);
			
			//Notification
			__sendMail__("SIB - Demande de compte utilisateur", persons.getAt(0).getFirstName()
					+" "+persons.getAt(0).getLastNames()
					+" , votre demande de compte utilisateur a été enregistrée avec succès. Le code de cette demande est "+userAccountRequest.getCode()
					, Arrays.asList(persons.getAt(0).getElectronicMailAddress()), Boolean.FALSE);
		}
		
		return this;
	}
	
	@Override
	public BusinessServiceProvider<UserAccountRequest> delete(UserAccountRequest userAccountRequest, Properties properties) {
		__inject__(UserAccountRequestRoleBusiness.class).deleteMany(
				__inject__(UserAccountRequestRolePersistence.class).readByUserAccountRequest(userAccountRequest));
		
		__inject__(UserAccountRequestServiceBusiness.class).deleteMany(
				__inject__(UserAccountRequestServicePersistence.class).readByUserAccountRequest(userAccountRequest));
		
		__inject__(UserAccountRequestPersonBusiness.class).deleteMany(
				__inject__(UserAccountRequestPersonPersistence.class).readByUserAccountRequest(userAccountRequest));
		return super.delete(userAccountRequest, properties);
	}
	
}
