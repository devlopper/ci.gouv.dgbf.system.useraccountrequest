package ci.gouv.dgbf.system.useraccountrequest.server.representation.impl;

import java.io.Serializable;

import javax.inject.Singleton;

import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

import ci.gouv.dgbf.system.useraccountrequest.server.business.api.UserAccountRequestBusiness;
import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequest;
import ci.gouv.dgbf.system.useraccountrequest.server.representation.api.UserAccountRequestRepresentation;
import ci.gouv.dgbf.system.useraccountrequest.server.representation.entities.UserAccountRequestDto;
import ci.gouv.dgbf.system.useraccountrequest.server.representation.entities.UserAccountRequestDtoCollection;

@Singleton
public class UserAccountRequestRepresentationImpl extends AbstractRepresentationEntityImpl<UserAccountRequest,UserAccountRequestBusiness,UserAccountRequestDto,UserAccountRequestDtoCollection> implements UserAccountRequestRepresentation,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public Class<UserAccountRequest> getPersistenceEntityClass() {
		return UserAccountRequest.class;
	}
	
}
