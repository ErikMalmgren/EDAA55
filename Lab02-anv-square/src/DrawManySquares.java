import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class DrawManySquares {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "PrintClicks");
	
		while (true) {
			w.waitForMouseClick();
			w.moveTo(w.getClickedX(), w.getClickedY());
			Square sq = new Square(w.getClickedX(), w.getClickedY(), 100);
			w.clear();
			sq.draw(w);
		}
	}
}

