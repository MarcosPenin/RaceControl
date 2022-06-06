package pojos;

import java.util.ArrayList;
import java.util.Collections;

public class EliminationRace extends Race {


	private final int WARM_UP_MINUTS = 5;

	public EliminationRace(String raceName) {
		super(raceName);
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
				podium.put(cars.get(2), 3);
			}
			if (cars.size() == 2) {
				podium.put(cars.get(1), 2);
			}

			if (cars.get(cars.size() - 1) == cars.get(cars.size() - 2)) {
				System.out.println("Empate en última posición, no hay eliminados en este minuto");
			} else {
				System.out.println(cars.get(cars.size() - 1).getPiloto() + " out");
				cars.get(cars.size() - 1).brakeStop();
				cars.remove(cars.size() - 1);
			}

			try {
				// Thread.sleep(60000); UN MINUTO EN LA VERSION FINAL
				Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		podium.put(cars.get(0), 1);
		cars.get(0).brakeStop();
		
		System.out.println("CARRERA TERMINADA. PODIUM: ");
		getPodium().forEach((i, j) -> System.out.println("Coche: " + i + ": Posición: " + j));


		tournament.actualiceScoreTable(this);
		tournament.setDrivenRaces(tournament.getDrivenRaces() + 1);
		if (tournament.getDrivenRaces() == tournament.getNumRaces()) {
			tournament.setWinners();
		}
	}
}
