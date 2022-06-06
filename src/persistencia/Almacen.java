package persistencia;

import java.util.ArrayList;
import java.util.HashSet;

import pojos.Car;
import pojos.Garage;
import pojos.Tournament;

public class Almacen {

	private static HashSet<Car> cars = new HashSet<>();
	private static ArrayList<Tournament> tournaments = new ArrayList<>();
	private static ArrayList<Tournament> actualTournaments = new ArrayList<>();
	private static ArrayList<Garage> garages = new ArrayList<>();

	public static ArrayList<Garage> getGarages() {
		return garages;
	}

	public static HashSet<Car> getCoches() {
		return cars;
	}

	public static ArrayList<Tournament> getTorneos() {
		return tournaments;
	}

	public static ArrayList<Tournament> getTorneosActuales() {
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
