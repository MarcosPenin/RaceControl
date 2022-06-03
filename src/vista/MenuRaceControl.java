package vista;

import java.util.ArrayList;
import java.util.Scanner;

import operaciones.OpTorneo;
import utilidades.ControlData;
import utilidades.Menu;

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
			}
		} while (opMenu != 5);
	}

	public static void menuInsertar() {
		Menu menuTablas = new Menu(opciones());
		System.out.println("*********************************************************************");
		System.out.println("¿Que desea añadir?");
		menuTablas.printMenu();
		byte op = ControlData.lerByte(sc);
		switch (op) {
		case 1:
			//Anadir.anadirAutor();
			break;
		case 2:
			//Anadir.anadirLibro();
			break;
		case 3:
			//Anadir.vincularLibro();
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
	
	static ArrayList<String> tablas2() {
		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Autor");
		opciones.add("Libro");
		opciones.add("Volver");
		return opciones;
	}
	

	static ArrayList<String> consultas() {
		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Buscar libro por título");
		opciones.add("Buscar libros de un autor");
		opciones.add("Ver todos los libros");
		opciones.add("Ver todos los autores con sus libros");
		opciones.add("Volver");
		return opciones;
	}

}

	
	

