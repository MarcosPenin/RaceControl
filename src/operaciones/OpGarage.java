package operaciones;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

import persistencia.Almacen;
import pojos.Car;
import pojos.Garage;
import pojos.Race;
import pojos.Tournament;
import utilidades.ControlData;
import vista.UserData;

public class OpGarage {

	static Scanner sc = new Scanner(System.in);

	public static void createGarage() {
		Garage garage;
		String name = UserData.requestGarageName();
		ArrayList<Car> cars = UserData.requestCarsGarage();
		garage = new Garage(name, cars);
		Almacen.addGarage(garage);
		System.out.println("Se ha creado el garage "+garage.getName());
		
	}

	public static void deleteGarage() {
		boolean flag = false;
		if (Almacen.getGarages().isEmpty()) {
			System.out.println("Primero debes crear un garage");
		} else {
			System.out.println("¿Qué garage quieres borrar?");
			int i = 0;
			for (Garage garage : Almacen.getGarages()) {
				i++;
				System.out.println(i + ": " + garage.getName());
			}
			int op = ControlData.lerPositiveInt(sc);
			System.out.println("Se ha borrado el garage " + Almacen.getGarages().get(op-1).getName());
			Almacen.getGarages().remove(op - 1);
		}

	}

	public static void addCar() {
		boolean flag = false;
		if (Almacen.getGarages().isEmpty()) {
			System.out.println("Primero debes crear un garage");
		} else {
			System.out.println("¿A qué garage quieres añadir el coche?");
			int i = 0;
			for (Garage garage : Almacen.getGarages()) {
				i++;
				System.out.println(i + ": " + garage.getName());
			}
			int op = ControlData.lerPositiveInt(sc);
			Car car = UserData.addCar();
			Almacen.getGarages().get(op - 1).addCar(car);
			System.out.println("Se ha añadido el coche del piloto " + car.getPiloto() + " al garage "
					+ Almacen.getGarages().get(op - 1).getName());

		}

	}

	public static void addGarageToTournament() {
		boolean flag = false;
		if (Almacen.getGarages().isEmpty()) {
			System.out.println("Primero debes crear un garage");
		} else if (Almacen.getTorneosActuales().isEmpty()) {
			System.out.println("Ahora mismo ningún torneo acepta inscripciones");
		} else {
			System.out.println("¿Qué garage quieres añadir?");
			int i = 0;
			for (Garage garage : Almacen.getGarages()) {
				i++;
				System.out.println(i + ": " + garage.getName());
			}
			int op = ControlData.lerPositiveInt(sc);
			Garage garage = Almacen.getGarages().get(op - 1);
			System.out.println("¿A qué torneo quieres añadirlo?");
			i = 0;
			for (Tournament t : Almacen.getTorneosActuales()) {
				i++;
				System.out.println(i + ": " + t.getName());
			}
			op = ControlData.lerPositiveInt(sc);
			Tournament tournament = Almacen.getTorneosActuales().get(op - 1);
			tournament.addGarage(garage);
			System.out.println("Se ha añadido el garage " + garage.getName() + " al torneo " + tournament.getName());

		}

	}

}
