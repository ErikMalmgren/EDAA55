import java.util.Random;

public class RaceTurtle extends Turtle {
	private int nbr;
	private Random rand;

	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		this.nbr = nbr;
		this.penDown();
		this.left(270);
		this.rand = new Random();

	}

	public void raceStep() {
		this.forward(this.randomNumber(1, 6));
	}

	public String toString() {
		return "Nummer " + this.nbr;
	}

	public boolean randomBool() {
		return this.rand.nextBoolean();
	}

	public int randomNumber(int from, int to) {
		return this.rand.nextInt(to - from) + from;
	}

}