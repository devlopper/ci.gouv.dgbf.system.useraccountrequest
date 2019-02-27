package ci.gouv.dgbf.system.useraccountrequest.client.controller.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.AbstractApplicationScopeLifeCycleListener;
import org.cyk.utility.__kernel__.function.FunctionRunnableMap;
import org.cyk.utility.client.controller.component.menu.MenuBuilderMapGetterImpl;
import org.cyk.utility.client.controller.component.theme.ThemeClassGetterImpl;
import org.cyk.utility.client.controller.data.DataFieldsNamesGetterImpl;
import org.cyk.utility.client.controller.data.DataGetterImpl;
import org.cyk.utility.system.node.SystemNodeClient;

@ApplicationScoped
public class ApplicationScopeLifeCycleListener extends AbstractApplicationScopeLifeCycleListener implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void __initialize__(Object object) {
		__inject__(FunctionRunnableMap.class).set(MenuBuilderMapGetterImpl.class, MenuBuilderMapGetterFunctionRunnableImpl.class,LEVEL);
		__inject__(FunctionRunnableMap.class).set(DataFieldsNamesGetterImpl.class, DataFieldsNamesGetterFunctionRunnableImpl.class,LEVEL);
		__inject__(FunctionRunnableMap.class).set(DataGetterImpl.class, DataGetterFunctionRunnableImpl.class,LEVEL);
		__inject__(FunctionRunnableMap.class).set(ThemeClassGetterImpl.class, ThemeClassGetterFunctionRunnableImpl.class,LEVEL);
		//__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,2);
		
		__inject__(SystemNodeClient.class).setName("SIIB");
	}
	
	@Override
	public void __destroy__(Object object) {}
	
	/**/
	
	public static final Integer LEVEL = new Integer(org.cyk.utility.client.controller.web.jsf.primefaces.ApplicationScopeLifeCycleListener.LEVEL+1);
}
