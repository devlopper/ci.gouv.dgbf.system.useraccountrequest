package ci.gouv.dgbf.system.useraccountrequest.client.controller.impl;

import java.io.Serializable;

import org.cyk.utility.__kernel__.function.AbstractFunctionRunnableImpl;
import org.cyk.utility.clazz.ClassHelper;
import org.cyk.utility.client.controller.data.DataGetter;
import org.cyk.utility.collection.CollectionHelper;
import org.cyk.utility.system.action.SystemAction;

import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.Person;
import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.UserAccountRequest;

public class DataGetterFunctionRunnableImpl extends AbstractFunctionRunnableImpl<DataGetter> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public DataGetterFunctionRunnableImpl() {
		setRunnable(new Runnable() {
			@Override
			public void run() {
				Object data = null;
				SystemAction systemAction = getFunction().getSystemAction();
				if(systemAction!=null && __inject__(CollectionHelper.class).isNotEmpty(systemAction.getEntities())) {
					if(__inject__(ClassHelper.class).isInstanceOf(systemAction.getEntityClass(), UserAccountRequest.class)) {
						UserAccountRequest userAccountRequest = (UserAccountRequest) systemAction.getEntities().getFirst();
						if(userAccountRequest.getPerson() == null) {
							if(__inject__(CollectionHelper.class).isEmpty(userAccountRequest.getPersons())) {
								userAccountRequest.getPersons(Boolean.TRUE).add(__inject__(Person.class));
							}
							userAccountRequest.setPerson(userAccountRequest.getPersons().getFirst());
						}
						data = userAccountRequest;
					}else {
						data = systemAction.getEntities().getFirst();
					}	
				}
				setOutput(data);
			}
		});
	}
	
}