import java.util.ArrayList;
import java.util.Map;

import pojos.Car;
import pojos.EliminationRace;
import pojos.Garage;
import pojos.StandarRace;
import pojos.Tournament;

public class MainElimination {
	public static void main(String[] args) {

		ArrayList<Car> coches = new ArrayList<>();

		Car coche1 = new Car("Piloto1");
		Car coche2 = new Car("Piloto2");
		Car coche3 = new Car("Piloto3");
		Car coche4 = new Car("Piloto4");

		Garage garage1 = new Garage("Citroen");
		Garage garage2 = new Garage("Seat");
		Garage garage3 = new Garage("Renault");
		garage1.addCar(coche1);
		garage2.addCar(coche2);
		garage3.addCar(coche3);

		Tournament tournament1 = new Tournament("Lemans", false, 2);
		tournament1.addGarage(garage1);
		tournament1.addGarage(garage2);
		tournament1.addGarage(garage3);

		EliminationRace race1 = new EliminationRace("Primera pista", tournament1);
		EliminationRace race2 = new EliminationRace("Segunda pista", tournament1);
		tournament1.addRace(race1);
		tournament1.addRace(race2);

		tournament1.insertScoreTable();

		race1.run();

		for (Map.Entry<Car, Integer> entry : tournament1.getScoreTable().entrySet()) {
			System.out.println(entry.getKey().getPiloto() + ":       " + entry.getValue());
		}

		race2.run();

		for (Map.Entry<Car, Integer> entry : tournament1.getScoreTable().entrySet()) {
			System.out.println(entry.getKey().getPiloto() + ":       " + entry.getValue());
		}

	}
}