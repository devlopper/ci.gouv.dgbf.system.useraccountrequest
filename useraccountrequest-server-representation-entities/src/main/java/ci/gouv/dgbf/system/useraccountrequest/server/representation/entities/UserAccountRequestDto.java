package ci.gouv.dgbf.system.useraccountrequest.server.representation.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.cyk.utility.collection.CollectionHelper;
import org.cyk.utility.server.representation.AbstractEntityFromPersistenceEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@XmlRootElement @Getter @Setter @Accessors(chain=true) @NoArgsConstructor
public class UserAccountRequestDto extends AbstractEntityFromPersistenceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String letter;
	private String creationDate;
	private Collection<String> roles;
	private Collection<String> services;
	private Collection<PersonDto> persons;
	
	@XmlElement(name="roles")
	public Collection<String> getRoles(){
		return roles;
	}
	
	public UserAccountRequestDto addRoles(Collection<String> codes) {
		if(__inject__(CollectionHelper.class).isNotEmpty(codes)) {
			if(roles == null)
				roles = new ArrayList<>();
			for(String index : codes)
				roles.add(index);
		}
		return this;
	}
	
	public UserAccountRequestDto addRoles(String...codes) {
		return addRoles(__inject__(CollectionHelper.class).instanciate(codes));
	}
	
	@XmlElement(name="persons")
	public Collection<PersonDto> getPersons(){
		return persons;
	}
	
	public UserAccountRequestDto addPerson(String firstName,String lastNames) {
		if(persons == null)
			persons = new ArrayList<>();
		persons.add(new PersonDto().setFirstName(firstName).setLastNames(lastNames));
		return this;
	}
	
	@XmlElement(name="services")
	public Collection<String> getServices(){
		return services;
	}
	
	public UserAccountRequestDto addServices(Collection<String> codes) {
		if(__inject__(CollectionHelper.class).isNotEmpty(codes)) {
			if(services == null)
				services = new ArrayList<>();
			for(String index : codes)
				services.add(index);
		}
		return this;
	}
	
	public UserAccountRequestDto addServices(String...codes) {
		return addServices(__inject__(CollectionHelper.class).instanciate(codes));
	}
}
