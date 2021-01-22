import java.util.Random;
import se.lth.cs.pt.window.SimpleWindow;

public class TusenSteg {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawSquare");
		Turtle t = new Turtle(w, 300, 300);
		Random rand = new Random();
		t.penDown();
		for (int i = 0; i < 1000; i++) {
			t.forward(rand.nextInt(9) + 1);
			t.left(rand.nextInt(360) - 180);
		}
	}
}