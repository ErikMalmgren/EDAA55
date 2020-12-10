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
			dist = Math.sqrt(((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2))); 			//Math.hypo

			t1.forward(rand.nextInt(10) + 1); 		//Detta hade kunant göras till en metod
			t1.left(rand.nextInt(361) - 180);
			t2.forward(rand.nextInt(10) + 1);
			t2.left(rand.nextInt(361) - 180);

			SimpleWindow.delay(10);
		}

	}
}

/*
 * Attribut: Class variabler, finns i turtle 
 * Parameter: Det man matar in i
 * metoder 
 * Lokal variabel: Finns i metoder, ex jumpTo
 */