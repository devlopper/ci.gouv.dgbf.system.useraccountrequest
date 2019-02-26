package ci.gouv.dgbf.system.useraccountrequest.client.controller.entities;

import java.util.Collection;
import java.util.Date;

import org.cyk.utility.client.controller.data.Data;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Role;

public interface UserAccountRequest extends Data {

	@Override UserAccountRequest setIdentifier(Object identifier);
	@Override UserAccountRequest setCode(String code);
	
	String getCreationDate();
	UserAccountRequest setCreationDate(String creationDate);
	
	Person getPerson();
	UserAccountRequest setPerson(Person person);
	
	Persons getPersons();
	Persons getPersons(Boolean injectIfNull);
	UserAccountRequest setPersons(Persons persons);
	UserAccountRequest addPersons(Collection<Person> persons);
	UserAccountRequest addPersons(Person...persons);
	
	Integer getNumberOfPerson();
	UserAccountRequest setNumberOfPerson(Integer numberOfPerson);
	
	Collection<Role> getRoles();
	Collection<Role> getRoles(Boolean injectIfNull);
	UserAccountRequest setRoles(Collection<Role> roles);
	UserAccountRequest addRoles(Collection<Role> roles);
	UserAccountRequest addRoles(Role...roles);
	
	Collection<Service> getServices();
	Collection<Service> getServices(Boolean injectIfNull);
	UserAccountRequest setServices(Collection<Service> services);
	UserAccountRequest addServices(Collection<Service> roles);
	UserAccountRequest addServices(Service...services);
	
	String getComments();
	UserAccountRequest setComments(String comments);
	
	String getLetter();
	UserAccountRequest setLetter(String letter);
	
	Date getProcessingDate();
	UserAccountRequest setProcessingDate(Date processingDate);
	
	String getStatus();
	UserAccountRequest setStatus(String status);
	
	String getAccepted();
	UserAccountRequest setAccepted(String accepted);
	
	/**/
	
	String PROPERTY_CREATION_DATE = "creationDate";
	String PROPERTY_PERSON = "person";
	String PROPERTY_PERSONS = "persons";
	String PROPERTY_NUMBER_OF_PERSON = "numberOfPerson";
	String PROPERTY_COMMENTS = "comments";
	String PROPERTY_LETTER = "letter";
	String PROPERTY_PROCESSING_DATE = "processingDate";
	String PROPERTY_STATUS = "status";
	String PROPERTY_ACCEPTED = "accepted";
	String PROPERTY_ROLES = "roles";
	String PROPERTY_SERVICES = "services";
	String PROPERTY_SOFTWARES = "softwares";
	String PROPERTY_CREDENTIALS = "credentials";
}
