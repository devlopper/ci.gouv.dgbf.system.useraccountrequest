package ci.gouv.dgbf.system.useraccountrequest.client.controller.entities;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.AbstractFormDataImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class PersonEditFormImpl extends AbstractFormDataImpl<Person> implements PersonEditForm,Serializable {
	private static final long serialVersionUID = 1L;
	
}
