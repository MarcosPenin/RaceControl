package main;

import persistencia.Almacen;
import persistencia.MyJsonReader;
import vista.MenuRaceControl;
import vista.UIRaces;

/**
 * Programa para simular el funcionamiento de un Control de Carreras para una
 * serie de torneos automobilísticos
 * 
 * @author github.com/MarcosPenin
 *
 */
public class RaceControlApp {

	public static Almacen almacen = new Almacen();

	public static void main(String[] args) {

		UIRaces.run();
		MyJsonReader.readAlmacenJson();
		MenuRaceControl.menuPrincipal();
		//MyJsonWriter.writeAlmacenToJson();

		System.exit(0);

	}
}
