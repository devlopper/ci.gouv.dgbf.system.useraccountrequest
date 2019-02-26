package ci.gouv.dgbf.system.useraccountrequest.client.controller.entities;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputString;
import org.cyk.utility.client.controller.component.annotation.InputStringLineOne;
import org.cyk.utility.client.controller.data.AbstractDataImpl;

public class ServiceImpl extends AbstractDataImpl implements Service,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputString @InputStringLineOne @NotNull
	private String name;
	
	@Input @InputString @InputStringLineOne @NotNull
	private String description;
	
	@Override
	public Service setIdentifier(Object identifier) {
		return (Service) super.setIdentifier(identifier);
	}
	
	@Override
	public Service setCode(String code) {
		return (Service) super.setCode(code);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Service setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public Service setDescription(String description) {
		this.description = description;
		return this;
	}

	@Override
	public String toString() {
		return name;
	}
}
