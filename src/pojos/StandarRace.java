package pojos;

import java.util.ArrayList;
import java.util.Collections;

public class StandarRace extends Race {

	private long horas = 3;

	public StandarRace(String raceName, boolean onlyOneGarage) {
		super(raceName, onlyOneGarage);
	}

	public StandarRace(String raceName, int horas, boolean onlyOneGarage) {
		super(raceName, onlyOneGarage);
		this.horas = horas * 60;
	}

	public StandarRace(String raceName, ArrayList<Garage> garages, int horas, boolean onlyOneGarage) {
		super(raceName, garages, onlyOneGarage);
		this.horas = horas;
	}

	public void run() {
		insertCars();
		
		long raceTime = 0;
		startCars();
		while (raceTime < horas) {
			for (Car car : cars) {
				car.drive();
				car.setDistance(car.getDistance() + car.getSpeedometer());
				System.out.println(car.getDistance());
			}
			raceTime += 1;
			try {
				//Thread.sleep(60000); un minuto
				Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Collections.sort(cars);
		checkPodium();
		brakeCars();
		resetCarsDistance();
		turnOff();
	}

	public void startCars() {
		for (Car car : cars) {
			car.start();
		}
	}

	public void checkPodium() {
		setFirst(cars.get(0));
		cars.get(0).setScore((cars.get(0).getScore()) + 10);
		setSecond(cars.get(1));
		cars.get(1).setScore((cars.get(1).getScore()) + 5);
		setThird(cars.get(2));
		cars.get(2).setScore((cars.get(2).getScore()) + 3);
	}

	public void resetCarsDistance() {
		for (Car car : cars) {
			car.setDistance(0);
		}
	}

	public void brakeCars() {
		for (Car car : cars) {
			for (int i = 0; i < 20; i++) {
				car.brake();
			}
		}
	}

	public void turnOff() {
		for (Car car : cars) {
			car.stop();
			car.setDistance(0);
		}

	}

	public long getHoras() {
		return horas / 60;
	}

	public void setHoras(int horas) {
		this.horas = horas * 60;
	}

}
