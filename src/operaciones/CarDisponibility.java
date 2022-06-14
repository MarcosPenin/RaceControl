package operaciones;

import java.util.ArrayList;
import java.util.List;

import pojos.Car;

public class CarDisponibility {

	public static CarDisponibility carDisponibility = new CarDisponibility();

	private ArrayList<Car> cars = new ArrayList<>();

	
	/**
	 * Comprueba si los coches de la carrera que se intenta iniciar están ocupados
	 * corriendo otra carrera. Si es así, la carrera no iniciará hasta que todos 
	 * estén liberados 
	 * 
	 * @param raceCars Los coches de la carrera
	 * @param name El nombre de la carrera
	 */
	public synchronized void checkDisponibility(List<Car> raceCars, String name) {
		boolean flag = false;
		while (!flag) {
			flag = true;
			for (Car raceCar : raceCars) {
				for (Car car : cars) {
					if (raceCar.getPiloto().compareTo(car.getPiloto()) == 0 && car.isRunning()) {
						try {
							System.err.println("******************************************************");
							System.err.println(
									"CARRERA " + name + " PREPARADA. EMPEZARA CUANDO TODOS LOS PILOTOS ESTEN LIBRES");
							System.err.println("******************************************************");
							wait();
							flag = false;
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	
	/**
	 * Libera los coches de una carrera para que puedan corren en otras
	 * 
	 * @param raceCars Los coches de la carrera
	 */
	public synchronized void liberateCars(List<Car> raceCars) {
		for (Car raceCar : raceCars) {
			for (Car car : cars) {
				if (raceCar.getPiloto().compareTo(car.getPiloto()) == 0) {
					car.setRunning(false);
				}
			}
		}
		notifyAll();

	}

	
	/**
	 * Bloquea los coches de una carrera para que no puedan correr en otras
	 * 
	 * @param raceCars Los coches de la carrera
	 */
	public synchronized void blockCars(List<Car> raceCars) {
		for (Car raceCar : raceCars) {
			for (Car car : cars) {
				if (raceCar.getPiloto().compareTo(car.getPiloto()) == 0) {
					car.setRunning(true);
				}
			}
		}

	}

	public void addCar(Car car) {
		this.cars.add(car);
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}

}
