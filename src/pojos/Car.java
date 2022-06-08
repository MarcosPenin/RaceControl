package pojos;

import java.util.Random;

public class Car implements Comparable<Car> {

	public enum Gear {
		N, D, R
	}

	private String piloto;
	private String brand;
	private String model;
	private int MAX_SPEED = 120;
	private int MAX_SPEED_REVERSE = 20;
	private String fuel;
	private int speedometer = 0;
	private int tachometer = 0;
	private Gear gear = Gear.N;
	private int steeringWheelAngle = 0;

	private String garage;
	private int totalDistance;
	private int distance;

	public Car(String piloto, String brand, String model, String fuel) {
		this.piloto = piloto;
		this.brand = brand;
		this.model = model;
		this.fuel = fuel;

	}

	/**
	 * Enciende el coche, cambiando su marcha y poniendo la velocidad a 0 y el
	 * cuentarevoluciones en 1000. Si ya está encendido avisa al usuario. 
	 * 
	 */
	
	
	
	public void start() {
		if (this.tachometer == 0) {
			this.tachometer = 1000;
			System.out.println("Vehiculo acendido");
			this.gear = Gear.D;
		} else {
			System.out.println("O vehiculo xa esta acendido");
		}
	}

	/**
	 *Apaga el coche, siempre y cuando su velocidad y su cuentarevoluciones estén en 0
	 * 
	 */
	public void stop() {
		if (this.speedometer == 0) {
			this.tachometer = 0;
			this.gear = Gear.N;
			System.out.println("Vehiculo apagado");

		} else {
			System.out.println("Non se pode apagar o vehiculo, primero ten que estar detido");
		}
	}

	
	/**
	 *Frena el coche un valor aleatorio entre 10 y20 km. El coche no puede bajar de 0
	 * 
	 */
	public void brake() {	
		Random random = new Random();
		int frenazo = (random.nextInt(21 - 10) + 10);
		this.speedometer -= frenazo;
		if (this.speedometer <= 0) {
			this.speedometer = 0;
			this.tachometer = 1000;
		} else {
			this.tachometer -= frenazo * 10;
		}
	}

	/**
	 *Frena del todo el coche, poniendo su velocidad a 0. Si el coche iba muy rápido dará una 
	 *o varias vueltas de campana
	 * 
	 */
	
	public void handBrake() {
		if (this.speedometer > 50) {
			System.out.println("VUELTA DE CAMPANA");
		}
		if (this.speedometer > 80) {
			System.out.println("OTRA VUELTA DE CAMPANA");
		}
		if (this.speedometer > 100) {
			System.out.println("TRIPLE VUELTA DE CAMPANA");
		}
		this.speedometer = 0;
		this.tachometer = 1000;
	}
	
	/**
	 *Frena progresivamente el coche y lo apaga
	 * 
	 */
	
	public void brakeStop() {
		for (int i = 0; i < 20; i++) {
			brake();
		}
		stop();
		distance = 0;
	}

	/**
	 *Modifica la velocidad del vehículo. Hay un 75% de posibilidades de que acelere
	 *y un 25%de que frene. En cada caso, llama al método correspondiente.
	 * 
	 */
	
	public void drive() {
		Random random = new Random();
		int val = random.nextInt(4) + 1;
		if (val == 1) {
			brake();
		} else {
			accelerate();
		}
	}
	
	/**
	 *Acelera el coche un valor aleatorio  entre 10 y 50 si el coche va hacia adelante. 
	 *Si está marcha atrás acelera un valor aleatorio entre 3 y 10
	 * 
	 */

	public void accelerate() {
		int aceleron;
		Random random = new Random();
		switch (gear) {
		case D:
			aceleron = ((random.nextInt(5 - 1) + 1) * 10);
			if (this.speedometer + aceleron > MAX_SPEED) {
				this.speedometer = MAX_SPEED;
				this.tachometer = 2200;
			} else {
				this.speedometer += aceleron;
				this.tachometer += aceleron * 10;
			}
			break;

		case R:
			aceleron = (random.nextInt(10 - 5) + 3);
			this.speedometer += aceleron;
			if (this.speedometer >= MAX_SPEED_REVERSE) {
				this.speedometer = MAX_SPEED_REVERSE;
				this.tachometer = 1200;
			} else {
				this.tachometer += aceleron * 10;
			}
			break;
		case N:
			System.out.println("Debe encender el vehículo");
			break;
		}

	}

	/**
	 *Cambia la dirección del coche
	 * 
	 */
	

	public void reverse() {
		if (this.speedometer == 0) {
			switch (gear) {
			case D:
				gear = Gear.R;
				break;
			case R:
				gear = Gear.D;
				break;
			case N:
				System.out.println("Primero debe encender el vehículo");
				break;
			}
		} else {
			System.out.println("VUELTA DE CAMPANA");
		}
	}

	/**
	 *Gira el coche 
	 * 
	 * @param angle
	 * 		Los ángulos que queremos girar la rueda
	 * @param derecha
	 * 		La dirección en la que queremos girar. Si es True gira a la derecha, si es False a la izquierda
	 */
	
	public void turnSteeringWheel(int angle, boolean derecha) {
		if (derecha) {
			this.steeringWheelAngle += angle;
			if (this.steeringWheelAngle > 90) {
				this.steeringWheelAngle = 90;
			}
		} else {
			this.steeringWheelAngle -= angle;
			if (this.steeringWheelAngle < -90) {
				this.steeringWheelAngle = -90;
			}
		}

	}

	/**
	 *Devuelve el ángulo de las ruedas
	 * 
	 * @return El ángulo de las ruedas
	 */
	
	public String showSteeringWheelDetail() {
		if (this.steeringWheelAngle > 0) {
			return "El ángulo de las ruedas es de " + steeringWheelAngle + " grados a la derecha";
		} else {
			return "El ángulo de las ruedas es de " + steeringWheelAngle * -1 + " grados a la izquierda";
		}
	}

	public String showDetails() {
		return "Car [brand=" + brand + ", model=" + model + ", maxSpeed=" + MAX_SPEED + ", fuel=" + fuel
				+ ", speedometer=" + speedometer + ", tachometer=" + tachometer + ", Gear=" + gear
				+ ", steeringWheelAngle=" + steeringWheelAngle + "]";

	}

	/**
	 *Establece la base para comparar dos instancias de la clase en la variable distancia
	 * 
	 * @param c
	 * 		El coche con el que queremos compararlo
	 * @return boolean
	 */
	
	@Override
	public int compareTo(Car c) {
		if (this.distance > c.distance) {
			return -1;
		} else if (this.distance < c.distance) {
			return 1;
		} else {
			return 0;
		}

	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getSpeedometer() {
		return speedometer;
	}

	public void setSpeedometer(int speedometer) {
		this.speedometer = speedometer;
	}

	public int getTachometer() {
		return tachometer;
	}

	public void setTachometer(int tachometer) {
		this.tachometer = tachometer;
	}

	public Gear getGear() {
		return gear;
	}

	public void setGear(Gear gear) {
		this.gear = gear;
	}

	public int getSteeringWheelAngle() {
		return steeringWheelAngle;
	}

	public void setSteeringWheelAngle(int steeringWheelAngle) {
		this.steeringWheelAngle = steeringWheelAngle;
	}

	public String getGarage() {
		return garage;
	}

	public void setGarage(String garage) {
		this.garage = garage;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getMAX_SPEED_REVERSE() {
		return MAX_SPEED_REVERSE;
	}

	public int getMAX_SPEED() {
		return MAX_SPEED;
	}

	public int getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(int totalDistance) {
		this.totalDistance = totalDistance;
	}

	public String toString() {
		return "Piloto: " + this.piloto + "     Garage: " + this.garage;
	}

}