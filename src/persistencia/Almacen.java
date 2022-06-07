package persistencia;

import java.util.ArrayList;

import pojos.Garage;
import pojos.Race;
import pojos.Tournament;

public class Almacen {


	private static ArrayList<Tournament> tournaments = new ArrayList<>();
	private static ArrayList<Tournament> actualTournaments = new ArrayList<>();
	private static ArrayList<Garage> garages = new ArrayList<>();
	private static ArrayList<Race> races = new ArrayList<>();

	public static ArrayList<Race> getRaces() {
		return races;
	}


	public static void setRaces(ArrayList<Race> races) {
		Almacen.races = races;
	}


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
	

	public static void addRace(Race race) {
		races.add(race);
	}

}
