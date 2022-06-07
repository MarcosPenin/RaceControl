package persistencia;

import java.util.ArrayList;

import pojos.EliminationRace;
import pojos.Garage;
import pojos.Race;
import pojos.StandarRace;
import pojos.Tournament;

public class Almacen {

	private static ArrayList<Tournament> tournaments = new ArrayList<>();
	private static ArrayList<Tournament> actualTournaments = new ArrayList<>();
	private static ArrayList<Garage> garages = new ArrayList<>();
	private static ArrayList<Race> races = new ArrayList<>();

	private static ArrayList<StandarRace> standardRaces = new ArrayList<>();
	private static ArrayList<EliminationRace> eliminationRaces = new ArrayList<>();

	public static ArrayList<Race> getRaces() {
		return races;
	}

	public static ArrayList<StandarRace> getStandardRaces() {
		return standardRaces;
	}

	public static void setStandardRaces(ArrayList<StandarRace> standardRaces) {
		Almacen.standardRaces = standardRaces;
	}

	public static ArrayList<EliminationRace> getEliminationRaces() {
		return eliminationRaces;
	}

	public static void setEliminationRaces(ArrayList<EliminationRace> eliminationRaces) {
		Almacen.eliminationRaces = eliminationRaces;
	}

	public static ArrayList<Tournament> getActualTournaments() {
		return actualTournaments;
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
	
	public static void addStandardRace(StandarRace race) {
		standardRaces.add(race);
	}



	public static void addEliminationRace(EliminationRace race) {
		eliminationRaces.add(race);
	}

}
