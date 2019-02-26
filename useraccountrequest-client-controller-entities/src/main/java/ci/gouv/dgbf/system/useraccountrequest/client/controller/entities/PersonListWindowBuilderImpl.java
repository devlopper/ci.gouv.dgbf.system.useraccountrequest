package ci.gouv.dgbf.system.useraccountrequest.client.controller.entities;
import java.io.Serializable;

import org.cyk.utility.client.controller.component.grid.GridBuilder;
import org.cyk.utility.client.controller.component.window.AbstractWindowContainerManagedWindowBuilderListDataImpl;
import org.cyk.utility.client.controller.data.RowData;

public class PersonListWindowBuilderImpl extends AbstractWindowContainerManagedWindowBuilderListDataImpl implements PersonListWindowBuilder, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		setRowClass(PersonReadRow.class);
		addGridColumnsFieldNamesWithPrefix(RowData.PROPERTY_DATA, Person.PROPERTY_CODE,Person.PROPERTY_FIRST_NAME
				,Person.PROPERTY_LAST_NAMES,Person.PROPERTY_EMPLOYER);
	}
	
	@Override
	protected void __execute__(GridBuilder gridBuilder) {
		
	}
	
}
