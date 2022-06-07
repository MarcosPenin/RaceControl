package main;

import persistencia.Almacen;
import persistencia.MyJsonReader;
import persistencia.MyJsonWriter;
import persistencia.StartData;
import pojos.EliminationRace;
import pojos.Race;
import pojos.StandarRace;
import pojos.Tournament;
import vista.MenuRaceControl;

public class RaceControlApp {
	public static void main(String[] args) {

		StartData.addData();

//		MyJsonWriter.writeAlmacenToJson();
		// MyJsonReader.readTournaments();

//		StandarRace s =new StandarRace("Carrera normal",2);
//		EliminationRace e = new EliminationRace("Carrera eliminación");
		
//		Almacen.addRace(e);
//		Almacen.addRace(s);
		
		
//		MyJsonWriter.writeRaces();
		
		MyJsonReader.readRaces();
		
		
		for(Race race: Almacen.getRaces()) {
			System.out.println(race.getRaceName());
			if(race instanceof StandarRace) {
				((StandarRace) race).getHoras();
			}
			
			race.run();
		}
		
		

		for (Tournament x : Almacen.getTorneosActuales()) {
			System.out.println(x.getScoreTable());
		}

		MenuRaceControl.menuPrincipal();

	}
}
