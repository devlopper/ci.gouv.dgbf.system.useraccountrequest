package ci.gouv.dgbf.system.useraccountrequest.client.controller.impl;

import java.io.Serializable;

import org.cyk.utility.__kernel__.function.AbstractFunctionRunnableImpl;
import org.cyk.utility.clazz.ClassHelper;
import org.cyk.utility.client.controller.data.DataHelper;
import org.cyk.utility.client.controller.data.FieldsNamesGetter;
import org.cyk.utility.string.Strings;
import org.cyk.utility.system.action.SystemAction;
import org.cyk.utility.system.action.SystemActionRead;

import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.UserAccountRequest;

public class FieldsNamesGetterFunctionRunnableImpl extends AbstractFunctionRunnableImpl<FieldsNamesGetter> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public FieldsNamesGetterFunctionRunnableImpl() {
		setRunnable(new Runnable() {
			@Override
			public void run() {
				Strings names = null;
				SystemAction systemAction = getFunction().getSystemAction();
				if(systemAction instanceof SystemActionRead && __inject__(ClassHelper.class).isInstanceOf(systemAction.getEntityClass(), UserAccountRequest.class)) {
					names = __inject__(Strings.class);

					names.add(UserAccountRequest.PROPERTY_CODE);
					names.add(UserAccountRequest.PROPERTY_CREATION_DATE);
					
					/*
					names.add(UserAccountRequest.PROPERTY_PERSON,Person.PROPERTY_FIRST_NAME);
					names.add(UserAccountRequest.PROPERTY_PERSON,Person.PROPERTY_LAST_NAMES);
					
					names.add(UserAccountRequest.PROPERTY_PERSON,Person.PROPERTY_SEX);
					names.add(UserAccountRequest.PROPERTY_PERSON,Person.PROPERTY_ADMINISTRATIVE_UNIT);
					names.add(UserAccountRequest.PROPERTY_PERSON,Person.PROPERTY_FUNCTION);
					names.add(UserAccountRequest.PROPERTY_PERSON,Person.PROPERTY_ELECTRONIC_MAIL_ADDRESS);
					names.add(UserAccountRequest.PROPERTY_PERSON,Person.PROPERTY_PHONE_NUMBER);
					*/
					names.add(UserAccountRequest.PROPERTY_SERVICES);
					names.add(UserAccountRequest.PROPERTY_ROLES);
					
					names.add(UserAccountRequest.PROPERTY_LETTER);
				}else if(systemAction!=null) {
					names = __inject__(DataHelper.class).getPropertiesFieldsNames(systemAction.getEntityClass());
				}
				setOutput(names);
			}
		});
	}
	
}