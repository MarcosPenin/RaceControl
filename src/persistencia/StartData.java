package persistencia;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;

import main.RaceControlApp;
import pojos.Car;
import pojos.EliminationRace;
import pojos.Garage;
import pojos.Race;
import pojos.StandarRace;
import pojos.Tournament;

public class StartData {

	public static void addData() {
		
		
		Car car = new Car("Piloto 1","c","c","c");
		Car car2 = new Car("Piloto 2","c","c","c");
		Car car3 = new Car("Piloto 3","c","c","c");

		Car car4 = new Car("Piloto 4","c","c","c");
		Car car5 = new Car("Piloto 5","c","c","c");
		Car car6 = new Car("Piloto 6","c","c","c");

		ArrayList<Car> cars = new ArrayList<>();
		cars.add(car);
		cars.add(car2);
		cars.add(car3);

		ArrayList<Car> cars2 = new ArrayList<>();
		cars2.add(car4);
		cars2.add(car5);
		cars2.add(car6);

		Garage garage = new Garage("Garage 1", cars);
		Garage garage2 = new Garage("Garage 2", cars2);

		ArrayList<Garage> garages = new ArrayList<>();
		garages.add(garage);
		garages.add(garage2);

		StandarRace race = new StandarRace("Carrera 1");
		EliminationRace race2 = new EliminationRace("Carrera 2");
	

		Queue<Race> races = new LinkedList<>();

		races.add(race);
		races.add(race2);

		Tournament t = new Tournament("Torneo 1", races, false, garages);

		t.insertScoreTable();
		RaceControlApp.almacen.addTournament(t);
		RaceControlApp.almacen.addGarage(garage);
	}

}
