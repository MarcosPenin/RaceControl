import java.util.ArrayList;

import pojos.Car;
import pojos.Garage;
import pojos.StandarRace;

public class Main {
	public static void main(String[] args) {

		ArrayList<Car> coches = new ArrayList<>();

		Car coche1 = new Car();
		Car coche2 = new Car();
		Car coche3 = new Car();
		Car coche4 = new Car();
		

		Garage garage1=new Garage("Citroen");
		Garage garage2=new Garage("Seat");
		Garage garage3=new Garage("Renault");
		garage1.addCar(coche1);
		garage2.addCar(coche2);
		garage1.addCar(coche3);
		garage2.addCar(coche4);
		garage3.addCar(coche3);
		
		StandarRace race1=new StandarRace("Lemans",false);
		
		race1.addGarage(garage1);
		race1.addGarage(garage2);
		race1.addGarage(garage3);
		
		
		race1.start();
		
		try {
			race1.join();
		
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("acnsnacnsalknlkc");
	
		for(Car car: race1.getCars()) {
			System.out.println(car.getScore());
		}
		
	}

}
