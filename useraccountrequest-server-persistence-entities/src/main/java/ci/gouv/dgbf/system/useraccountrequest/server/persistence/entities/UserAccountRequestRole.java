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
		name=UserAccountRequestRole.TABLE_NAME,
		uniqueConstraints= {
		@UniqueConstraint(name=UserAccountRequestRole.UNIQUE_CONSTRAINT_USER_ACCOUNT_REQUEST_ROLE_NAME,columnNames= {UserAccountRequestRole.COLUMN_USER_ACCOUNTS_REQUEST,UserAccountRequestRole.COLUMN_ROLE})
})
@Access(AccessType.FIELD)
public class UserAccountRequestRole extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@JoinColumn(name=COLUMN_USER_ACCOUNTS_REQUEST) @ManyToOne @NotNull private UserAccountRequest userAccountRequest;
	@Column(name=COLUMN_ROLE) @NotNull private String role;
	
	/**/
	
	@Override
	public UserAccountRequestRole setCode(String code) {
		return (UserAccountRequestRole) super.setCode(code);
	}
	
	/**/
	
	public static final String FIELD_USER_ACCOUNT_REQUEST = "userAccountRequest";
	public static final String FIELD_ROLE = "role";
	
	public static final String TABLE_NAME = UserAccountRequest.TABLE_NAME+"_role";
	
	public static final String COLUMN_USER_ACCOUNTS_REQUEST = UserAccountRequest.TABLE_NAME;
	public static final String COLUMN_ROLE = "role";
	
	public static final String UNIQUE_CONSTRAINT_USER_ACCOUNT_REQUEST_ROLE_NAME = COLUMN_USER_ACCOUNTS_REQUEST+ "_"+COLUMN_ROLE;
}
