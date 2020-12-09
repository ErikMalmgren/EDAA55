import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	private boolean isPenDown;
	private double v = 90;
	private double x;
	private double y;
	SimpleWindow w;

	/**
	 * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
	 * sköldpaddan i punkten x, y med pennan lyft och huvudet pekande rakt uppåt i
	 * fönstret (i negativ y-riktning).
	 */
	public Turtle(SimpleWindow w, int x, int y) {
		this.w = w;
		this.x = x;
		this.y = y;

	}

	/** Sänker pennan. */
	public void penDown() {
		isPenDown = true;
	}

	/** Lyfter pennan. */
	public void penUp() {
		isPenDown = false;
	}

	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		if (isPenDown) {
			w.moveTo((int) x, (int) y);
			x = x + n * Math.cos(Math.toRadians(v));
			y = y - n * Math.sin(Math.toRadians(v));
			w.lineTo((int) Math.round(x), (int) Math.round(y));
		} else {
			x = x + n * Math.cos(Math.toRadians(v));
			y = y - n * Math.sin(Math.toRadians(v));
			w.moveTo((int) Math.round(x), (int) Math.round(y));
		}

	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		v = v + beta;

	}

	/**
	 * Går till punkten newX, newY utan att rita. Pennans läge (sänkt eller lyft)
	 * och huvudets riktning påverkas inte.
	 */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
		w.moveTo(newX, newY);

	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		v = 90;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) x;
	}

	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) y;
	}

	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
	public int getDirection() {
		return (int) v;
	}
}
