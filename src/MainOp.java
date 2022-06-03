import java.util.ArrayList;
import java.util.Scanner;

import persistencia.Almacen;
import pojos.Car;
import pojos.Garage;
import pojos.Tournament;

public class MainOp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Tournament t1 = new Tournament("Torneo1", false, 4);
		Tournament t2 = new Tournament("Torneo2", false, 4);

		ArrayList<Car> cars = new ArrayList<>();
		ArrayList<Car> cars2 = new ArrayList<>();
		Car coche1 = new Car("Piloto1");
		Car coche2 = new Car("Piloto2");
		Car coche3 = new Car("Piloto3");
		Car coche4 = new Car("Piloto4");

		cars.add(coche1);
		cars.add(coche2);
		cars.add(coche3);
		cars.add(coche4);

		int i = 0;
		
		for (Car car : cars) {
			i++;
			System.out.println(i + ": " + car.getPiloto());
			
		}
		System.out.println(i);

		int op = sc.nextInt();
		
	

		cars2.add(cars.get(op));

		for (Car car : cars2) {
			System.out.println(car.getPiloto());

		}

	}
}
