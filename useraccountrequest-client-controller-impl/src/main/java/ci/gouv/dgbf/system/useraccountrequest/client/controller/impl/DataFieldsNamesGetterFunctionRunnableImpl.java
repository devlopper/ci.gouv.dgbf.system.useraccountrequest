package ci.gouv.dgbf.system.useraccountrequest.client.controller.impl;

import java.io.Serializable;

import org.cyk.utility.__kernel__.function.AbstractFunctionRunnableImpl;
import org.cyk.utility.clazz.ClassHelper;
import org.cyk.utility.client.controller.data.DataFieldsNamesGetter;
import org.cyk.utility.client.controller.data.DataHelper;
import org.cyk.utility.field.FieldHelper;
import org.cyk.utility.string.Strings;
import org.cyk.utility.system.action.SystemAction;
import org.cyk.utility.system.action.SystemActionCreate;
import org.cyk.utility.system.action.SystemActionRead;

import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.Person;
import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.UserAccountRequest;

public class DataFieldsNamesGetterFunctionRunnableImpl extends AbstractFunctionRunnableImpl<DataFieldsNamesGetter> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public DataFieldsNamesGetterFunctionRunnableImpl() {
		setRunnable(new Runnable() {
			@Override
			public void run() {
				Strings names = null;
				SystemAction systemAction = getFunction().getSystemAction();
				if(systemAction!=null) {
					if(__inject__(ClassHelper.class).isInstanceOf(systemAction.getEntityClass(), UserAccountRequest.class)) {
						UserAccountRequest userAccountRequest = (UserAccountRequest) systemAction.getEntities().getFirst();
						names = __inject__(Strings.class);
						if(systemAction instanceof SystemActionRead) {
							names.add(UserAccountRequest.PROPERTY_CODE);
							if(userAccountRequest.getIdentifier()!=null) {
								names.add(UserAccountRequest.PROPERTY_CREATION_DATE);
							}
						}
						if(systemAction instanceof SystemActionCreate || (systemAction instanceof SystemActionRead && userAccountRequest.getIdentifier()!=null)) {
							names.add(__inject__(FieldHelper.class).concatenate(UserAccountRequest.PROPERTY_PERSON,Person.PROPERTY_FIRST_NAME));
							names.add(__inject__(FieldHelper.class).concatenate(UserAccountRequest.PROPERTY_PERSON,Person.PROPERTY_LAST_NAMES));
							
							names.add(__inject__(FieldHelper.class).concatenate(UserAccountRequest.PROPERTY_PERSON,Person.PROPERTY_SEX));
							names.add(__inject__(FieldHelper.class).concatenate(UserAccountRequest.PROPERTY_PERSON,Person.PROPERTY_ADMINISTRATIVE_UNIT));
							names.add(__inject__(FieldHelper.class).concatenate(UserAccountRequest.PROPERTY_PERSON,Person.PROPERTY_FUNCTION));
							names.add(__inject__(FieldHelper.class).concatenate(UserAccountRequest.PROPERTY_PERSON,Person.PROPERTY_ELECTRONIC_MAIL_ADDRESS));
							names.add(__inject__(FieldHelper.class).concatenate(UserAccountRequest.PROPERTY_PERSON,Person.PROPERTY_PHONE_NUMBER));
							
							names.add(UserAccountRequest.PROPERTY_SERVICES);
							names.add(UserAccountRequest.PROPERTY_ROLES);
							
							names.add(UserAccountRequest.PROPERTY_LETTER);	
						}
					}else {
						names = __inject__(DataHelper.class).getPropertiesFieldsNames(systemAction.getEntityClass());
					}
				}
				setOutput(names);
			}
		});
	}
	
}