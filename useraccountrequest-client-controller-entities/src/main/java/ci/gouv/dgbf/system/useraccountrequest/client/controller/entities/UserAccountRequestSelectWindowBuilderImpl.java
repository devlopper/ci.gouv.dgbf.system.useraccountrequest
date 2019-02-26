package ci.gouv.dgbf.system.useraccountrequest.client.controller.entities;

import java.io.Serializable;

import org.cyk.utility.client.controller.component.grid.GridBuilder;
import org.cyk.utility.client.controller.component.window.AbstractWindowContainerManagedWindowBuilderSelectDataImpl;
import org.cyk.utility.client.controller.data.RowData;

public class UserAccountRequestSelectWindowBuilderImpl extends AbstractWindowContainerManagedWindowBuilderSelectDataImpl implements UserAccountRequestSelectWindowBuilder, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		addGridColumnsFieldNamesWithPrefix(RowData.PROPERTY_DATA, UserAccountRequest.PROPERTY_CODE
				,UserAccountRequest.PROPERTY_CREATION_DATE,UserAccountRequest.PROPERTY_NUMBER_OF_PERSON);
	}
	
	@Override
	protected void __execute__(GridBuilder gridBuilder) {
		
	}
	
}
