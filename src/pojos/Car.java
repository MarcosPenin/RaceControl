package pojos;

import java.util.Random;

public class Car implements Comparable<Car> {

	public static enum Gear {
		N, D, R
	};

	private String piloto;
	private String brand;
	private String model;
	private final int MAX_SPEED = 120;
	private final int MAX_SPEED_REVERSE = 20;
	private String fuel;
	private int speedometer = 0;
	private int tachometer = 0;
	private Gear gear = Gear.N;
	private int steeringWheelAngle = 0;

	private Garage garage;
	private int totalDistance;
	private int distance;

	public Car(String piloto) {
		this.piloto = piloto;
	}

	public Car(String piloto, String brand, String model, String fuel) {
		this.piloto = piloto;
		this.brand = brand;
		this.model = model;
		this.fuel = fuel;

	}

	public void start() {
		if (this.tachometer == 0) {
			this.tachometer = 1000;
			System.out.println("Vehiculo acendido");
			this.gear = Gear.D;
		} else {
			System.out.println("O vehiculo xa esta acendido");
		}
	}

	public void stop() {
		if (this.speedometer == 0) {
			this.tachometer = 0;
			this.gear = Gear.N;
			System.out.println("Vehiculo apagado");

		} else {
			System.out.println("Non se pode apagar o vehiculo, primero ten que estar detido");
		}
	}

	//Frena y apaga los coches
	public void brakeStop() {
		for (int i = 0; i < 20; i++) {
			brake();
		}
		stop();
		distance = 0;
	}

	//Calcula un 75% de posibilidades de aceleración y un 25% de frenar y llama al método correspondiendte
	public void drive() {
		Random random = new Random();
		int val = random.nextInt(4) + 1;
		if (val == 1) {
			brake();
		} else {
			accelerate();
		}
	}

	public void accelerate() {
		Random random = new Random();
		int aceleron;

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

	public int getMaxSpeed() {
		return MAX_SPEED;
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

	public Garage getGarage() {
		return garage;
	}

	public void setGarage(Garage garage) {
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
		return "Piloto: " + this.piloto + "     Garage: " + this.garage.getName();
	}

}