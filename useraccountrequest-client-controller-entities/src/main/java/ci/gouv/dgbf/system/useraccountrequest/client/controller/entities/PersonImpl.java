package ci.gouv.dgbf.system.useraccountrequest.client.controller.entities;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputChoice;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOne;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOneCombo;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOneRadio;
import org.cyk.utility.client.controller.component.annotation.InputString;
import org.cyk.utility.client.controller.component.annotation.InputStringLineMany;
import org.cyk.utility.client.controller.component.annotation.InputStringLineOne;
import org.cyk.utility.client.controller.data.AbstractDataImpl;
import org.cyk.utility.string.StringHelper;

public class PersonImpl extends AbstractDataImpl implements Person,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputString @InputStringLineOne @NotNull
	private String firstName;
	
	@Input @InputString @InputStringLineOne @NotNull
	private String lastNames;
	
	@Input @InputString @InputStringLineOne @NotNull
	private String administrativeUnit;
	
	@Input @InputChoice @InputChoiceOne @InputChoiceOneRadio @NotNull
	private Sex sex;
	
	@Input @InputString @InputStringLineMany @NotNull
	private String homeAddress;
	
	@Input @InputString @InputStringLineOne @NotNull
	private String electronicMailAddress;
	
	@Input @InputString @InputStringLineOne @NotNull
	private String phoneNumber;
	
	@Input @InputString @InputStringLineOne @NotNull
	private String postalBoxAddress;
	
	@Input @InputString @InputStringLineOne @NotNull
	private String employeeIdentifier;
	
	@Input @InputString @InputStringLineOne @NotNull
	private String function;
	
	@Input @InputChoice @InputChoiceOne @InputChoiceOneCombo @NotNull
	private Person hierarchy;
	
	@Override
	public Person setIdentifier(Object identifier) {
		return (Person) super.setIdentifier(identifier);
	}
	
	@Override
	public Person setCode(String code) {
		return (Person) super.setCode(code);
	}
	
	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public Person setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	@Override
	public String getLastNames() {
		return lastNames;
	}

	@Override
	public Person setLastNames(String lastNames) {
		this.lastNames = lastNames;
		return this;
	}
	
	@Override
	public String getFirstNameAndLastNames() {
		String name = getFirstName();
		name = (__inject__(StringHelper.class).isBlank(name) ? "" : name+" ") + getLastNames();
		return name;
	}
	
	@Override
	public Sex getSex() {
		return sex;
	}
	
	@Override
	public Person setSex(Sex sex) {
		this.sex = sex;
		return this;
	}

	@Override
	public String getEmployeeIdentifier() {
		return employeeIdentifier;
	}

	@Override
	public Person setEmployeeIdentifier(String employeeIdentifier) {
		this.employeeIdentifier = employeeIdentifier;
		return this;
	}

	@Override
	public String getFunction() {
		return function;
	}

	@Override
	public Person setFunction(String function) {
		this.function = function;
		return this;
	}

	@Override
	public Person getHierarchy() {
		return hierarchy;
	}

	@Override
	public Person setHierarchy(Person hierarchy) {
		this.hierarchy = hierarchy;
		return this;
	}
	
	@Override
	public String getHomeAddress() {
		return homeAddress;
	}
	
	@Override
	public Person setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
		return this;
	}
	
	@Override
	public String getElectronicMailAddress() {
		return electronicMailAddress;
	}
	
	@Override
	public Person setElectronicMailAddress(String electronicMailAddress) {
		this.electronicMailAddress = electronicMailAddress;
		return this;
	}
	
	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	@Override
	public Person setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
	
	@Override
	public String getPostalBoxAddress() {
		return postalBoxAddress;
	}
	
	@Override
	public Person setPostalBoxAddress(String postalBoxAddress) {
		this.postalBoxAddress = postalBoxAddress;
		return this;
	}
	
	@Override
	public String getAdministrativeUnit() {
		return administrativeUnit;
	}
	
	@Override
	public Person setAdministrativeUnit(String administrativeUnit) {
		this.administrativeUnit = administrativeUnit;
		return this;
	}
	
	@Override
	public String toString() {
		return getFirstNameAndLastNames();
	}

}
