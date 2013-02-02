package registerOffice;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import registerOffice.businessObjects.boats.MotorBoat;
import registerOffice.businessObjects.boats.Boat;
import registerOffice.businessObjects.boats.SailingBoat;
import registerOffice.businessObjects.boats.FastBoat;
import registerOffice.businessObjects.customers.*;
import registerOffice.management.*;
//biblioteki nieimplementowane
//import java.sql.SQLPermission;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import registerOffice.management.conditions.Condition;
//import registerOffice.management.conditions.GetByAddressCondition;
//import registerOffice.management.conditions.GetByNameCondition;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		ManagerInterface<Customer> hib= 
				new HibernatePersonManager(session);

		//tworzenie czytelnikow
		Customer seba = new Customer("Sebastian","Zarski", "80032923431", "Piastowska 96","Gdansk");
		Customer marta = new Customer("Marta","Rode", "83112298743", "3 Maja","Wejherowo");
		Customer michal = new Customer("Michal","Toborek", "82043298767", "Gdanska 70","Rumia");

		//dodawanie szybkich łodzi motorowych
		Boat thunder = new FastBoat("Black Thunder","FS5000");
		Boat speed = new FastBoat("Red Speed","FS4000");
		
		//dodawanie dużych łodzi motorowych
		Boat drago = new MotorBoat("Drago","MB3400",600);
		
		//dodawanie Jachtów
		Boat gold = new SailingBoat("Goldwasser","SB9000",2012);
		
		//przypisanie klientow do łódek
		thunder.setOwner(seba);
		speed.setOwner(marta);
		drago.setOwner(michal);
		gold.setOwner(michal);
		
		//przypisanie ksiazek do czytelnikow
		seba.getBoat().add(thunder);
		marta.getBoat().add(speed);
		michal.getBoat().add(drago);
		michal.getBoat().add(gold);
		
		//uzycie hibernate do zapisania danych w tabelach
		hib.save(seba);
		hib.save(marta);
		hib.save(michal);
		
		List<Customer>results = hib.getAll();
		
		for(Customer p :results)
		{
			System.out.println(p.getName());
		}
			
	}

}
