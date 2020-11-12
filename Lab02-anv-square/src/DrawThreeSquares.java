import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class DrawThreeSquares {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
		Square sq = new Square(250, 250, 100);
		//Square kv = null;
		sq.draw(null);
		sq.move(50,-50);
		sq.draw(w);
		sq.move(-75,25);
		sq.draw(w);
	}
}
