package pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import persistencia.Almacen;



public class Tournament {

	private String name;
	private int drivenRaces;
	private int numRaces = 10;
	boolean onlyOneGarage;
	private boolean started=false;
	private boolean finished=true;
	
	Queue<Race> races= new LinkedList<>();
	private ArrayList<Garage> garages = new ArrayList<Garage>();
	private HashMap<Car, Integer> scoreTable = new HashMap<>();
	private ArrayList<Car> winners = new ArrayList<>();
	
	
	//BORRAR, SOLO PARA PRUEBAS
	public Tournament(String name, boolean onlyOneGarage, int numRaces) {
		super();
		this.name = name;
		this.onlyOneGarage = onlyOneGarage;
		this.numRaces = numRaces;
	}



	public Tournament(String name, Queue<Race> races, boolean onlyOneGarage) {
		super();
		this.name = name;
		this.races = races;
		this.onlyOneGarage = onlyOneGarage;
		this.numRaces = races.size();
		for (Race race : races) {
			race.setTournament(this);
		}
	}

	public Tournament(String name, Queue<Race> races, boolean onlyOneGarage, ArrayList<Garage> garages) {
		super();
		this.name = name;
		this.races = races;
		this.onlyOneGarage = onlyOneGarage;
		this.numRaces = races.size();
		this.garages = garages;
		for (Race race : races) {
			race.setTournament(this);
		}

	}

	public void insertScoreTable() {
		if (!garages.isEmpty()) {
			for (Garage garage : this.garages) {
				for (Car car : garage.getCars()) {
					scoreTable.put(car, 0);
				}
			}
		} else {
			System.out.println("Primero debes inscribir los garages");
		}
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
	
	
	
	public void setWinners() {
		int maxScore = 0;
		if (drivenRaces == numRaces) {
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
			finished=true;
			Almacen.getTorneosActuales().remove(this);
			System.out.println("EL TORNEO HA TERMINADO. GANADORES: ");
			for (Car x : winners) {
				System.out.println(x.toString());
			}
		} else {
			System.out.println("Debes esperar al final del torneo para conocer el ganador");
		}
	}

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

	public Queue<Race> getRaces() {
		return races;
	}

	public void setRaces(Queue<Race> races) {
		this.races = races;
	}

	public void addRace(Race race) {
		this.races.add(race);
	}

	public void addGarage(Garage garage) {
		garages.add(garage);
	}
	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	

}
