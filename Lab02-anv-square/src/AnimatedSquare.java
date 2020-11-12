import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class AnimatedSquare {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "PrintClicks");
		w.waitForMouseClick();
		int x = w.getClickedX();
		int y = w.getClickedY();
		Square sq = new Square(x, y, 100);
		sq.draw(w);
		while (true) {
			w.waitForMouseClick();
			int newX = w.getClickedX();
			int newY = w.getClickedY();
			int xDist = newX - x;
			int yDist = newY - y;
			for (int i = 0; i < 10; i++) {
				sq.erase(w);
				sq.move(xDist / 10, yDist / 10);
				sq.draw(w);
				SimpleWindow.delay(10);
			}
			x = newX;
			y = newY;

		}
	}
}
