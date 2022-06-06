package main;


import persistencia.Almacen;
import persistencia.MyJsonReader;
import persistencia.MyJsonWriter;
import persistencia.StartData;
import pojos.Tournament;
import vista.MenuRaceControl;

public class RaceControlApp {
	public static void main(String[] args) {

//		StartData.addData();
//
//		MyJsonWriter.writeAlmacenToJson();
		MyJsonReader.readActualTournaments();
		
		for(Tournament x : Almacen.getTorneos()) {
			System.out.println(x.getName());
		}
		
		MenuRaceControl.menuPrincipal();

	}
}
