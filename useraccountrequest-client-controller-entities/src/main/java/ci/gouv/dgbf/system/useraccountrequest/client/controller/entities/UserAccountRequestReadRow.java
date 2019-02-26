package ci.gouv.dgbf.system.useraccountrequest.client.controller.entities;

import org.cyk.utility.client.controller.data.RowData;

public interface UserAccountRequestReadRow extends RowData<UserAccountRequest> {

	@Override UserAccountRequestReadRow setData(UserAccountRequest data);
	
}
