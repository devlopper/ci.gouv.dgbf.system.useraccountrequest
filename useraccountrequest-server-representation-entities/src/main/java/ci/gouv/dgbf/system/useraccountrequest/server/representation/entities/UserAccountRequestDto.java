package ci.gouv.dgbf.system.useraccountrequest.server.representation.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.cyk.utility.__kernel__.object.__static__.representation.Strings;
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
	private Strings roles;
	private Strings services;
	private Collection<PersonDto> persons;
	private Boolean isNotify = Boolean.TRUE;
	
	@XmlElement(name="roles")
	public Strings getRoles(){
		return roles;
	}
	
	public UserAccountRequestDto addRoles(Collection<String> codes) {
		if(__inject__(CollectionHelper.class).isNotEmpty(codes)) {
			if(this.roles == null)
				this.roles = new Strings();
			this.roles.add(codes);
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
	
	public UserAccountRequestDto addPerson(String firstName,String lastNames,String electronicMailAddress) {
		if(persons == null)
			persons = new ArrayList<>();
		persons.add(new PersonDto().setFirstName(firstName).setLastNames(lastNames).setElectronicMailAddress(electronicMailAddress));
		return this;
	}
	
	@XmlElement(name="services")
	public Strings getServices(){
		return services;
	}
	
	public UserAccountRequestDto addServices(Collection<String> codes) {
		if(__inject__(CollectionHelper.class).isNotEmpty(codes)) {
			if(this.services == null)
				this.services = new Strings();
			this.services.add(codes);
		}
		return this;
	}
	
	public UserAccountRequestDto addServices(String...codes) {
		return addServices(__inject__(CollectionHelper.class).instanciate(codes));
	}
}
