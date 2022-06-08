package persistencia;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import main.RaceControlApp;
import pojos.Garage;
import pojos.Race;
import pojos.Tournament;

/**
 * Clase para recuperar los diferentes datos que usa el programa desde ficheros JSON
 */

public class MyJsonReader {

/**
 * Recupera todos los objetos guardados y sincroniza las carreras con sus torneos
 */
	public static void readAlmacenJson() {
		Reader reader;
		try {
			reader = Files.newBufferedReader(Paths.get("Almacen.json"));
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Race.class, new InterfaceAdapter<Race>());
			gsonBuilder.setPrettyPrinting();
			Gson gson = gsonBuilder.create();
		
			RaceControlApp.almacen=gson.fromJson(reader, Almacen.class);
			for(Tournament t:RaceControlApp.almacen.getActualTournaments()) {
				for(Race r: t.getRaces()) {
					r.setTournament(t);
				}
		}
		
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
			RaceControlApp.almacen.setTournaments(gsonTournaments.fromJson(reader, tournamentType));
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
			RaceControlApp.almacen.setActualTournaments(gsonActualTournaments.fromJson(reader, actualTournamentsType));
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
			RaceControlApp.almacen.setGarages(gsonGarages.fromJson(reader, garageType));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
