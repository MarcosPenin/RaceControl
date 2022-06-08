package operaciones;

import java.util.ArrayList;
import java.util.Scanner;
import main.RaceControlApp;
import pojos.Car;
import pojos.Garage;
import pojos.Tournament;
import utilidades.ControlData;
import vista.UserData;

/**
 * Opciones para que el usuario gestione los garages guardados
 *
 */
public class OpGarage {

	static Scanner sc = new Scanner(System.in);

	/**
	 * Crea un garage nuevo
	 */
	public static void createGarage() {
		Garage garage;
		String name = UserData.requestGarageName();
		ArrayList<Car> cars = UserData.requestCarsGarage();
		garage = new Garage(name, cars);
		RaceControlApp.almacen.addGarage(garage);
		System.out.println("Se ha creado el garage " + garage.getName());

	}

	/**
	 * Elimina un garage
	 */
	public static void deleteGarage() {
		if (RaceControlApp.almacen.getGarages().isEmpty()) {
			System.out.println("Primero debes crear un garage");
		} else {
			int i, op;
			do {
				System.out.println("�Qu� garage quieres borrar?");
				i = 0;
				for (Garage garage : RaceControlApp.almacen.getGarages()) {
					i++;
					System.out.println(i + ": " + garage.getName());
				}
				op = ControlData.lerPositiveInt(sc);
			} while (op > i);
			System.out.println("Se ha borrado el garage " + RaceControlApp.almacen.getGarages().get(op - 1).getName());
			RaceControlApp.almacen.getGarages().remove(op - 1);
		}

	}

	/**
	 * A�ade un coche a un garage existente
	 */
	public static void addCar() {
		if (RaceControlApp.almacen.getGarages().isEmpty()) {
			System.out.println("Primero debes crear un garage");
		} else {
			int i, op;
			do {
				System.out.println("�A qu� garage quieres a�adir el coche?");
				i = 0;
				for (Garage garage : RaceControlApp.almacen.getGarages()) {
					i++;
					System.out.println(i + ": " + garage.getName());
				}
				op = ControlData.lerPositiveInt(sc);
			} while (op > i);
			Car car = UserData.addCar();
			RaceControlApp.almacen.getGarages().get(op - 1).addCar(car);
			System.out.println("Se ha a�adido el coche del piloto " + car.getPiloto() + " al garage "
					+ RaceControlApp.almacen.getGarages().get(op - 1).getName());

		}

	}

	/**
	 * A�ade un garage ya existente a un torneo
	 */
	public static void addGarageToTournament() {
		if (RaceControlApp.almacen.getGarages().isEmpty()) {
			System.out.println("Primero debes crear un garage");
		} else if (RaceControlApp.almacen.getActualTournaments().isEmpty()) {
			System.out.println("Ahora mismo ning�n torneo acepta inscripciones");
		} else {
			
			int op, i;
			do {
				System.out.println("�Qu� garage quieres a�adir?");
				i = 0;
				for (Garage garage : RaceControlApp.almacen.getGarages()) {
					i++;
					System.out.println(i + ": " + garage.getName());
				}
				op = ControlData.lerPositiveInt(sc);
			} while (op > i);

			Garage garage = RaceControlApp.almacen.getGarages().get(op - 1);
			System.out.println("�A qu� torneo quieres a�adirlo?");
	
			do {
				i=0;
				for (Tournament t : RaceControlApp.almacen.getActualTournaments()) {
					i++;
					System.out.println(i + ": " + t.getName());
				}
				op = ControlData.lerPositiveInt(sc);
			} while (op >i);
			Tournament tournament = RaceControlApp.almacen.getActualTournaments().get(op - 1);
			tournament.addGarage(garage);
			System.out.println("Se ha a�adido el garage " + garage.getName() + " al torneo " + tournament.getName());

		}

	}

}
