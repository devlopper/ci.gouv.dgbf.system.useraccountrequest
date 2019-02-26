package ci.gouv.dgbf.system.useraccountrequest.client.controller.entities;
import java.io.Serializable;

import org.cyk.utility.client.controller.component.view.ViewBuilder;
import org.cyk.utility.client.controller.component.window.AbstractWindowContainerManagedWindowBuilderEditDataImpl;
import org.cyk.utility.client.controller.data.Data;
import org.cyk.utility.client.controller.data.Form;
import org.cyk.utility.system.action.SystemAction;

public class PersonEditWindowBuilderImpl extends AbstractWindowContainerManagedWindowBuilderEditDataImpl implements PersonEditWindowBuilder, Serializable {
	private static final long serialVersionUID = 1L;
		
	@Override
	protected void __execute__(Form form,SystemAction systemAction,Data data,ViewBuilder viewBuilder) {
		viewBuilder.addInputBuilderByObjectByFieldNames(data, systemAction, Person.PROPERTY_FIRST_NAME);
		viewBuilder.addInputBuilderByObjectByFieldNames(data, systemAction, Person.PROPERTY_LAST_NAMES);
		viewBuilder.addInputBuilderByObjectByFieldNames(data, systemAction, Person.PROPERTY_SEX);
		viewBuilder.addInputBuilderByObjectByFieldNames(data, systemAction, Person.PROPERTY_ELECTRONIC_MAIL_ADDRESS);
		viewBuilder.addInputBuilderByObjectByFieldNames(data, systemAction, Person.PROPERTY_PHONE_NUMBER);
		viewBuilder.addInputBuilderByObjectByFieldNames(data, systemAction, Person.PROPERTY_POSTAL_BOX_ADDRESS);
		//viewBuilder.addInputBuilderByObjectByFieldNames(data, systemAction, Person.PROPERTY_EMPLOYER);
		viewBuilder.addInputBuilderByObjectByFieldNames(data, systemAction, Person.PROPERTY_FUNCTION);
		//viewBuilder.addInputBuilderByObjectByFieldNames(data, systemAction, Person.PROPERTY_EMPLOYEE_IDENTIFIER);
	}

}
