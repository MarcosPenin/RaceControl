package main;

import persistencia.*;

import vista.MenuRaceControl;

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

		//StartData.addData();
		MyJsonReader.readAlmacenJson();
		
		MenuRaceControl.menuPrincipal();
		
	
		//MyJsonWriter.writeAlmacenToJson();
		
		}
		
		
	}
