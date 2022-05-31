package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Race extends Thread implements Serializable {

	protected String raceName;
	protected ArrayList<Garage> garages=new ArrayList<>();
	protected ArrayList<Car> cars= new ArrayList<>();
	protected ArrayList<Car> podium;
	protected boolean onlyOneGarage;
	protected Car first;
	protected Car second;
	protected Car third;

	public Race(String raceName, boolean onlyOneGarage) {
		super();
		this.raceName = raceName;
		this.garages = garages;
	}

	public Race(String raceName, ArrayList<Garage> garages, boolean onlyOneGarage) {
		super();
		this.raceName = raceName;
		this.garages = garages;

	}

	public void insertCars() {
		if (onlyOneGarage) {
			cars = garages.get(0).getCars();
		} else {
			Random random = new Random();
			for (Garage garage : garages) {
				int max = garage.getCars().size();
				int position = random.nextInt(max - 0) + 0;
				this.cars.add(garage.getCars().get(position));
			}
		}
	}

	public boolean isOnlyOneGarage() {
		return onlyOneGarage;
	}

	public void setOnlyOneGarage(boolean onlyOneGarage) {
		this.onlyOneGarage = onlyOneGarage;
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

	public ArrayList<Garage> getGarages() {
		return garages;
	}

	public void setGarages(ArrayList<Garage> garages) {
		this.garages = garages;
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

	public void addGarage(Garage garage) {
		garages.add(garage);
	}

	public void addCar(Car car) {
		this.cars.add(car);

	}

}
