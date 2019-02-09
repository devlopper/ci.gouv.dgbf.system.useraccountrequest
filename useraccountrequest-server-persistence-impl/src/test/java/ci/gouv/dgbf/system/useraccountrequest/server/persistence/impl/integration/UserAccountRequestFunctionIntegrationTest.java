package ci.gouv.dgbf.system.useraccountrequest.server.persistence.impl.integration;

import org.cyk.utility.server.persistence.test.TestPersistenceCreate;
import org.cyk.utility.server.persistence.test.arquillian.AbstractPersistenceArquillianIntegrationTestWithDefaultDeploymentAsSwram;
import org.junit.Test;

import ci.gouv.dgbf.system.useraccountrequest.server.persistence.entities.UserAccountRequest;

public class UserAccountRequestFunctionIntegrationTest extends AbstractPersistenceArquillianIntegrationTestWithDefaultDeploymentAsSwram {
	private static final long serialVersionUID = 1L;
	
	/* Create */
	
	@Test
	public void createOneUserAccountRequest() throws Exception{
		__inject__(TestPersistenceCreate.class).addObjects(new UserAccountRequest().setCode("c01")).execute();
	}
	
}
