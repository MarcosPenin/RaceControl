package pojos;

import java.util.ArrayList;
import java.util.Collections;

public class EliminationRace extends Race {

	/*
	 * carreras de Eliminación (que tienen una serie de minutos previos para que los
	 * pilotos se hagan a la pista, y al terminar esos minutos de calentamiento, se
	 * irá retirando el coche que va en la última posición, cada minuto, hasta que
	 * sólo quede un coche).
	 * 
	 */
	private final int WARM_UP_MINUTS = 5;

	public EliminationRace(String raceName, Tournament tournament) {
		super(raceName, tournament);
	}

	public void run() {
		insertCars();
		startCars();

		for (int i = 0; i < WARM_UP_MINUTS; i++) {
			for (Car car : cars) {
				car.drive();
				car.setDistance(car.getDistance() + car.getSpeedometer());
				System.out.println(car.getPiloto() + ":    " + car.getDistance());
			}
		}
		while (cars.size() > 1) {
			for (Car car : cars) {
				car.drive();
				car.setDistance(car.getDistance() + car.getSpeedometer());
				System.out.println(car.getPiloto() + ":    " + car.getDistance());
			}
			Collections.sort(cars);
			if (cars.size() == 3) {
				setThird(cars.get(2));
			}
			if (cars.size() == 2) {
				setSecond(cars.get(1));
			}

			System.out.println(cars.get(cars.size() - 1).getPiloto() + " out");
			cars.get(cars.size() - 1).brakeStop();
			cars.remove(cars.size() - 1);

			try {
				// Thread.sleep(60000); UN MINUTO EN LA VERSION FINAL
				Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setFirst(cars.get(0));
		cars.get(0).brakeStop();

		tournament.actualiceScoreTable(this);
		tournament.setDrivenRaces(tournament.getDrivenRaces() + 1);
		if (tournament.getDrivenRaces() == tournament.getNumRaces()) {
			tournament.setWinners();
		}
	}
}
