package registerOffice.management.conditions;

import registerOffice.businessObjects.customers.Customer;

public class GetByAddressCondition extends Condition<Customer>{

	private String address;
	
	public GetByAddressCondition(String address)
	{
		this.address=address;
	}
	@Override
	protected boolean check(Customer obj) {
		// TODO Auto-generated method stub
		return obj.getAddress().equalsIgnoreCase(address);
	}

}
