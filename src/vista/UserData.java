package vista;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import persistencia.Almacen;
import pojos.Car;
import pojos.EliminationRace;
import pojos.Garage;
import pojos.Race;
import pojos.StandarRace;
import pojos.Tournament;
import utilidades.ControlData;
import utilidades.Menu;

public class UserData {

	static Scanner sc = new Scanner(System.in);

	public static String requestName() {
		String name = "";
		boolean valido = true;
		do {
			valido = true;
			System.out.println("¿Cómo se llamará el nuevo torneo?");
			name = sc.nextLine();
			if (!Almacen.getTorneos().isEmpty()) {
				for (Tournament t : Almacen.getTorneos()) {
					if (t.getName() == name) {
						valido = false;
					}
				}
			}
		} while (!valido);
		return name;
	}

	public static boolean requestOnlyOneGarage() {
		boolean onlyOne = false;

		ArrayList<String> onlyOneGarage = new ArrayList<String>();
		onlyOneGarage.add("Varios garages");
		onlyOneGarage.add("Solo uno");

		System.out.println("¿Participarán varios garages o uno solo?");
		Menu menuOnlyOneGarage = new Menu(onlyOneGarage);
		byte opMenu;
		menuOnlyOneGarage.printMenu();
		opMenu = ControlData.lerByte(sc);

		switch (opMenu) {
		case 1:
			onlyOne = false;
			break;
		case 2:
			onlyOne = true;
			break;

		}
		return onlyOne;
	}

	public static Queue<Race> requestRaces() {
		Queue<Race> races = new LinkedList<>();
		boolean anotherRace = true;
		System.out.println("Ahora vamos a añadir las carreras del torneo. Se correrán en el orden que las introduzcas");
		do {
			System.out.println("Introduce el nombre de la carrera");
			String name = sc.nextLine();

			boolean eliminationRace = requestElimination();

			if (!eliminationRace) {
				System.out.println("¿Cuántas horas durará la carrera?");
				int horas = ControlData.lerPositiveInt(sc);
				StandarRace race = new StandarRace(name, horas);
				races.add(race);
			} else {
				EliminationRace race = new EliminationRace(name);
				races.add(race);
			}
			System.out.println("¿Quieres introducir otra carrera?");
			anotherRace = requestYesNo();
		} while (anotherRace == true);
		return races;
	}

	public static ArrayList<Garage> requestGarages(boolean onlyOneGarage) {
		ArrayList<Garage> garages = new ArrayList<Garage>();
		boolean anotherGarage = false, addNow;
		Garage newGarage;

		System.out.println("¿Quieres añadir los garages ahora?");

		addNow = requestYesNo();

		if (addNow && !Almacen.getGarages().isEmpty()) {

			do {

				System.out.println("Selecciona un garage");
				int i = 0;
				for (Garage garage : Almacen.getGarages()) {
					i++;
					System.out.println(i + ": " + garage.getName());

				}
				int op = ControlData.lerPositiveInt(sc);
				newGarage = Almacen.getGarages().get(i - 1);

				for (Garage garage : garages) {
					if (garage.getName() == newGarage.getName()) {
						System.out.println("Ese garage ya participa en el torneo");
					} else {
						garages.add(newGarage);
					}
				}

				garages.add(Almacen.getGarages().get(i - 1));
				if (!onlyOneGarage) {
					System.out.println("¿Quieres introducir otro garage?");
					anotherGarage = requestYesNo();
				}
			} while (anotherGarage);
		} else {
			System.out.println("Tendrás que añadir garages antes de poder empezar el torneo");
		}

		return garages;
	}

	private static boolean requestYesNo() {

		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Sí");
		opciones.add("No");

		Menu menuSiNo = new Menu(opciones);
		menuSiNo.printMenu();
		byte opMenu;
		boolean op = false;
		opMenu = ControlData.lerByte(sc);
		switch (opMenu) {
		case 1:
			op = true;
			break;
		case 2:
			op = false;
			break;
		}
		return op;
	}

	public static boolean requestElimination() {
		System.out.println("¿Quieres introducir una carrera normal o de eliminación?");
		ArrayList<String> eliminacion = new ArrayList<String>();
		eliminacion.add("Normal");
		eliminacion.add("Eliminación");

		Menu menuEliminacion = new Menu(eliminacion);
		menuEliminacion.printMenu();
		byte opMenu;
		boolean opEliminacion = false;
		opMenu = ControlData.lerByte(sc);

		switch (opMenu) {
		case 1:
			opEliminacion = false;
			break;
		case 2:
			opEliminacion = true;
			break;
		}
		return opEliminacion;
	}
	
	
	
	
	public static boolean seeActualOrAllTournaments() {
		System.out.println("¿Quieres ver los torneos que se están disputando ahora o el histórico completo de torneos?");
		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Los torneos que se están disputando");
		opciones.add("Todos los torneos");

		Menu menu = new Menu(opciones);
		menu.printMenu();
		byte opMenu;
		boolean op = false;
		opMenu = ControlData.lerByte(sc);

		switch (opMenu) {
		case 1:
			op = true;
			break;
		case 2:
			op = false;
			break;
		}
		return op;
	}
	
	
	
	
	
	

}