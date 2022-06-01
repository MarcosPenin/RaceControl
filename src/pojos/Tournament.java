package pojos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Tournament {

	private String name;
	private ArrayList<Race> races = new ArrayList<>();
	private int drivenRaces;
	private int numRaces;
	private HashMap<Car, Integer> scoreTable = new HashMap<>();
	private ArrayList<Garage> garages = new ArrayList<Garage>();
	boolean onlyOneGarage;
	private ArrayList<Car> winners = new ArrayList<>();

	public int getDrivenRaces() {
		return drivenRaces;
	}

	public void setDrivenRaces(int drivenRaces) {
		this.drivenRaces = drivenRaces;
	}

	public int getNumRaces() {
		return numRaces;
	}

	public void setNumRaces(int numRaces) {
		this.numRaces = numRaces;
	}

	public int getRaceNumber() {
		return drivenRaces;
	}

	public void setRaceNumber(int raceNumber) {
		this.drivenRaces = raceNumber;
	}

	public ArrayList<Garage> getGarages() {
		return garages;
	}

	public void setGarages(ArrayList<Garage> garages) {
		this.garages = garages;
	}

	public boolean isOnlyOneGarage() {
		return onlyOneGarage;
	}

	public void setOnlyOneGarage(boolean onlyOneGarage) {
		this.onlyOneGarage = onlyOneGarage;
	}

	public ArrayList<Car> getWinners() {
		return winners;
	}

	public void setWinners() {
		int maxScore = 0;
		for (int valor : scoreTable.values()) {
			if (valor > maxScore) {
				maxScore = valor;
			}
		}
		for (Map.Entry<Car, Integer> entry : scoreTable.entrySet()) {
			if (entry.getValue() == maxScore) {
				winners.add(entry.getKey());
			}
		}

		System.out.println("EL TORNEO HA TERMINADO. GANADORES: ");
		for (Car x : winners) {
			System.out.println(x.toString());
		}

	}

	public Tournament(String name, boolean onlyOneGarage, int numRaces) {
		super();
		this.name = name;
		this.onlyOneGarage = onlyOneGarage;
		this.numRaces = numRaces;
	}

	public Tournament(String name, ArrayList<Race> races, boolean onlyOneGarage, int numRaces) {
		super();
		this.name = name;
		this.races = races;
		this.onlyOneGarage = onlyOneGarage;
		this.numRaces = numRaces;
	}

	public void actualiceScoreTable(Race race) {
		if (!scoreTable.isEmpty()) {
			for (Map.Entry<Car, Integer> podiumPosition : race.podium.entrySet()) {
				for (Map.Entry<Car, Integer> entry : scoreTable.entrySet()) {
					if (podiumPosition.getKey().getPiloto() == entry.getKey().getPiloto()) {
						if (podiumPosition.getValue() == 1) {
							entry.setValue(entry.getValue() + 10);
						} else if (podiumPosition.getValue() == 2) {
							entry.setValue(entry.getValue() + 5);
						} else if (entry.getValue() == 3) {
							entry.setValue(entry.getValue() + 3);
						}
					}
				}
			}
		} else {
			System.out.println("First you have to fill the score table");
		}
	}

	public HashMap<Car, Integer> getScoreTable() {
		return scoreTable;
	}

	public void setScoreTable(HashMap<Car, Integer> scoreTable) {
		this.scoreTable = scoreTable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Race> getRaces() {
		return races;
	}

	public void setRaces(ArrayList<Race> races) {
		this.races = races;
	}

	public void addRace(Race race) {
		this.races.add(race);
	}

	public void addGarage(Garage garage) {
		garages.add(garage);
	}

	public void insertScoreTable() {
		for (Garage garage : this.garages) {
			for (Car car : garage.getCars()) {
				scoreTable.put(car, 0);

			}
		}

	}

}
