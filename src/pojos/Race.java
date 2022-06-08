package pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;



public abstract class Race {

	protected String raceName;

	protected ArrayList<Car> cars = new ArrayList<>();
	protected HashMap<String,Integer> podium = new HashMap<>();
	protected transient Tournament tournament;
	

	public Race(String raceName) {
		super();
		this.raceName = raceName;
	}

	
	/**
	 *Simula la celebración de una carrera. Desarrollado en las subclases
	 * 
	 */	
	public abstract void run() ;

	
	public void driveAll() {
		for (Car car : cars) {
			car.drive();
			car.setDistance(car.getDistance() + car.getSpeedometer());
			System.out.println(car.getPiloto() + ":    " + car.getDistance());
		}
	}
	
	public void actualizeScore() {
		System.out.println("CARRERA TERMINADA. PODIUM: ");
		getPodium().forEach((i, j) -> System.out.println("Coche: " + i + ": Posición: " + j));
	
		tournament.actualiceScoreTable(this);
		tournament.setDrivenRaces(tournament.getDrivenRaces() + 1);
		if (tournament.getDrivenRaces() == tournament.getNumRaces()) {
			tournament.setWinners();
		}
		
	}
	
	
	
	/**
	 *Accede al torneo asociado a esta carrera. Si es un torneo de un solo garage añade todos sus coches
	 *a la carrera. Si es de varios escoge aleatoriamente un coche de cada garage y lo añade a la carrera
	 * 
	 * @return Nada
	 */
	public void insertCars() {
		if (this.tournament.onlyOneGarage) {
			for(Car car: tournament.getGarages().get(0).getCars()) {
				cars.add(car);
			}
		} else {
			Random random = new Random();
			for (Garage garage : tournament.getGarages()) {
				int max = garage.getCars().size();
				int position = random.nextInt(max) ;
				this.cars.add(garage.getCars().get(position));
			}
		}
	}

	/**
	 *Enciende todos los coches que participan en la carrera
	 * 
	 */
	
	public void startCars() {
		for (Car car : cars) {
			car.start();
		}
	}

	/**
	 *Frena todos los coches que participan en la carrera y los apaga
	 * 
	 * @return Nada
	 */
	public void brakeStopAll() {
		for (Car car : cars) {
			car.brakeStop();
		}
	}
	public Tournament getTournament() {
		return tournament;
	}


	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}



	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public void setCar(ArrayList<Car> car) {
		this.cars = car;
	}

	public HashMap<String,Integer> getPodium() {
		return podium;
	}



}
