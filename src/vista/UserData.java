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

	/**
	 * Pide el nombre para un torneo
	 * @return El nombre del torneo
	 */
	
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

	
	/**
	 * Pregunta al usuario si un torneo se reservará a un solo garage o tendrá varios participantes
	 * @return False si participan varios garages, True si solo participa un garage
	 */
	
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

	
	
	/**
	 * Pide un número indeterminado de carreras para un torneo
	 * @return Las carreras del torneo
	 */
	
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

	
	/**
	 * Permite seleccionar los garages que participarán en un torneo de entre los garages guardados
	 * @return Los garages que partiparán en el torneo
	 */
	
	public static ArrayList<Garage> requestGarages(boolean onlyOneGarage) {
		ArrayList<Garage> garages = new ArrayList<Garage>();
		boolean anotherGarage = false, addNow, flag = false;
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
				newGarage = Almacen.getGarages().get(op - 1);

				for (Garage garage : garages) {
					if (garage.getName() == newGarage.getName()) {
						System.out.println("Ese garage ya participa en el torneo");
						flag = true;
					}
				}
				if (!flag) {
					garages.add(newGarage);
				}

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

	/**
	 * Permite escoger entre sí o no
	 * @return True para sí y False para no
	 */
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

	/**
	 * Pregunta si una carrera será de eliminación o standard
	 * @return True para Eliminacion, false para Standard
	 */
	public static boolean requestElimination() {
		System.out.println("¿La carrera tendrá el formato normal o de eliminación?");
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

	
	
	/**
	 * Pregunta si el usuario quiere visualizar los torneos actuales o el histórico de torneos
	 * @return True para los actuales, False para el histórico
	 */
	public static boolean seeActualOrAllTournaments() {
		System.out
				.println("¿Quieres ver los torneos que se están disputando ahora o el histórico completo de torneos?");
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

	/**
	 * Pide el nombre para un nuevo garage
	 * @return El nombre del garage
	 */
	public static String requestGarageName() {
		System.out.println("¿Cómo se llamará el nuevo garage?");
		String name = sc.nextLine();
		return name;

	}

	/**
	 * Pide los coches para un nuevo garage
	 * @return Los coches del nuevo garage
	 */
	public static ArrayList<Car> requestCarsGarage() {
		ArrayList<Car> cars = new ArrayList<Car>();
		Car nextCar;
		boolean another = true;
		System.out.println("Tienes que añadir al menos un coche");
		do {
			nextCar = addCar();
			System.out.println("¿Quieres añadir otro coche?");
			another = requestYesNo();
		} while (another);
		return cars;
	}

	
	/**
	 * Pide los datos de un nuevo coche
	 * @return El nuevo coche
	 */
	public static Car addCar() {
		System.out.println("Introduce el nombre del piloto");
		String piloto = sc.nextLine();
		System.out.println("Introduce la marca");
		String marca = sc.nextLine();
		System.out.println("Introduce el modelo");
		String modelo = sc.nextLine();
		System.out.println("Introduce el tipo de combustible");
		String combustible = sc.nextLine();

		Car car = new Car(piloto, marca, modelo, combustible);
		return car;

	}

}