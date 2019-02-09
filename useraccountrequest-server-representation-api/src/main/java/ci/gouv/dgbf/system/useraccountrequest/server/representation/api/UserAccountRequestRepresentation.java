package ci.gouv.dgbf.system.useraccountrequest.server.representation.api;

import javax.ws.rs.Path;

import org.cyk.utility.server.representation.RepresentationEntity;

import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequest;
import ci.gouv.dgbf.system.useraccountrequest.server.representation.entities.UserAccountRequestDto;
import ci.gouv.dgbf.system.useraccountrequest.server.representation.entities.UserAccountRequestDtoCollection;

@Path(UserAccountRequestRepresentation.PATH)
public interface UserAccountRequestRepresentation extends RepresentationEntity<UserAccountRequest,UserAccountRequestDto,UserAccountRequestDtoCollection> {
	
	String PATH = "/user/account/request";
	
}
