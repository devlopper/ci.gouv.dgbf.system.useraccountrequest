package ci.gouv.dgbf.system.useraccountrequest.server.representation.impl.integration;

import org.cyk.utility.server.representation.AbstractEntityCollection;
import org.cyk.utility.server.representation.test.arquillian.AbstractRepresentationArquillianIntegrationTestWithDefaultDeploymentAsSwram;
import org.jboss.arquillian.junit.InSequence;
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
public class UserAccountRequestSequence01IntegrationTest extends AbstractRepresentationArquillianIntegrationTestWithDefaultDeploymentAsSwram {
	private static final long serialVersionUID = 1L;
	
	/* Setup */
	
	@Test @InSequence(1)
	public void setup() throws Exception{
		//__inject__(RoleRepresentation.class).createMany(new RoleDtoCollection().add("r01").add("r02").add("r03").add("r04").add("r05"));
		//assertionHelper.assertEqualsNumber(5, __inject__(RoleRepresentation.class).count().getEntity());
	}
	
	@Test @InSequence(2)
	public void createUserAccountRequest() throws Exception{
		UserAccountRequestDto userAccountRequestDto = new UserAccountRequestDto();
		userAccountRequestDto.setCode("uar001");
		userAccountRequestDto.addRoles("r02","r04");
		userAccountRequestDto.addServices("EL");
		userAccountRequestDto.addPerson("konan", "marc");
		__inject__(UserAccountRequestRepresentation.class).createOne(userAccountRequestDto);
		
		userAccountRequestDto = (UserAccountRequestDto) __inject__(UserAccountRequestRepresentation.class).getOne("uar001", "business").getEntity();
		
		assertionHelper.assertNotNull(userAccountRequestDto);
		assertionHelper.assertNotNull(userAccountRequestDto.getRoles());
		assertionHelper.assertEqualsNumber(2, userAccountRequestDto.getRoles().size());
		assertionHelper.assertNotNull(userAccountRequestDto.getServices());
		assertionHelper.assertEqualsNumber(1, userAccountRequestDto.getServices().size());
		assertionHelper.assertNotNull(userAccountRequestDto.getPersons());
		assertionHelper.assertEqualsNumber(1, userAccountRequestDto.getPersons().size());
		assertionHelper.assertEquals("konan", userAccountRequestDto.getPersons().iterator().next().getFirstName());
	}
	
	@Override
	protected <ENTITY> Class<? extends AbstractEntityCollection<ENTITY>> __getEntityCollectionClass__(Class<ENTITY> aClass) {
		return null;
	}
	

}
