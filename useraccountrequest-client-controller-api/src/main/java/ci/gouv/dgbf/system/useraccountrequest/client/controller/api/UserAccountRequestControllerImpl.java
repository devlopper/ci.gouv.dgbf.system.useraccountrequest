package ci.gouv.dgbf.system.useraccountrequest.client.controller.api;

import java.io.Serializable;

import javax.inject.Singleton;

import org.cyk.utility.client.controller.AbstractControllerEntityImpl;

import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.UserAccountRequest;

@Singleton
public class UserAccountRequestControllerImpl extends AbstractControllerEntityImpl<UserAccountRequest> implements UserAccountRequestController,Serializable {
	private static final long serialVersionUID = 1L;
	
}
