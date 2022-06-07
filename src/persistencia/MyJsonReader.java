package persistencia;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import pojos.EliminationRace;
import pojos.Garage;
import pojos.Race;
import pojos.StandarRace;
import pojos.Tournament;

/**
 * Clase para recuperar los diferentes datos que usa el programa desde ficheros JSON
 */

public class MyJsonReader {

/**
 * Recupera todos los objetos guardados y sincroniza los objetos
 */
	public static void readAlmacenJson() {
		readTournaments();
		readActualTournaments();
		readGarages();
		readRaces();
		synchronizeRaces();

	}

	
	/**
	 * Recupera las carreras guardadas
	 */
	public static void readRaces() {
		Reader reader;
		try {
			reader = Files.newBufferedReader(Paths.get("StandardRaces.json"));
			Gson gsonRaces = new Gson();

			Type raceType = new TypeToken<ArrayList<StandarRace>>() {
			}.getType();
			Almacen.setStandardRaces(gsonRaces.fromJson(reader, raceType));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reader reader2;
		try {
			reader = Files.newBufferedReader(Paths.get("EliminationRaces.json"));
			Gson gsonRaces = new Gson();

			Type raceType = new TypeToken<ArrayList<EliminationRace>>() {
			}.getType();
			Almacen.setEliminationRaces(gsonRaces.fromJson(reader, raceType));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
/**
 * Recupera los torneos guardados
 */
	public static void readTournaments() {
		Reader reader;
		try {
			reader = Files.newBufferedReader(Paths.get("Tournaments.json"));
			Gson gsonTournaments = new Gson();

			Type tournamentType = new TypeToken<ArrayList<Tournament>>() {
			}.getType();
			Almacen.setTournaments(gsonTournaments.fromJson(reader, tournamentType));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Recupera los torneos actuales guardados
	 */
	public static void readActualTournaments() {
		Reader reader;
		try {
			reader = Files.newBufferedReader(Paths.get("ActualTournaments.json"));
			Gson gsonActualTournaments = new Gson();
			Type actualTournamentsType = new TypeToken<ArrayList<Tournament>>() {
			}.getType();
			Almacen.setActualTournaments(gsonActualTournaments.fromJson(reader, actualTournamentsType));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Recupera los garages guardados
	 */
	public static void readGarages() {
		Reader reader;
		try {
			reader = Files.newBufferedReader(Paths.get("Garages.json"));
			Gson gsonGarages = new Gson();
			Type garageType = new TypeToken<ArrayList<Garage>>() {
			}.getType();
			Almacen.setGarages(gsonGarages.fromJson(reader, garageType));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Vincula las carreras guardadas a los torneos donde se celebran
	 */
	public static void synchronizeRaces() {
		Queue<Race> races = new LinkedList<>();
		for (Tournament t : Almacen.getActualTournaments()) {
			t.setRaces(races);

			for (StandarRace race : Almacen.getStandardRaces()) {
				if (race.getTournament().getName().equals(t.getName())) {
					t.addRace(race);
					race.setTournament(t);
				}

			}
			for (EliminationRace race : Almacen.getEliminationRaces()) {
				if (race.getTournament().getName().equals(t.getName())) {
					t.addRace(race);
					race.setTournament(t);
				}
			}
		}
	}

}
