package ci.gouv.dgbf.system.useraccountrequest.client.controller.impl;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.client.controller.component.layout.Proportions;
import org.cyk.utility.client.controller.component.window.WindowContainerManagedWindowBuilder;
import org.cyk.utility.client.controller.component.window.WindowContainerManagedWindowBuilderGetter;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.cyk.utility.system.action.SystemAction;
import org.cyk.utility.system.action.SystemActionCreate;

import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.Person;
import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.UserAccountRequest;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountRequestCreateByNotConnectedPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected WindowContainerManagedWindowBuilder __getWindowContainerManagedWindowBuilder__() {
		UserAccountRequest userAccountRequest = __inject__(UserAccountRequest.class);
		userAccountRequest.addPersons(__inject__(Person.class));
		SystemAction systemAction = __inject__(SystemActionCreate.class);
		systemAction.setEntityClass(UserAccountRequest.class).getEntities(Boolean.TRUE).add(userAccountRequest);
		WindowContainerManagedWindowBuilder windowContainerManagedWindowBuilder = __inject__(WindowContainerManagedWindowBuilderGetter.class)
				.setSystemAction(systemAction).execute().getOutput();
		windowContainerManagedWindowBuilder.getWindow(Boolean.TRUE).setTitleValue("Demande de compte utilisateur");
		Proportions proportions = windowContainerManagedWindowBuilder.getView(Boolean.TRUE).getComponentsBuilder(Boolean.TRUE).getLayout(Boolean.TRUE)
				.getGridRowModel(Boolean.TRUE).getWidthProportions(Boolean.TRUE);
		proportions.set(0,3,1,6,2,3);
		return windowContainerManagedWindowBuilder;
	}
	/*
	@Override
	protected WindowBuilder __getWindowBuilder__() {
		WindowBuilder window =  super.__getWindowBuilder__();
		CommandableBuilder commandableBuilder = window.getDialog(Boolean.TRUE).getOkCommandable(Boolean.TRUE);
		String url = __inject__(NavigationIdentifierToUrlStringMapper.class).setIdentifier("userAccountRequestFindByNotConnectedUserView").execute().getOutput();
		String script = "PF('"+window.getDialog(Boolean.TRUE).getOutputProperties().getWidgetVar()+"').hide(); if(#{userAccountRequestCreateByNotConnectedPage.isMessageMaximumSeverityInfo()}) window.location.href='"+url+"'";
		EventBuilder event = __inject__(EventBuilder.class).setName(EventName.CLICK).addScriptInstructions(script);
		commandableBuilder.addEvents(event);
		return window;
	}
	
	public Boolean isMessageMaximumSeverityInfo() {
		return FacesMessage.SEVERITY_INFO.equals(FacesContext.getCurrentInstance().getMaximumSeverity());
	}
	*/
}
