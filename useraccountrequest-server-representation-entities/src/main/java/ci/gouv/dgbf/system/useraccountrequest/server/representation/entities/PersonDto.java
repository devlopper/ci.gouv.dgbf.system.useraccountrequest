package ci.gouv.dgbf.system.useraccountrequest.server.representation.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.cyk.utility.server.representation.AbstractEntityFromPersistenceEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@XmlRootElement @Getter @Setter @Accessors(chain=true) @NoArgsConstructor @ToString
public class PersonDto extends AbstractEntityFromPersistenceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastNames;
	private Boolean isMasculine;
	
	//Contacts
	private String electronicMailAddress;
	private String phoneNumber;
	
	private String administrativeUnit;
	private String function;
}
