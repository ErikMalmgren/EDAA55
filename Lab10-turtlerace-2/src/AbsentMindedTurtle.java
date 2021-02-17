
public class AbsentMindedTurtle extends RaceTurtle {
	private int absence;

	public AbsentMindedTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		this.absence = this.randomNumber(0, 100);
	}

	public void raceStep() {
		if (this.randomNumber(0, 100) + 1 >= this.absence) {
			super.raceStep();
		}
	}

	public String toString() {
		return super.toString() + " - AbsentMindedTurtle (" + this.absence + "% frånvarande)";
	}
}
