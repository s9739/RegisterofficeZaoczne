package registerOffice.management.conditions;

import registerOffice.businessObjects.customers.Customer;

public class GetByPeselCondition extends Condition<Customer>{

	private String pesel;
	
	public GetByPeselCondition(String pesel)
	{
		this.pesel=pesel;
	}
	
	@Override
	protected boolean check(Customer obj) {
		
		return obj.getPesel().equalsIgnoreCase(pesel);
	}

}
