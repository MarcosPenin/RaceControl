package vista;

import java.util.ArrayList;
import java.util.Scanner;

import operaciones.OpGarage;
import operaciones.OpTorneo;
import utilidades.ControlData;
import utilidades.Menu;


/**
 *Clase con menús para la aplicación
 *
 */

public class MenuRaceControl {

	static Scanner sc=new Scanner(System.in);
	
	public static void menuPrincipal() {
		
		Menu menuPrincipal = new Menu(opciones());
		byte opMenu;
		System.out.println("*********************************************************************");
		System.out.println("****************************BIENVENIDO*********************** ");

		do {
			System.out.println("*********************************************************************");
			System.out.println("Introduzca la opción que desee realizar:");
			menuPrincipal.printMenu();
			opMenu = ControlData.lerByte(sc);
			switch (opMenu) {
			case 1:
				OpTorneo.chooseTournament();
				break;
			case 2:
				OpTorneo.createTournament();
				break;
			case 3:
				OpTorneo.printTournaments();
				break;
			case 4:
				menuGarage();
			}
		} while (opMenu != 5);
	}

	
	public static void menuGarage() {
		Menu menuTablas = new Menu(opGarage());
		System.out.println("*********************************************************************");
		System.out.println("¿Que desea añadir?");
		menuTablas.printMenu();
		byte op = ControlData.lerByte(sc);
		switch (op) {
		case 1:
			OpGarage.createGarage();
			break;
		case 2:
			OpGarage.deleteGarage();
			break;
		case 3:
			OpGarage.addCar();
			break;
		case 4:
			OpGarage.addGarageToTournament();
			break;
		}
	}

	

	static ArrayList<String> opciones() {
		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Iniciar una carrera");
		opciones.add("Añadir un nuevo torneo");
		opciones.add("Ver torneos");
		opciones.add("Gestionar garages");	
		opciones.add("Salir");
		return opciones;
	}

	static ArrayList<String> onlyOneGarage() {
		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Varios garages");
		opciones.add("Solo uno");
		return opciones;
	}
	
	static ArrayList<String> opGarage() {
		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Crear garages");
		opciones.add("Borrar garages");
		opciones.add("Añadir coches a un garage");
		opciones.add("Instribir garages a un torneo");
		
		
		opciones.add("Volver");
		return opciones;
	}
	


}

	
	

