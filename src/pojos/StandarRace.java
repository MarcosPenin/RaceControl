package pojos;

import java.util.ArrayList;
import java.util.Collections;

public class StandarRace extends Race {

	private long horas = 3;
	// MULTIPLICAR POR 60 para la VERSION FINAL

	public StandarRace(String raceName, Tournament tournament) {
		super(raceName, tournament);
	}

	public StandarRace(String raceName, Tournament tournament, int horas) {
		super(raceName, tournament);
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
		
		tournament.actualiceScoreTable(this);
		tournament.setDrivenRaces(tournament.getDrivenRaces()+1);
		if (tournament.getDrivenRaces() == tournament.getNumRaces()) {
			tournament.setWinners();
		}
	}

	public void setPodium() {
		setFirst(cars.get(0));
		setSecond(cars.get(1));
		setThird(cars.get(2));
	}

	public long getHoras() {
		return horas / 60;
	}

	public void setHoras(int horas) {
		this.horas = horas * 60;
	}

}
