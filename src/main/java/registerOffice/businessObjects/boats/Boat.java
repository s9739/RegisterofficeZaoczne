package registerOffice.businessObjects.boats;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import registerOffice.businessObjects.customers.Customer;

@Entity
public abstract class Boat implements BoatsInterface{

	@Id
	@GeneratedValue
	private int id;
	
	
	@ManyToOne
	protected Customer owner; //alias wewnatrz klasy
	
	
	public void printData()
	{
		System.out.println("Customer: "+owner.getName());
		System.out.println(getBoatDetails());
	}
	
	public abstract String getBoatDetails();
	
	
	public void setOwner(Customer owner)
	{
		this.owner=owner;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*@Override
	protected void finalize() throws Throwable {
		context.reduceBoats();
		super.finalize();
	}*/

	/*@Transient
	Context context;
	public Boat(){
		context =Context.getInstance(); //licznik produktow w pamieci
		context.raiseNumberOfBoats();
	}*/
	
}
