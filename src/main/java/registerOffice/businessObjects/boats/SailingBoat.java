package registerOffice.businessObjects.boats;

import javax.persistence.Entity;

@Entity
public class SailingBoat extends Boat{

		
	@Override
	public String getBoatDetails() {
		// TODO Auto-generated method stub
		return "This is a Sailing Boat.";
	}

	private String name;
	private String code;
	private int cabin_no;
	
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

	public double getCabin() {
		return cabin_no;
	}

	public void setCabin(int cabin_no) {
		this.cabin_no = cabin_no;
	}
	
	//konstruktory
		public SailingBoat(String name, String code, int cabin_no)
		{
			this.name=name;
			this.code=code;
			this.cabin_no=cabin_no;
		}
	
}

