package registerOffice.management.conditions;

import registerOffice.businessObjects.customers.Customer;

public class GetByNameCondition extends Condition<Customer>{

	private String name;
	
	public GetByNameCondition(String name)
	{
		this.name=name;
	}
	
	@Override
	protected boolean check(Customer obj) {
		
		return obj.getName().equalsIgnoreCase(name);
	}
	
	

}
