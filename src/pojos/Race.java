package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Race  implements Serializable {

	protected String raceName;
	// quitar

	protected ArrayList<Car> cars = new ArrayList<>();
	protected ArrayList<Car> podium = new ArrayList<>();
	protected Tournament tournament;
	protected Car first;
	protected Car second;
	protected Car third;

	public Race(String raceName, Tournament tournament) {
		super();
		this.raceName = raceName;
		this.tournament = tournament;
	}


	public void insertCars() {
		if (this.tournament.onlyOneGarage) {
			cars = tournament.getGarages().get(0).getCars();
		} else {
			Random random = new Random();
			for (Garage garage : tournament.getGarages()) {
				int max = garage.getCars().size();
				int position = random.nextInt(max - 0) + 0;
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



	public Car getFirst() {
		return first;
	}

	public void setFirst(Car first) {
		this.first = first;
	}

	public Car getSecond() {
		return second;
	}

	public void setSecond(Car second) {
		this.second = second;
	}

	public Car getThird() {
		return third;
	}

	public void setThird(Car third) {
		this.third = third;
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

	public ArrayList<Car> getPodium() {
		return podium;
	}

	public void setPodium(ArrayList<Car> podium) {
		this.podium = podium;
	}

}
