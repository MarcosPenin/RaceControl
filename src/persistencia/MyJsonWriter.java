package persistencia;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pojos.EliminationRace;
import pojos.Race;
import pojos.StandarRace;

public class MyJsonWriter {

	public static void writeAlmacenToJson() {
		writeTournaments();
		writeActualTournaments();
		writeGarages();

	}

	public static void writeRaces() {
		RuntimeTypeAdapterFactory<Race> vehicleAdapterFactory = RuntimeTypeAdapterFactory.of(Race.class, "type")
				.registerSubtype(StandarRace.class, "Standard").registerSubtype(EliminationRace.class, "Elimination");

		Gson gsonRaces = new GsonBuilder().registerTypeAdapterFactory(vehicleAdapterFactory).create();
		try (Writer writerRaces = Files.newBufferedWriter(Paths.get("Races.json"))) {
			gsonRaces.toJson(Almacen.getRaces(), writerRaces);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void writeTournaments() {
		Gson gsonTournaments = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writerTournaments = Files.newBufferedWriter(Paths.get("Tournaments.json"))) {
			gsonTournaments.toJson(Almacen.getTorneosActuales(), writerTournaments);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void writeActualTournaments() {
		Gson gsonActualTournaments = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writerActualTournaments = Files.newBufferedWriter(Paths.get("ActualTournaments.json"))) {
			gsonActualTournaments.toJson(Almacen.getTorneosActuales(), writerActualTournaments);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void writeGarages() {
		Gson gsonGarages = new GsonBuilder().setPrettyPrinting().create();
		try {

			Writer writerGarages = Files.newBufferedWriter(Paths.get("Garages.json"));
			gsonGarages.toJson(Almacen.getGarages(), writerGarages);
			writerGarages.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
