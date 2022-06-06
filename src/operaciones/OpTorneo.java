package operaciones;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

import persistencia.Almacen;
import pojos.Garage;
import pojos.Race;
import pojos.Tournament;
import utilidades.ControlData;
import vista.UserData;

public class OpTorneo {
	static Scanner sc = new Scanner(System.in);

	public static void chooseTournament() {
		boolean flag = false;

		if (Almacen.getTorneosActuales().isEmpty()) {
			System.out.println("Primero debes iniciar un torneo");
		} else {

			System.out.println("Selecciona un torneo:");

			int i = 0;
			for (Tournament t : Almacen.getTorneosActuales()) {
				i++;
				System.out.println(i + ": " + t.getName());
			}

			int op = ControlData.lerPositiveInt(sc);
			Tournament t = Almacen.getTorneosActuales().get(op - 1);

			if (!t.getGarages().isEmpty()) {
				startRace(t);
				flag = true;

			} else {
				System.out.println("El torneo no empezará hasta que se inscriban los garages");
				flag = true;
			}

		}
	}

	public static void startRace(Tournament t) {
		Race race = t.getRaces().poll();
		if (race == null) {
			System.out.println("No quedan carreras en este torneo, debería haber terminado");
		} else {
			race.run();
		}
	}

	public static void createTournament() {
		Tournament tournament;

		String name = UserData.requestName();
		boolean onlyOneGarage = UserData.requestOnlyOneGarage();
		Queue<Race> races = UserData.requestRaces();
		ArrayList<Garage> garages = UserData.requestGarages(onlyOneGarage);

		if (garages.isEmpty()) {
			tournament = new Tournament(name, races, onlyOneGarage);
		} else {
			tournament = new Tournament(name, races, onlyOneGarage, garages);
			tournament.setStarted(true);
			tournament.insertScoreTable();
		}

		Almacen.addTournament(tournament);

	}

	public static void printTournaments() {
		boolean onlyActualTournaments = UserData.seeActualOrAllTournaments();

		if (onlyActualTournaments) {
			if (Almacen.getTorneosActuales().isEmpty()) {
				System.out.println("No se está disputando ningún torneo");
			} else {
				for (Tournament t : Almacen.getTorneosActuales()) {
					System.out.println(t.getName());
				}
			}
		} else {
			if (Almacen.getTorneos().isEmpty()) {
				System.out.println("Todavía no se ha registrado ningún torneo");
			} else {
				for (Tournament t : Almacen.getTorneosActuales()) {
					System.out.println(t.getName());
				}
			}
		}

	}

}
