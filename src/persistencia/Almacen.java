package persistencia;

import java.util.ArrayList;
import java.util.HashSet;

import pojos.Car;
import pojos.Garage;
import pojos.Tournament;

public class Almacen {

	private static HashSet<Car> cars = new HashSet<>();
	private static HashSet<Tournament> tournaments = new HashSet<>();
	private static HashSet<Tournament> actualTournaments = new HashSet<>();
	private static ArrayList<Garage> garages = new ArrayList<>();

	public static ArrayList<Garage> getGarages() {
		return garages;
	}

	public static HashSet<Car> getCoches() {
		return cars;
	}

	public static HashSet<Tournament> getTorneos() {
		return tournaments;
	}

	public static HashSet<Tournament> getTorneosActuales() {
		return actualTournaments;
	}

	public static void addCar(Car car) {
		cars.add(car);
	}
	
	public static void addGarage(Garage garage) {
		garages.add(garage);
	}


	public static void addTournament(Tournament tournament) {
		tournaments.add(tournament);
		actualTournaments.add(tournament);
	}
	

	

}
