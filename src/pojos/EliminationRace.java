package pojos;

import java.util.ArrayList;
import java.util.Collections;

public class EliminationRace extends Race {


	private final int WARM_UP_MINUTS = 5;

	public EliminationRace(String raceName) {
		super(raceName);
	}

	
	/**
	 *Simula la celebraci�n de una carrera Standard, acelerando o decelerando los participantes
	 *una vez por minuto.  
	 *
	 *Los primeros minutos son de calentamiento, los coches van avanzando pero no se elimina a nadie. 
	 *
	 *A partir de ah� cada minuto se elimina al coche que va en �ltima posici�n, finalizando la carrera
	 *cuando solo queda uno. En caso de empate en �ltima posici�n no se eliminar� a nadie en ese minuto
	 *
	 *Una vez finalizada la carrera calcula el podium y lo muestra, adem�s de actualizar las puntuaciones
	 *generales del torneo. 
	 *
	 *Si es la �ltima carrera del torneo establece los ganadores. 
	 * 
	 * @return Nada
	 */
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
				podium.put(cars.get(2).getPiloto(), 3);
			}
			if (cars.size() == 2) {
				podium.put(cars.get(1).getPiloto(), 2);
			}

			if (cars.get(cars.size() - 1) == cars.get(cars.size() - 2)) {
				System.out.println("Empate en �ltima posici�n, no hay eliminados en este minuto");
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
		podium.put(cars.get(0).getPiloto(), 1);
		cars.get(0).brakeStop();
		
		System.out.println("CARRERA TERMINADA. PODIUM: ");
		getPodium().forEach((i, j) -> System.out.println("Coche: " + i + ": Posici�n: " + j));


		tournament.actualiceScoreTable(this);
		tournament.setDrivenRaces(tournament.getDrivenRaces() + 1);
		if (tournament.getDrivenRaces() == tournament.getNumRaces()) {
			tournament.setWinners();
		}
	}
}
