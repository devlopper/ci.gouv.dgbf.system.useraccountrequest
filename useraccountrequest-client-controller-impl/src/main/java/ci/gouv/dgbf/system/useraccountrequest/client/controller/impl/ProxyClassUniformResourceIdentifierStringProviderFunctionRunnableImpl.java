package ci.gouv.dgbf.system.useraccountrequest.client.controller.impl;

import java.io.Serializable;

import org.cyk.utility.__kernel__.function.AbstractFunctionRunnableImpl;
import org.cyk.utility.client.controller.proxy.ProxyClassUniformResourceIdentifierStringProvider;

import ci.gouv.dgbf.system.usermanagement.server.representation.api.account.RoleRepresentation;

@Deprecated
public class ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl extends AbstractFunctionRunnableImpl<ProxyClassUniformResourceIdentifierStringProvider> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl() {
		setRunnable(new Runnable() {
			@Override
			public void run() {
				if(RoleRepresentation.class.equals(getFunction().getClazz())) {
					setOutput("http://localhost:8080/usermanagement/server");
					//setOutput("http://192.168.99.100:8080");
				}
				//setOutput("http://mic-demande-compte-server:8080/");
				//setOutput("http://localhost:8080/actor/server");
				//System.out.println("Pro Var : "+System.getProperties());
				
				//setOutput("http://localhost:8081");
				
				//setOutput("http://mic-utilisateur-demande-server:8081/");
			}
		});
	}
	
}