package ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities;

import java.io.Serializable;

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
		name=UserAccountRequestService.TABLE_NAME,
		uniqueConstraints= {
		@UniqueConstraint(name=UserAccountRequestService.UNIQUE_CONSTRAINT_USER_ACCOUNT_REQUEST_PERSON_NAME,columnNames= {UserAccountRequestService.COLUMN_USER_ACCOUNT_REQUEST,UserAccountRequestService.COLUMN_SERVICE})
})
@Access(AccessType.FIELD)
public class UserAccountRequestService extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@JoinColumn(name=COLUMN_USER_ACCOUNT_REQUEST) @ManyToOne @NotNull private UserAccountRequest userAccountRequest;
	@Column(name=COLUMN_SERVICE) @NotNull private String service;
	
	/**/
	
	@Override
	public UserAccountRequestService setCode(String code) {
		return (UserAccountRequestService) super.setCode(code);
	}
	
	/**/
	
	public static final String FIELD_USER_ACCOUNT_REQUEST = "userAccountRequest";
	public static final String FIELD_SERVICE = "service";
	
	public static final String TABLE_NAME = UserAccountRequest.TABLE_NAME+"_svce";
	
	public static final String COLUMN_USER_ACCOUNT_REQUEST = UserAccountRequest.TABLE_NAME;
	public static final String COLUMN_SERVICE = "svce";
	
	public static final String UNIQUE_CONSTRAINT_USER_ACCOUNT_REQUEST_PERSON_NAME = COLUMN_USER_ACCOUNT_REQUEST+ "_"+COLUMN_SERVICE;
}
