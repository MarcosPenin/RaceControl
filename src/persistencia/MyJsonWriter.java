package persistencia;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import main.RaceControlApp;
import pojos.Race;
import pojos.Tournament;


/**
 * Clase para guardar los diferentes datos que usa el programa en ficheros JSON
 */

public class MyJsonWriter {

	
	
	/**
	 * Guarda torneos y garajes en un fichero json
	 */
	public static void writeAlmacenToJson() {
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Race.class, new InterfaceAdapter<Race>());
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		
		try (Writer writer = Files.newBufferedWriter(Paths.get("Almacen.json"))) {
			gson.toJson(RaceControlApp.almacen, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Guarda todos los torneos
	 */
	public static void writeTournaments(ArrayList<Tournament> tournaments) {
		Gson gsonTournaments = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writerTournaments = Files.newBufferedWriter(Paths.get("Tournaments.json"))) {
			gsonTournaments.toJson(tournaments, writerTournaments);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	/**
	 * Guarda los torneos actuales
	 */
	public static void writeActualTournaments() {
		Gson gsonActualTournaments = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writerActualTournaments = Files.newBufferedWriter(Paths.get("ActualTournaments.json"))) {
			gsonActualTournaments.toJson(RaceControlApp.almacen.getActualTournaments(), writerActualTournaments);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	/**
	 * Guarda los garages actuales
	 */
	public static void writeGarages() {
		Gson gsonGarages = new GsonBuilder().setPrettyPrinting().create();
		try {

			Writer writerGarages = Files.newBufferedWriter(Paths.get("Garages.json"));
			gsonGarages.toJson(RaceControlApp.almacen.getGarages(), writerGarages);
			writerGarages.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
