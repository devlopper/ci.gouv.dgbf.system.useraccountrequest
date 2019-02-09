package ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.cyk.utility.server.persistence.jpa.AbstractEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity @Getter @Setter @Accessors(chain=true) @Table(
		name=UserAccountRequestPerson.TABLE_NAME,
		uniqueConstraints= {
		@UniqueConstraint(name=UserAccountRequestPerson.UNIQUE_CONSTRAINT_USER_ACCOUNT_REQUEST_PERSON_NAME,columnNames= {UserAccountRequestPerson.COLUMN_USER_ACCOUNTS_REQUEST,UserAccountRequestPerson.COLUMN_PERSON})
})
@Access(AccessType.FIELD) 
public class UserAccountRequestPerson extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@JoinColumn(name=COLUMN_USER_ACCOUNTS_REQUEST) @ManyToOne @NotNull private UserAccountRequest userAccountRequest;
	@JoinColumn(name=COLUMN_PERSON) @ManyToOne @NotNull private Person person;
	//Use boolean for status
	@Column(name=COLUMN_STATUS) private String status;
	@Column(name=COLUMN_ACCOUNT_CREATION_DATE) private Date accountCreationDate;
	
	@Column(name=COLUMN_ADMINISTRATIVE_UNIT) private String administrativeUnit;
	@Column(name=COLUMN_FUNCTION) private String function;
	
	/**/
	
	@Override
	public UserAccountRequestPerson setCode(String code) {
		return (UserAccountRequestPerson) super.setCode(code);
	}
	
	/**/
	
	public static final String FIELD_USER_ACCOUNTS_REQUEST = "userAccountRequest";
	public static final String FIELD_PERSON = "person";
	public static final String FIELD_ADMINISTRATIVE_UNIT = "administrativeUnit";
	public static final String FIELD_FUNCTION = "function";
	
	public static final String TABLE_NAME = UserAccountRequest.TABLE_NAME+ "_"+Person.TABLE_NAME;
	
	public static final String COLUMN_USER_ACCOUNTS_REQUEST = UserAccountRequest.TABLE_NAME;
	public static final String COLUMN_PERSON = Person.TABLE_NAME;
	public static final String COLUMN_STATUS = "statut";
	public static final String COLUMN_ACCOUNT_CREATION_DATE = UserAccountRequest.TABLE_NAME+"_date_creation";
	public static final String COLUMN_ADMINISTRATIVE_UNIT = "unite_administrative";
	public static final String COLUMN_FUNCTION = "fonction";
	
	public static final String UNIQUE_CONSTRAINT_USER_ACCOUNT_REQUEST_PERSON_NAME = COLUMN_USER_ACCOUNTS_REQUEST+ "_"+COLUMN_PERSON;
}
