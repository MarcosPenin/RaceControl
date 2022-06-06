package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import persistencia.Almacen;
import pojos.Car;
import pojos.EliminationRace;
import pojos.Garage;
import pojos.Race;
import pojos.StandarRace;
import pojos.Tournament;
import vista.MenuRaceControl;

public class RaceControlApp {
	public static void main(String[] args) {
		
		Car car=new Car("Piloto 1");
		Car car2=new Car("Piloto 2");
		Car car3=new Car("Piloto 3");
		
		Car car4=new Car("Piloto 4");
		Car car5=new Car("Piloto 5");
		Car car6=new Car("Piloto 6");
		
		
		ArrayList<Car> cars=new ArrayList<>();
		cars.add(car);
		cars.add(car2);
		cars.add(car3);
		
		
		ArrayList<Car> cars2=new ArrayList<>();
		cars2.add(car4);
		cars2.add(car5);
		cars2.add(car6);
		
		
		Garage garage=new Garage("Garage 1",cars);
		Garage garage2=new Garage("Garage 2",cars2);
		
		
		ArrayList<Garage> garages=new ArrayList<>();
		garages.add(garage);
		garages.add(garage2);
		
		EliminationRace race=new EliminationRace("Carrera 1");
		EliminationRace race2=new EliminationRace("Carrera 2");
		
		Queue<Race> races=new LinkedList<>();
		
		races.add(race);
		races.add(race2);
		
		Tournament t =new Tournament("Torneo 1",races,false,garages);
		t.insertScoreTable();
		Almacen.addTournament(t);
		Almacen.addGarage(garage);
		
		for(Garage g: t.getGarages()) {
			System.out.println(g.getCars().size());
		}
		
		System.out.println(t.getGarages().size());
		
		
		
		MenuRaceControl.menuPrincipal();
		

	}
}
