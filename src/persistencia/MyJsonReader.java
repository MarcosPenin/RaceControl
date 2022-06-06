package persistencia;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.*;

import pojos.Garage;
import pojos.Tournament;

public class MyJsonReader {

	public static void readAlmacenJson() {
		readTournaments();
		readActualTournaments();
		readGarages();
	}
	
	
	
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
