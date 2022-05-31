package pojos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Tournament {

	private String name;
	private ArrayList<Race> races= new ArrayList<>();
	private int raceNumber;
	private HashSet<Car> carsWithPoints=new HashSet<>();
	private ArrayList<Car> winners= new ArrayList<>();

	public Tournament(String name, int raceNumber) {
		super();
		this.name = name;
		this.raceNumber = raceNumber;
	}

	public Tournament(String name, int raceNumber, ArrayList<Race> races) {
		super();
		this.name = name;
		this.races = races;
		this.raceNumber = raceNumber;
	}

	public void setScoreTable() {
		for (Race race : races) {
			carsWithPoints.add(race.first);
			carsWithPoints.add(race.second);
			carsWithPoints.add(race.third);
		}
	}

	public void setWinner() {
		if (!carsWithPoints.isEmpty()) {

			int maxScore = 0;
			for (Car car : carsWithPoints) {
				if (car.getScore() > maxScore) {
					maxScore = car.getScore();
				}
			}
			for (Car car : carsWithPoints) {
				if (car.getScore() == maxScore) {
					winners.add(car);
				}
			}
		} else {
			System.out.println("First you have to fill the score table");
		}
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

}
