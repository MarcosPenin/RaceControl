package persistencia;

import java.util.ArrayList;
import java.util.HashSet;

import pojos.Car;
import pojos.Garage;
import pojos.Tournament;

public class Almacen {


	private static ArrayList<Tournament> tournaments = new ArrayList<>();
	private static ArrayList<Tournament> actualTournaments = new ArrayList<>();
	private static ArrayList<Garage> garages = new ArrayList<>();

	public static ArrayList<Garage> getGarages() {
		return garages;
	}


	public static ArrayList<Tournament> getTorneos() {
		return tournaments;
	}

	public static ArrayList<Tournament> getTorneosActuales() {
		return actualTournaments;
	}

	public static ArrayList<Tournament> getTournaments() {
		return tournaments;
	}


	public static void setTournaments(ArrayList<Tournament> tournaments) {
		Almacen.tournaments = tournaments;

	}


	public static void setActualTournaments(ArrayList<Tournament> actualTournaments) {
		Almacen.actualTournaments = actualTournaments;
	}


	public static void setGarages(ArrayList<Garage> garages) {
		Almacen.garages = garages;
	}


	public static void addGarage(Garage garage) {
		garages.add(garage);
	}


	public static void addTournament(Tournament tournament) {
		tournaments.add(tournament);
		actualTournaments.add(tournament);
	}
	

}
