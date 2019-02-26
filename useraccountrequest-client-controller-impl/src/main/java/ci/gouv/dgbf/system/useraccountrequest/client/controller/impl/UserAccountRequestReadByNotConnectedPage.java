package ci.gouv.dgbf.system.useraccountrequest.client.controller.impl;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.client.controller.component.command.CommandableBuilder;
import org.cyk.utility.client.controller.component.window.WindowContainerManagedWindowBuilder;
import org.cyk.utility.client.controller.component.window.WindowContainerManagedWindowBuilderGetter;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.cyk.utility.request.RequestParameterValueMapper;
import org.cyk.utility.system.action.SystemAction;
import org.cyk.utility.system.action.SystemActionRead;

import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.UserAccountRequest;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountRequestReadByNotConnectedPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected WindowContainerManagedWindowBuilder __getWindowContainerManagedWindowBuilder__() {
		SystemAction systemAction = __inject__(SystemActionRead.class);
		systemAction.setEntityClass(UserAccountRequest.class);
		Long instanceIdentifier = __inject__(RequestParameterValueMapper.class).setParameterNameAsEntityIdentifier().execute().getOutputAs(Long.class);
		systemAction.getEntitiesIdentifiers(Boolean.TRUE).add(instanceIdentifier);
		WindowContainerManagedWindowBuilder windowContainerManagedWindowBuilder = __inject__(WindowContainerManagedWindowBuilderGetter.class)
				.setSystemAction(systemAction).execute().getOutput();
		windowContainerManagedWindowBuilder.getWindow(Boolean.TRUE).setTitleValue("Consultation d'une demande de compte utilisateur");
		CommandableBuilder commandableBuilder = __inject__(CommandableBuilder.class).setName("Imprimer");
		String identifier = "form:"+(String) windowContainerManagedWindowBuilder.getView(Boolean.TRUE).getComponentsBuilder(Boolean.TRUE).getLayout(Boolean.TRUE).getOutputProperties().getIdentifier();
		commandableBuilder.getOutputProperties().setOnClick("printElementInnerHtmlByIdentifier('"+identifier+"');");
		commandableBuilder.getOutputProperties().setType("button");
		commandableBuilder.setNavigation(null);
		commandableBuilder.setCommand(null);
		windowContainerManagedWindowBuilder.getView(Boolean.TRUE).getCommandables(Boolean.TRUE).add(commandableBuilder);
		return windowContainerManagedWindowBuilder;
	}
}
