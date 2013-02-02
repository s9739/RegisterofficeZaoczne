package registerOffice.management;

import java.util.List;

import org.hibernate.Session;

import registerOffice.businessObjects.customers.Customer;

public class HibernatePersonManager 
	implements ManagerInterface<Customer>{

	Session session;
	
	public HibernatePersonManager(Session session)
	{
		this.session=session;
	}
	
	@Override
	public Customer get(int id) {
		
		List<Customer> result = 
				session.getNamedQuery("customer.id")
					.setInteger("id", id).list();
		if(result.size()==0)
			return null;
		
		Customer returnValue = new Customer(
				result.get(0).getFirstname(), 
				result.get(0).getName(), 
				result.get(0).getPesel(),
				result.get(0).getAddress(),
				result.get(0).getCity());
		returnValue.setId(result.get(0).getId());
		return returnValue;
	}

	@Override
	public List<Customer> getAll() {
		List<Customer> result =
				session.getNamedQuery("Customer.all")
				.list();
		return result;
	}

	@Override
	public boolean save(Customer obj) {
		
		try{
			session.beginTransaction();
			session.persist(obj);
			session.getTransaction().commit();
			return true;
		}catch(Exception ex){}
		
		return false;
	}

	@Override
	public boolean delete(Customer obj) {
		
		try
		{
			session.beginTransaction();
			session.getNamedQuery("Customer.delete")
			.setInteger("id", obj.getId())
			.executeUpdate();
			
			session.getTransaction().commit();
			return true;
		}catch(Exception ex)
		{}
		
		return false;
	}

}
