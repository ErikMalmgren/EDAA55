import java.util.Random;
import se.lth.cs.pt.window.SimpleWindow;

public class TvåTusenSteg {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawSquare");
		Turtle t1 = new Turtle(w, 250, 250);
		Turtle t2 = new Turtle(w, 350, 350);
		Random rand = new Random();
		t1.penDown();
		t2.penDown();
		double dist = 60;

		while (dist >= 50) {
			int x1 = t1.getX();
			int x2 = t2.getX();
			int y1 = t1.getY();
			int y2 = t2.getY();
			dist = Math.sqrt(((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));

			t1.forward(rand.nextInt(9) + 1);
			t1.left(rand.nextInt(360) - 180);
			t2.forward(rand.nextInt(9) + 1);
			t2.left(rand.nextInt(360) - 180);

			SimpleWindow.delay(10);
		}

	}
}