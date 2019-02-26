package ci.gouv.dgbf.system.useraccountrequest.client.controller.entities;

import org.cyk.utility.client.controller.data.Data;

public interface Service extends Data {

	@Override Service setIdentifier(Object identifier);
	@Override Service setCode(String code);
	
	String getName();
	Service setName(String name);
	
	String getDescription();
	Service setDescription(String description);
	
	/**/
	
	String PROPERTY_NAME = "name";
	String PROPERTY_DESCRIPTION = "description";
	
}
