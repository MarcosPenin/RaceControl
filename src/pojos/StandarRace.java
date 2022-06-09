package pojos;

import java.awt.BorderLayout;
import java.io.PrintStream;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import vista.TextAreaOutputStream;

public class StandarRace extends Race {

	private long horas = 3 * 60;

	public StandarRace(String raceName) {
		super(raceName);
	}

	public StandarRace(String raceName, int horas) {
		super(raceName);
		this.horas = horas;
	}

	/**
	 * Simula la celebración de una carrera Standard, acelerando o decelerando los
	 * participantes una vez por minuto hasta que se alcanza el tiempo fijado.
	 *
	 * Una vez finalizada la carrera calcula el podium y lo muestra, además de
	 * actualizar las puntuaciones generales del torneo.
	 *
	 * Si es la última carrera del torneo establece los ganadores.
	 * 
	 * @return Nada
	 */
	public void run() {
		
		

		System.err.println("***********************************************");
		System.err.println("COMIENZA LA CARRERA " + getRaceName().toUpperCase());

		long raceTime = 0;
		insertCars();

		startCars();
		while (raceTime < horas) {
			System.err.println("***********************************************");
			System.err.println("NUEVA VUELTA EN LA CARRERA " + getRaceName().toUpperCase());
			driveAll();
			raceTime += 1;
			try {
				Thread.sleep(6000);
				// Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Collections.sort(cars);
		setPodium();
		brakeStopAll();

		actualizeScore();
	}

	/**
	 * Establece las mayores distancias recorridas por los participantes y sitúa en
	 * el podio a los pilotos de los coches que han recorrido esas distancias. Las
	 * posiciones del podio se pueden compartir
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
