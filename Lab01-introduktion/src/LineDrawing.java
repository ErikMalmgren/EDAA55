import se.lth.cs.pt.window.SimpleWindow;

public class LineDrawing {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "LineDrawing");
		w.moveTo(0, 0);
		while (true) {
			w.waitForMouseClick(); 		// Väntar på musklick
			int x = w.getClickedX(); 	// x koordinat
			int y = w.getClickedY(); 	// y koordinat
			w.lineTo(x, y);				// Linje till (x,y)
		}
	}
}
