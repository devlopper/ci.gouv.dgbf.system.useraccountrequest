package ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.cyk.utility.server.persistence.jpa.AbstractEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Entity @Getter @Setter @Accessors(chain=true) @Access(AccessType.FIELD) @ToString
@Table(name=Person.TABLE_NAME)
public class Person extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name=COLUMN_FIRST_NAME) private String firstName;
	@Column(name=COLUMN_LAST_NAMES) private String lastNames;
	@Column(name=COLUMN_IS_MASCULINE) private Boolean isMasculine;
	
	//Contacts
	@Column(name=COLUMN_ELECTRONIC_MAIL_ADDRESS) private String electronicMailAddress;
	@Column(name=COLUMN_PHONE_NUMBER) private String phoneNumber;
	
	//Transients
	@Transient private String administrativeUnit;
	@Transient private String function;
	
	/**/
	
	@Override
	public Person setCode(String code) {
		return (Person) super.setCode(code);
	}
	
	/**/
	
	public static final String FIELD_FIRST_NAME = "firstName";
	public static final String FIELD_LAST_NAMES = "lastNames";
	public static final String FIELD_IS_MASCULINE = "isMasculine";
	public static final String FIELD_ELECTRONIC_MAIL_ADDRESS = "electronicMailAddress";
	public static final String FIELD_PHONE_NUMBER = "phoneNumber";
	
	public static final String TABLE_NAME = "pers";
	
	public static final String COLUMN_FIRST_NAME = "nom";
	public static final String COLUMN_LAST_NAMES = "prenoms";
	public static final String COLUMN_IS_MASCULINE = "sexe";
	public static final String COLUMN_ELECTRONIC_MAIL_ADDRESS = "adresse_electronique";
	public static final String COLUMN_PHONE_NUMBER = "numero_telephone";
	
}
