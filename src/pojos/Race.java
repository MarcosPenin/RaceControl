package pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;



public class Race {

	protected String raceName;

	protected ArrayList<Car> cars = new ArrayList<>();
	protected HashMap<String,Integer> podium = new HashMap<>();
	protected Tournament tournament;
	

	public Race(String raceName) {
		super();
		this.raceName = raceName;
	}

	
	public  void run() {}

	public void insertCars() {
		if (this.tournament.onlyOneGarage) {
			cars = tournament.getGarages().get(0).getCars();
		} else {
			Random random = new Random();
			for (Garage garage : tournament.getGarages()) {
				int max = garage.getCars().size();
				int position = random.nextInt(max-1) ;
				this.cars.add(garage.getCars().get(position));
			}
		}
	}

	public void startCars() {
		for (Car car : cars) {
			car.start();
		}
	}


	public void brakeStopAll() {
		for (Car car : cars) {
			car.brakeStop();
		}
	}
	public Tournament getTournament() {
		return tournament;
	}


	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}



	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public void setCar(ArrayList<Car> car) {
		this.cars = car;
	}

	public HashMap<String,Integer> getPodium() {
		return podium;
	}



}
