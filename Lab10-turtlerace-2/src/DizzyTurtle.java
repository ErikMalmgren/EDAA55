
public class DizzyTurtle extends RaceTurtle {
	private int dizziness;

	public DizzyTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		this.dizziness = this.randomNumber(1, 5);
	}

	public void raceStep() {
		left(this.randomBool() ? dizziness : -dizziness);
		super.raceStep();
	}

	public String toString() {
		return super.toString() + " - DizzyTurtle (Yrsel:" + this.dizziness + ")";
	}
}
