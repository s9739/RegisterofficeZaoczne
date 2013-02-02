package registerOffice.businessObjects.boats;

import javax.persistence.Entity;


@Entity
public class FastBoat extends Boat{

	
	private String name;
	private String code;
	

	//konstruktory
	public FastBoat(String name, String code)
	{
		this.name=name;
		this.code=code;
	}
	
	
	//wlasciwosci
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	//metody
	
	@Override
	public String getBoatDetails() {
		// TODO Auto-generated method stub
		return name+" "+code;
	}

}
