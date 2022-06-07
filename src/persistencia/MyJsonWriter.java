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
import pojos.Tournament;

public class MyJsonWriter {

	public static void writeAlmacenToJson() {
		writeTournaments();
		writeActualTournaments();
		writeGarages();
		saveRaces();
		writeRaces();

	}

	public static void saveRaces() {
		for (Tournament t : Almacen.getTorneos()) {
			if (t.getRaces() != null) {

				for (Race race : t.getRaces()) {
					if (race instanceof StandarRace) {
						Almacen.addStandardRace((StandarRace) race);
					} else if (race instanceof EliminationRace) {
						Almacen.addEliminationRace((EliminationRace) race);
					}

				}
			}
		}

	}

	public static void writeRaces() {

		Gson gsonRaces = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writerRaces = Files.newBufferedWriter(Paths.get("StandardRaces.json"))) {
			gsonRaces.toJson(Almacen.getStandardRaces(), writerRaces);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Gson gsonRaces2 = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writerRaces2 = Files.newBufferedWriter(Paths.get("EliminationRaces.json"))) {
			gsonRaces2.toJson(Almacen.getEliminationRaces(), writerRaces2);
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
