
public class MoleTurtle extends RaceTurtle {

	public MoleTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
	}

	public void raceStep() {
		if (this.randomBool()) {
			penUp();
		} else {
			penDown();
		}
		super.raceStep();
	}

	public String toString() {
		return super.toString() + " - MoleTurtle";
	}
}
