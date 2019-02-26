package ci.gouv.dgbf.system.useraccountrequest.client.controller.entities;

import org.cyk.utility.client.controller.data.RowData;

public interface PersonReadRow extends RowData<Person> {

	@Override PersonReadRow setData(Person data);
	
}
