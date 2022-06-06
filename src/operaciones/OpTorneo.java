package operaciones;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

import persistencia.Almacen;
import pojos.Garage;
import pojos.Race;
import pojos.Tournament;
import vista.UserData;

public class OpTorneo {
	static Scanner sc = new Scanner(System.in);

	public static void chooseTournament() {
		boolean flag = false;

		if (Almacen.getTorneosActuales().isEmpty()) {
			System.out.println("Primero debes iniciar un torneo");
		} else {
			System.out.println("Actualmente se están disputando los siguientes torneos:");
			for (Tournament t : Almacen.getTorneosActuales()) {
				System.out.println(t.getName());
			}
			System.out.println("Introduce el nombre del torneo donde quieras iniciar tu carrera");
			String name = sc.nextLine();
			for (Tournament t : Almacen.getTorneosActuales()) {
				if (name.equalsIgnoreCase(t.getName())) {
					if (!t.getGarages().isEmpty()) {
						startRace(t);
						flag = true;
						
					} else {
						System.out.println("El torneo no empezará hasta que se inscriban los garages");
						flag = true;
					}
					break;
				}
			}
			if (!flag) {
				System.out.println("No se ha encontrado ese torneo, no se ha podidio iniciar la carrera");
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
