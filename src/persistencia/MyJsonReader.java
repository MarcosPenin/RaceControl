package persistencia;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import pojos.EliminationRace;
import pojos.Garage;
import pojos.Race;
import pojos.StandarRace;
import pojos.Tournament;

public class MyJsonReader {

	public static void readAlmacenJson() {
		readTournaments();
		readActualTournaments();
		readGarages();
	}
	
	
	public static void readRaces() {
		Reader reader;		
		RuntimeTypeAdapterFactory<Race> vehicleAdapterFactory = RuntimeTypeAdapterFactory.of(Race.class, "type")
				.registerSubtype(StandarRace.class, "Standard").registerSubtype(EliminationRace.class, "Elimination");
		
		
		try {
			reader = Files.newBufferedReader(Paths.get("Races.json"));
			Gson gsonRaces = new GsonBuilder().registerTypeAdapterFactory(vehicleAdapterFactory).create();
				
		
			Almacen.addRace(gsonRaces.fromJson(reader, Race.class));
		} catch (IOException e) {
			e.printStackTrace();
		}}
	

		
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

}
