package registerOffice.businessObjects.boats;

import javax.persistence.Entity;

@Entity
public class MotorBoat extends Boat{

		
	@Override
	public String getBoatDetails() {
		// TODO Auto-generated method stub
		return "This is an motor boat.";
	}

	private double power;
	private String name;
	private String code;

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

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}
	
	//konstruktory
		public MotorBoat(String name, String code, double power)
		{
			this.name=name;
			this.code=code;
			this.power=power;
		}
	
}

