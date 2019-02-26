package ci.gouv.dgbf.system.useraccountrequest.client.controller.impl;

import java.io.Serializable;

import javax.faces.context.FacesContext;

import org.cyk.utility.__kernel__.function.AbstractFunctionRunnableImpl;
import org.cyk.utility.client.controller.component.ComponentRole;
import org.cyk.utility.client.controller.component.menu.MenuBuilder;
import org.cyk.utility.client.controller.component.menu.MenuBuilderMap;
import org.cyk.utility.client.controller.component.menu.MenuBuilderMapGetter;
import org.cyk.utility.client.controller.component.menu.MenuItemBuilder;
import org.cyk.utility.client.controller.component.menu.MenuRenderTypeRowBar;
import org.cyk.utility.client.controller.icon.Icon;
import org.cyk.utility.scope.ScopeSession;

public class MenuBuilderMapGetterFunctionRunnableImpl extends AbstractFunctionRunnableImpl<MenuBuilderMapGetter> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public MenuBuilderMapGetterFunctionRunnableImpl() {
		setRunnable(new Runnable() {
			@Override
			public void run() {
				Object principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
				MenuBuilder menuBuilder = __inject__(MenuBuilder.class).setRenderType(__inject__(MenuRenderTypeRowBar.class));
				if(principal == null) {
					menuBuilder.addItems(
						__inject__(MenuItemBuilder.class).setCommandableName("Demande de compte utilisateur").setCommandableIcon(Icon.USER).addChild(
								__inject__(MenuItemBuilder.class).setCommandableName("Demander un compte utilisateur").addCommandableRoles(ComponentRole.CREATOR).setCommandableNavigationIdentifier("userAccountRequestCreateByNotConnectedUserView")
								,__inject__(MenuItemBuilder.class).setCommandableName("Consulter ma demande de compte utilisateur").addCommandableRoles(ComponentRole.READER).setCommandableNavigationIdentifier("userAccountRequestFindByNotConnectedUserView")
						)									
					);	
				}else {
					
				}
				setOutput(__inject__(MenuBuilderMap.class).set(ScopeSession.class,menuBuilder));
			}
		});
	}
	
}