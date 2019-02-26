package ci.gouv.dgbf.system.useraccountrequest.client.controller.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.cyk.utility.client.controller.AbstractInstanceBuilderFunctionRunnableImpl;
import org.cyk.utility.collection.CollectionHelper;
import org.cyk.utility.instance.InstanceHelper;
import org.cyk.utility.random.RandomHelper;

import ci.gouv.dgbf.system.useraccountrequest.server.representation.entities.PersonDto;
import ci.gouv.dgbf.system.useraccountrequest.server.representation.entities.UserAccountRequestDto;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.RoleController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Role;

public class InstanceBuilderFunctionRunnableImpl extends AbstractInstanceBuilderFunctionRunnableImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void __copy__(Object source, Object destination) {
		if(source instanceof UserAccountRequestDto && destination instanceof UserAccountRequest) {
			UserAccountRequestDto representation = (UserAccountRequestDto) source;
			UserAccountRequest data = (UserAccountRequest) destination;
			data.setIdentifier(representation.getIdentifier());
			data.setCode(representation.getCode());
			data.setLetter(representation.getLetter());
			data.setCreationDate(representation.getCreationDate());
			
			if(representation.getRoles()!=null && __inject__(CollectionHelper.class).isNotEmpty(representation.getRoles().getCollection())) {
				data.setRoles(new ArrayList<>());
				for(String index : representation.getRoles().getCollection()) {
					Role role = __inject__(RoleController.class).readOneByBusinessIdentifier(index);
					data.getRoles().add(role);
				}
			}
			
			if(__inject__(CollectionHelper.class).isNotEmpty(representation.getPersons())) {
				data.setPersons(__inject__(Persons.class));
				for(PersonDto index : representation.getPersons()) 
					data.getPersons(Boolean.TRUE).add(__inject__(InstanceHelper.class).buildOne(PersonImpl.class, index).setSex(index.getIsMasculine() ? Sex.MASCULIN : Sex.FEMININ));
			}
			
			if(representation.getServices()!=null && __inject__(CollectionHelper.class).isNotEmpty(representation.getServices().getCollection())) {
				data.setServices(new ArrayList<>());
				for(String index : representation.getServices().getCollection()) {
					Service service = __inject__(Service.class).setCode(index);
					//TODO find other related infos with the Service API
					service.setIdentifier(__inject__(RandomHelper.class).getNumeric(3));
					if("ELB".equals(service.getCode())) {
						service.setName("Élaboration du budget");
					}else if("EXB".equals(service.getCode())) {
						service.setName("Exécution du budget");
					}
					data.getServices().add(service);
				}
			}
			
		}else if(source instanceof UserAccountRequest && destination instanceof UserAccountRequestDto) {
			UserAccountRequest data = (UserAccountRequest) source;
			UserAccountRequestDto representation = (UserAccountRequestDto) destination;
			representation.setCode(data.getCode());
			representation.setLetter(data.getLetter());
			
			Collection<Role> roles = data.getRoles();
			if(__inject__(CollectionHelper.class).isNotEmpty(roles)) {
				representation.setRoles(null);
				for(Role index : roles) 
					representation.addRoles(index.getCode());
			}
			
			Persons persons = data.getPersons();
			if(__inject__(CollectionHelper.class).isNotEmpty(persons)) {
				representation.setPersons(new ArrayList<>());
				for(Person index : persons.get())
					representation.getPersons().add(__inject__(InstanceHelper.class).buildOne(PersonDto.class, index).setIsMasculine(Sex.MASCULIN.equals(index.getSex())));
			}
			
			Collection<Service> services = data.getServices();
			if(__inject__(CollectionHelper.class).isNotEmpty(services)) {
				representation.setServices(null);
				for(Service index : services)
					representation.addServices(index.getCode());
			}
		}else
			super.__copy__(source, destination);
	}
	
}
