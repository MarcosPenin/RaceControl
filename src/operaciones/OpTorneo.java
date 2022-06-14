package operaciones;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

import main.RaceControlApp;
import pojos.Garage;
import pojos.Race;
import pojos.StandarRace;
import pojos.Tournament;
import utilidades.ControlData;
import vista.UserData;

public class OpTorneo {
	static Scanner sc = new Scanner(System.in);

	/**
	 * Selecciona un torneo entre los que se están celebrando actualmente
	 */
	public static void chooseTournament() {

		if (RaceControlApp.almacen.getActualTournaments().isEmpty()) {
			System.out.println("Primero debes iniciar un torneo");
		} else {
			int i, op;

			do {
				System.out.println("Selecciona un torneo:");

				i = 0;
				for (Tournament t : RaceControlApp.almacen.getActualTournaments()) {
					i++;
					System.out.println(i + ": " + t.getName());
				}

				op = ControlData.lerPositiveInt(sc);

			} while (op > i);
			Tournament t = RaceControlApp.almacen.getActualTournaments().get(op - 1);
			startRace(t);

		}
	}

	/**
	 * Comienza una carrera
	 * 
	 * @param t El torneo donde se celebrará la carrera
	 */
	public static void startRace(Tournament t) {
		boolean flag = false;
		Thread h1 = new Thread();
		if (!t.getGarages().isEmpty()) {
			Race race = t.getRaces().poll();
			if (race == null) {
				System.out.println("No quedan carreras en este torneo");
			} else {
				race.insertCars();
				h1 = new Thread(race);
				h1.start();
			}
		} else {
			System.out.println("El torneo no empezará hasta que se inscriban los garages");
			flag = true;
		}
	}

	/**
	 * Crea un torneo nuevo con sus carreras. Se puede introducir ahora los garages
	 * o dejarlo para más tarde
	 */
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
			tournament.insertScoreTable();
		}

		RaceControlApp.almacen.addTournament(tournament);

	}

	/**
	 * Muestra el listado de torneos actuales o el histórico de torneos
	 */
	public static void printTournaments() {
		boolean onlyActualTournaments = UserData.seeActualOrAllTournaments();

		if (!onlyActualTournaments) {
			if (RaceControlApp.almacen.getActualTournaments().isEmpty()) {
				System.out.println("No se está disputando ningún torneo");
			} else {
				for (Tournament t : RaceControlApp.almacen.getTournaments()) {
					System.out.println(t.getName());
				}
			}
		} else {
			if (RaceControlApp.almacen.getTournaments().isEmpty()) {
				System.out.println("Todavía no se ha registrado ningún torneo");
			} else {
				for (Tournament t : RaceControlApp.almacen.getActualTournaments()) {
					System.out.println(t.getName());
				}
			}
		}

	}

}
