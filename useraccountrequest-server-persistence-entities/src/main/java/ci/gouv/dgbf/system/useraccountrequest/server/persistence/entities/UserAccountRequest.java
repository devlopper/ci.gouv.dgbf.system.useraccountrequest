package ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.cyk.utility.server.persistence.jpa.AbstractEntity;
import org.cyk.utility.string.Strings;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity @Getter @Setter @Accessors(chain=true) @Access(AccessType.FIELD)
@Table(name=UserAccountRequest.TABLE_NAME)
public class UserAccountRequest extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name=COLUMN_CREATION_DATE) private Date creationDate;
	@Column(name=COLUMN_PROCESSING_DATE) private Date processingDate;
	
	@Column(name=COLUMN_LETTER,length=1024 * 100) private String letter;
	
	@Transient private Strings roles;
	@Transient private Strings services;
	@Transient private Persons persons;
	
	@Override
	public UserAccountRequest setCode(String code) {
		return (UserAccountRequest) super.setCode(code);
	}
	
	public Strings getRoles(Boolean injectIfNull) {
		return (Strings) __getInjectIfNull__(FIELD_ROLES, injectIfNull);
	}
	
	public UserAccountRequest addRoles(Collection<String> roles) {
		getRoles(Boolean.TRUE).add(roles);
		return this;
	}
	
	public UserAccountRequest addRoles(String...roles) {
		getRoles(Boolean.TRUE).add(roles);
		return this;
	}
	
	public Persons getPersons(Boolean injectIfNull) {
		return (Persons) __getInjectIfNull__(FIELD_PERSONS, injectIfNull);
	}
	
	public UserAccountRequest addPersons(Collection<Person> persons) {
		getPersons(Boolean.TRUE).add(persons);
		return this;
	}
	
	public UserAccountRequest addPersons(Person...persons) {
		getPersons(Boolean.TRUE).add(persons);
		return this;
	}
	
	public Strings getServices(Boolean injectIfNull) {
		return (Strings) __getInjectIfNull__(FIELD_SERVICES, injectIfNull);
	}
	
	public UserAccountRequest addServices(Collection<String> services) {
		getServices(Boolean.TRUE).add(services);
		return this;
	}
	
	public UserAccountRequest addServices(String...services) {
		getServices(Boolean.TRUE).add(services);
		return this;
	}
	
	/**/
	
	public static final String FIELD_LETTER = "letter";
	public static final String FIELD_ROLES = "roles";
	public static final String FIELD_SERVICES = "services";
	public static final String FIELD_PERSONS = "persons";
	
	//public static final String TABLE_NAME = "dem_cpt_util";
	public static final String TABLE_NAME = "cpt_util";
	
	public static final String COLUMN_LETTER = "lettre";
	public static final String COLUMN_CREATION_DATE = "date_creation";
	public static final String COLUMN_PROCESSING_DATE = "date_traitement";
}
