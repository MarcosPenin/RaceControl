package pojos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class StandarRace extends Race {

	private long horas = 3;
	// MULTIPLICAR POR 60 para la VERSION FINAL

	public StandarRace(String raceName) {
		super(raceName);
	}

	public StandarRace(String raceName, int horas) {
		super(raceName);
		this.horas = horas;
	}

	/**
	 *Simula la celebración de una carrera Standard, acelerando o decelerando los participantes
	 *una vez por minuto hasta que se alcanza el tiempo fijado. 
	 *
	 *Una vez finalizada la carrera calcula el podium y lo muestra, además de actualizar las puntuaciones
	 *generales del torneo. 
	 *
	 *Si es la última carrera del torneo establece los ganadores. 
	 * 
	 * @return Nada
	 */
	public void run() {
		System.out.println("COMIENZA LA CARRERA "+ getRaceName().toUpperCase());
		
		
		insertCars();
		long raceTime = 0;
		startCars();
		while (raceTime < horas) {
			for (Car car : cars) {
				car.drive();
				car.setDistance(car.getDistance() + car.getSpeedometer());
				System.out.println(car.getPiloto() + ":    " + car.getDistance());
			}
			raceTime += 1;
			try {
				// Thread.sleep(60000); UN MINUTO EN LA VERSION FINAL
				Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Collections.sort(cars);
		setPodium();
		brakeStopAll();
		
		System.out.println("CARRERA TERMINADA. PODIUM: ");
		getPodium().forEach((i, j) -> System.out.println("Coche: " + i + ": Posición: " + j));

		

		tournament.actualiceScoreTable(this);
		tournament.setDrivenRaces(tournament.getDrivenRaces() + 1);
		if (tournament.getDrivenRaces() == tournament.getNumRaces()) {
			tournament.setWinners();
		}
	}

	
	/**
	 *Establece las mayores distancias recorridas por los participantes y sitúa en el podio
	 *a los pilotos de los coches que han recorrido esas distancias. Las posiciones del podio se pueden compartir
	 * 
	 * @return Nada
	 */
	
	public void setPodium() {
		int distanceFirst = 0, distanceSecond = 0, distanceThird = 0;
		for (Car car : cars) {
			if (car.getDistance() > distanceFirst) {
				distanceFirst = car.getDistance();
			} else if (car.getDistance() > distanceSecond) {
				distanceSecond = car.getDistance();
			} else if (car.getDistance() > distanceThird) {
				distanceThird = car.getDistance();
			}
		}
		for (Car car : cars) {
			if (car.getDistance() == distanceFirst) {
				podium.put(car.getPiloto(), 1);
			} else if (car.getDistance() == distanceSecond) {
				podium.put(car.getPiloto(), 2);
			} else if (car.getDistance() == distanceThird) {
				podium.put(car.getPiloto(), 3);
			}
		}

	}

	public long getHoras() {
		return horas / 60;
	}

	public void setHoras(int horas) {
		this.horas = horas * 60;
	}

}
