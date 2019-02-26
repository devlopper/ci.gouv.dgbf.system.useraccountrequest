package ci.gouv.dgbf.system.useraccountrequest.client.controller.entities;

import java.io.Serializable;
import java.util.Collection;

import org.cyk.utility.client.controller.component.grid.GridBuilder;
import org.cyk.utility.client.controller.component.grid.column.ColumnBuilder;
import org.cyk.utility.client.controller.component.view.ViewBuilder;
import org.cyk.utility.client.controller.component.window.AbstractWindowContainerManagedWindowBuilderProcessDataImpl;
import org.cyk.utility.client.controller.data.Data;
import org.cyk.utility.client.controller.data.Form;
import org.cyk.utility.system.action.SystemAction;

import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.Person;
import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.PersonReadRow;

public class UserAccountRequestProcessWindowBuilderImpl extends AbstractWindowContainerManagedWindowBuilderProcessDataImpl implements UserAccountRequestProcessWindowBuilder, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void __execute__(Form form, Data data,SystemAction systemAction, ViewBuilder viewBuilder) {
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccountRequest.PROPERTY_SERVICES);
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccountRequest.PROPERTY_ROLES);
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccountRequest.PROPERTY_LETTER);
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		GridBuilder gridBuilder = __inject__(GridBuilder.class).setRowClass(PersonReadRow.class).setRowDataClass(Person.class)
				.addColumns(__inject__(ColumnBuilder.class).addFieldNameStrings("data",Person.PROPERTY_FIRST_NAME)
						,__inject__(ColumnBuilder.class).addFieldNameStrings("data",Person.PROPERTY_LAST_NAMES)
						)	
				.addObjects( (Collection)((UserAccountRequest)data).getPersons().get() )
				;
		
		viewBuilder.addComponentBuilder(gridBuilder);
		/*
		if("createuseraccount".equals(systemAction.getIdentifier())) {
			if(((UserAccountRequest)data).getCredentials() == null)
				((UserAccountRequest)data).setCredentials(__inject__(Credentials.class));
			viewBuilder.addComponentBuilderByObjectByFieldNames(data, UserAccountRequest.PROPERTY_CREDENTIALS,Credentials.PROPERTY_USERNAME);
			viewBuilder.addComponentBuilderByObjectByFieldNames(data, UserAccountRequest.PROPERTY_CREDENTIALS,Credentials.PROPERTY_PASSWORD);
		}else if("process".equals(systemAction.getIdentifier())) {
			InputChoiceBuilder<?, ?> inputChoiceBuilder = (InputChoiceBuilder<?, ?>) viewBuilder.addComponentBuilderByObjectByFieldNames(data, UserAccountRequest.PROPERTY_ACCEPTED);
			inputChoiceBuilder.addChoices("Oui","Non");
		}
		*/
	}
	
}
