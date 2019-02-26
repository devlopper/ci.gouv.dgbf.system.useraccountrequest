package ci.gouv.dgbf.system.useraccountrequest.server.representation.impl.integration;

import org.cyk.utility.server.representation.AbstractEntityCollection;
import org.cyk.utility.server.representation.test.arquillian.AbstractRepresentationArquillianIntegrationTestWithDefaultDeploymentAsSwram;
import org.junit.Test;

import ci.gouv.dgbf.system.useraccountrequest.server.representation.api.UserAccountRequestRepresentation;
import ci.gouv.dgbf.system.useraccountrequest.server.representation.entities.UserAccountRequestDto;

/**
 * Not connected user 
 * 1 - create user account request
 * 2 - consult user account request
 * 3 - print user account request
 * 
 * @author CYK
 *
 */
public class UserAccountRequestFunctionIntegrationTest extends AbstractRepresentationArquillianIntegrationTestWithDefaultDeploymentAsSwram {
	private static final long serialVersionUID = 1L;
	
	@Test
	public void createUserAccountRequest() throws Exception{
		UserAccountRequestDto userAccountRequestDto = new UserAccountRequestDto();
		userAccountRequestDto.setCode("uar001");
		userAccountRequestDto.addRoles("r02","r04");
		userAccountRequestDto.addServices("EL");
		userAccountRequestDto.addPerson("konan", "marc","kycdev@gmail.com");
		userAccountRequestDto.setIsNotify(Boolean.FALSE);
		__inject__(UserAccountRequestRepresentation.class).createOne(userAccountRequestDto);
		
		userAccountRequestDto = (UserAccountRequestDto) __inject__(UserAccountRequestRepresentation.class).getOne("uar001", "business").getEntity();
		
		assertionHelper.assertNotNull(userAccountRequestDto);
		assertionHelper.assertNotNull(userAccountRequestDto.getRoles());
		assertionHelper.assertEqualsNumber(2, userAccountRequestDto.getRoles().getSize());
		assertionHelper.assertNotNull(userAccountRequestDto.getServices());
		assertionHelper.assertEqualsNumber(1, userAccountRequestDto.getServices().getSize());
		assertionHelper.assertNotNull(userAccountRequestDto.getPersons());
		assertionHelper.assertEqualsNumber(1, userAccountRequestDto.getPersons().size());
		assertionHelper.assertEquals("konan", userAccountRequestDto.getPersons().iterator().next().getFirstName());
	}
	
	@Override
	protected <ENTITY> Class<? extends AbstractEntityCollection<ENTITY>> __getEntityCollectionClass__(Class<ENTITY> aClass) {
		return null;
	}
	

}
