package persistencia;

import java.util.ArrayList;
import java.util.List;

import pojos.Garage;
import pojos.Tournament;


/**
 * Contenedor para los datos almacenados por la aplicación
 * @author github.com/MarcosPenin
 *
 */



public class Almacen {

	
	
	private ArrayList<Tournament> tournaments = new ArrayList<>();
	private ArrayList<Tournament> actualTournaments = new ArrayList<>();
	private ArrayList<Garage> garages = new ArrayList<>();



	public List <Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(ArrayList<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public List <Tournament> getActualTournaments() {
		return actualTournaments;
	}

	public void setActualTournaments(ArrayList<Tournament> actualTournaments) {
		this.actualTournaments = actualTournaments;
	}

	public List <Garage> getGarages() {
		return garages;
	}

	public void setGarages(ArrayList<Garage> garages) {
		this.garages = garages;
	}

	public void addGarage(Garage garage) {
		garages.add(garage);
	}

	public  void addTournament(Tournament tournament) {
		tournaments.add(tournament);
		actualTournaments.add(tournament);
	}

	

}
