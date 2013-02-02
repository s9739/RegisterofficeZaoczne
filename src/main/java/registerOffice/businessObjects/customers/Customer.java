package registerOffice.businessObjects.customers;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import registerOffice.businessObjects.boats.*;



@Entity //tworzenie tabeli z klientami
@Table(name = "Customer")
@NamedQueries({
	@NamedQuery(
			name="Customer.all",
			query="from Customer p"
			),
	@NamedQuery(
			name="customer.id",
			query="from Customer p where id= :id"
			),
	@NamedQuery(
			name="Customer.delete",
			query="Delete from Customer p where id=:id"
			)
})
public class Customer {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="Name") //okreslenie kolumny glownej
	private String name;
	
	@OneToMany(mappedBy="owner", cascade = CascadeType.PERSIST)
	private List<Boat> boats;
	private String firstname;
	private String pesel;
	private String address;
	private String city;
	
	//konstruktor
	public Customer(String firstname, String name, String pesel, String address, String city)
	{
		//context= Context.getInstance();
		//context.raisenumberOfPeople();
		this.firstname=firstname;
		this.name=name;
		this.address=address;
		this.pesel=pesel;
		this.city=city;
		this.boats=new ArrayList<Boat>();
	}
	

	//wlasciwosci
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname= firstname;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Boat> getBoat() {
		return boats;
	}
	public void setBoat(List<Boat> boats) {
		this.boats = boats;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	/*@Transient
	Context context;*/
	
	/*public Customers(String name, String pesel, String address) //wrzucał do SQL
	{
		this(name,pesel);
		this.address=address;
	}*/
	
	/*public Customer(String name) {	
		this(name,"");
	}
	
	public Customer()
	{
		this("","");
	}*/
	
	/*@Override
	protected void finalize() throws Throwable {
		context.reducePeople();
		super.finalize();
	}*/
	
}
