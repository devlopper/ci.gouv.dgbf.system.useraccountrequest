package ci.gouv.dgbf.system.useraccountrequest.client.controller.api;

import java.io.Serializable;

import org.cyk.utility.__kernel__.function.AbstractFunctionRunnableImpl;
import org.cyk.utility.__kernel__.function.FunctionRunnableMap;
import org.cyk.utility.client.controller.proxy.ProxyClassUniformResourceIdentifierStringProvider;
import org.cyk.utility.client.controller.proxy.ProxyClassUniformResourceIdentifierStringProviderImpl;
import org.cyk.utility.client.controller.test.TestControllerCreate;
import org.cyk.utility.client.controller.test.arquillian.AbstractControllerArquillianIntegrationTestWithDefaultDeploymentAsSwram;
import org.junit.Test;

import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.Person;
import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.Service;
import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.UserAccountRequest;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Role;

public class UserAccountRequestControllerFunctionIntegrationTest extends AbstractControllerArquillianIntegrationTestWithDefaultDeploymentAsSwram {
	private static final long serialVersionUID = 1L;
	
	/* Create */
	
	@Test
	public void createOneRole() throws Exception{
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,100);
		
		//String userAccountRequestCode = __getRandomCode__();
		UserAccountRequest userAccountRequest = __inject__(UserAccountRequest.class);
		userAccountRequest.setCode("mycode001");
		userAccountRequest.addRoles(__inject__(Role.class).setCode("R01"));
		userAccountRequest.addServices(__inject__(Service.class).setCode("S01"));
		userAccountRequest.getPersons(Boolean.TRUE).add(__inject__(Person.class).setFirstName("zadi").setLastNames("gérard").setElectronicMailAddress("kycdev@gmail.com"));
		__inject__(TestControllerCreate.class).setIsCatchThrowable(Boolean.FALSE).addObjects(userAccountRequest).execute();
	}
	
	/**/
	
	public static class ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl extends AbstractFunctionRunnableImpl<ProxyClassUniformResourceIdentifierStringProvider> implements Serializable {
		private static final long serialVersionUID = 1L;
		
		public ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl() {
			setRunnable(new Runnable() {
				@Override
				public void run() {
					setOutput("http://localhost:8080/useraccountrequest/server/");
				}
			});
		}
		
	}
	
}
