package main;

import java.awt.BorderLayout;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import persistencia.*;

import vista.MenuRaceControl;
import vista.TextAreaOutputStream;
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
		
		
	}}
