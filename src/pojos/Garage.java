package pojos;

import java.util.ArrayList;

public class Garage {

	private String name;
	private ArrayList<Car> cars=new ArrayList<>();

	public Garage(String name) {
		super();
		this.name = name;
	}

	public Garage(String name, ArrayList<Car> cars) {
		super();
		this.name = name;
		for(Car car: cars) {
			this.cars.add(car);
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}

	public void addCar(Car car) {
		cars.add(car);
	}

}
