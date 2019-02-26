package ci.gouv.dgbf.system.useraccountrequest.client.controller.entities;
import java.io.Serializable;

import org.cyk.utility.client.controller.component.grid.GridBuilder;
import org.cyk.utility.client.controller.component.window.AbstractWindowContainerManagedWindowBuilderListDataImpl;
import org.cyk.utility.client.controller.data.RowData;

import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.Person;

public class UserAccountRequestListWindowBuilderImpl extends AbstractWindowContainerManagedWindowBuilderListDataImpl implements UserAccountRequestListWindowBuilder, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		setRowClass(UserAccountRequestReadRow.class);
		addGridColumnsFieldNamesWithPrefix(RowData.PROPERTY_DATA, UserAccountRequest.PROPERTY_CODE,UserAccountRequest.PROPERTY_CREATION_DATE
				,__injectFieldHelper__().concatenate(UserAccountRequest.PROPERTY_PERSON,Person.PROPERTY_FIRST_NAME_AND_LAST_NAMES));
	}
	
	@Override
	protected void __execute__(GridBuilder gridBuilder) {
		
	}
	
}
