package ci.gouv.dgbf.system.useraccountrequest.client.controller.api;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Singleton;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.client.controller.AbstractControllerEntityPersistedInCollectionImpl;
import org.cyk.utility.collection.CollectionHelper;

import ci.gouv.dgbf.system.useraccountrequest.client.controller.entities.Service;

@Singleton
public class ServiceControllerImpl extends AbstractControllerEntityPersistedInCollectionImpl<Service> implements ServiceController,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected Collection<Service> __getInitialCollection__() {
		//TODO those data should comes from another distant service call. For the moment we will simulate it
		return __inject__(CollectionHelper.class).instanciate(
				DependencyInjection.inject(Service.class).setIdentifier("1").setCode("ELB").setName("Elaboration du budget")
				,DependencyInjection.inject(Service.class).setIdentifier("2").setCode("EXB").setName("Exécution du budget")
				);
	}
	
}
