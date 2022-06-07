package main;

import persistencia.*;
import vista.MenuRaceControl;
import pojos.*;

public class RaceControlApp {
	public static void main(String[] args) {
		
	
		StartData.addData();
//		MyJsonReader.readAlmacenJson();
//
//		for(Tournament t:Almacen.getActualTournaments()) {
//			System.out.println(t.getNumRaces());
//			System.out.println(t.getDrivenRaces());
//		}
		
		MenuRaceControl.menuPrincipal();

		
//		MyJsonWriter.writeAlmacenToJson();
		
	}
}
