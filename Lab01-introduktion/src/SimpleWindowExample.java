import se.lth.cs.pt.window.SimpleWindow;
import java.awt.Color;

public class SimpleWindowExample {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "Drawing Window");
		Color nyFärg = new Color(252, 12, 96);
		w.moveTo(100, 100);
		w.setLineWidth(5);
		w.setLineColor(nyFärg);
		w.lineTo(150, 100);
		w.lineTo(150, 150);
		w.setLineColor(Color.PINK);
		w.lineTo(100, 100);
		w.lineTo(50, 200);
	}
}