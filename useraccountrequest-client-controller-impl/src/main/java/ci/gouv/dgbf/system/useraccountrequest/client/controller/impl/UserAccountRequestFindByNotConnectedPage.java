package ci.gouv.dgbf.system.useraccountrequest.client.controller.impl;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.client.controller.component.window.WindowContainerManagedWindowBuilder;
import org.cyk.utility.client.controller.component.window.WindowContainerManagedWindowBuilderGetter;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.cyk.utility.system.action.SystemAction;
import org.cyk.utility.system.action.SystemActionRead;

import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.Person;
import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.UserAccountRequest;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountRequestFindByNotConnectedPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected WindowContainerManagedWindowBuilder __getWindowContainerManagedWindowBuilder__() {
		UserAccountRequest userAccountRequest = __inject__(UserAccountRequest.class);
		userAccountRequest.addPersons(__inject__(Person.class));
		SystemAction systemAction = __inject__(SystemActionRead.class);
		systemAction.setEntityClass(UserAccountRequest.class).getEntities(Boolean.TRUE).add(userAccountRequest);
		WindowContainerManagedWindowBuilder windowContainerManagedWindowBuilder = __inject__(WindowContainerManagedWindowBuilderGetter.class)
				.setSystemAction(systemAction).execute().getOutput();
		windowContainerManagedWindowBuilder.getWindow(Boolean.TRUE).setTitleValue("Consultation d'une demande de compte utilisateur");
		return windowContainerManagedWindowBuilder;
	}
	
}
