package ci.gouv.dgbf.system.useraccountrequest.server.business.impl;

import java.io.Serializable;

import javax.inject.Singleton;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;
import org.cyk.utility.server.business.BusinessServiceProvider;

import ci.gouv.dgbf.system.useraccountrequest.server.business.api.UserAccountRequestRoleBusiness;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.api.UserAccountRequestRolePersistence;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequestRole;

@Singleton
public class UserAccountRequestRoleBusinessImpl extends AbstractBusinessEntityImpl<UserAccountRequestRole, UserAccountRequestRolePersistence> implements UserAccountRequestRoleBusiness,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected Class<UserAccountRequestRole> __getEntityClass__() {
		return UserAccountRequestRole.class;
	}

	@Override
	public BusinessServiceProvider<UserAccountRequestRole> create(UserAccountRequestRole userAccountRequestRole,Properties properties) {
		if(__injectStringHelper__().isBlank(userAccountRequestRole.getCode())) {
			userAccountRequestRole.setCode(userAccountRequestRole.getUserAccountRequest().getCode()+"_"+userAccountRequestRole.getRole());
		}
		return super.create(userAccountRequestRole, properties);
	}
}
