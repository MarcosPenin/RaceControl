package pojos;

import java.util.ArrayList;

public class EliminationRace extends Race {

	private int minuts;
	

	public EliminationRace(String raceName, int minuts, boolean onlyOneGarage) {
		super(raceName,onlyOneGarage);
		this.minuts = minuts;
	}

	public EliminationRace(String raceName, ArrayList<Garage> garages, int minuts, boolean onlyOneGarage) {
		super(raceName, garages, onlyOneGarage);
		this.minuts = minuts;
	}

	public int getMinuts() {
		return minuts;
	}

	public void getMinuts(int minuts) {
		this.minuts = minuts;
	}

}
