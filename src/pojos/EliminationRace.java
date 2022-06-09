package pojos;

import java.util.Collections;

public class EliminationRace extends Race  {


	private final int WARM_UP_MINUTS = 5;

	public EliminationRace(String raceName) {
		super(raceName);
	}

	
	/**
	 *Simula la celebración de una carrera Standard, acelerando o decelerando los participantes
	 *una vez por minuto.  
	 *
	 *Los primeros minutos son de calentamiento, los coches van avanzando pero no se elimina a nadie. 
	 *
	 *A partir de ahí cada minuto se elimina al coche que va en última posición, finalizando la carrera
	 *cuando solo queda uno. En caso de empate en última posición no se eliminará a nadie en ese minuto
	 *
	 *Una vez finalizada la carrera calcula el podium y lo muestra, además de actualizar las puntuaciones
	 *generales del torneo. 
	 *
	 *Si es la última carrera del torneo establece los ganadores. 
	 * 
	 */
	public void run() {
		System.err.println("***********************************************");
		System.err.println("COMIENZA LA CARRERA "+ getRaceName().toUpperCase());
		
		insertCars();
		startCars();
		for (int i = 0; i < WARM_UP_MINUTS; i++) {
			System.err.println("***********************************************");
			System.err.println("VUELTA DE CALENTAMIENTO EN LA CARRERA "+ getRaceName().toUpperCase());
			driveAll();
			try {
				Thread.sleep(6000); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while (cars.size() > 1) {
			System.err.println("***********************************************");
			System.err.println("NUEVA VUELTA EN LA CARRERA "+ getRaceName().toUpperCase());
			driveAll();
			Collections.sort(cars);
			
			if (cars.size() == 3) {
				podium.put(cars.get(2).getPiloto(), 3);
			}
			if (cars.size() == 2) {
				podium.put(cars.get(1).getPiloto(), 2);
			}

			if (cars.get(cars.size() - 1) == cars.get(cars.size() - 2)) {
				System.err.println("Empate en última posición, no hay eliminados en este minuto");
			} else {
				System.err.println("El piloto "+cars.get(cars.size() - 1).getPiloto() + " ha sido eliminado");
				cars.get(cars.size() - 1).brakeStop();
				cars.remove(cars.size() - 1);
			}

			try {
				Thread.sleep(6000); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		podium.put(cars.get(0).getPiloto(), 1);
		cars.get(0).brakeStop();
		
		actualizeScore();
		
		
	}
}
