package ci.gouv.dgbf.system.useraccountrequest.server.business.impl;

import java.io.Serializable;

import javax.inject.Singleton;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;
import org.cyk.utility.server.business.BusinessServiceProvider;

import ci.gouv.dgbf.system.useraccountrequest.server.business.api.UserAccountRequestServiceBusiness;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.api.UserAccountRequestServicePersistence;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequestService;

@Singleton
public class UserAccountRequestServiceBusinessImpl extends AbstractBusinessEntityImpl<UserAccountRequestService, UserAccountRequestServicePersistence> implements UserAccountRequestServiceBusiness,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected Class<UserAccountRequestService> __getPersistenceEntityClass__() {
		return UserAccountRequestService.class;
	}
	
	@Override
	public BusinessServiceProvider<UserAccountRequestService> create(UserAccountRequestService userAccountRequestService,Properties properties) {
		if(__injectStringHelper__().isBlank(userAccountRequestService.getCode()))
			userAccountRequestService.setCode(userAccountRequestService.getUserAccountRequest().getCode()+"_"+userAccountRequestService.getService());
		return super.create(userAccountRequestService, properties);
	}
	
}
