import java.util.Scanner;
import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeSolver {
	public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
		Maze m = new Maze(scan.nextInt());
		SimpleWindow w = new SimpleWindow(600, 600, "MazeSolver");
		MazeWalker t = new MazeWalker(w, m.getXEntry(), m.getYEntry(), m);

		m.draw(w);
		t.walk();
	}
}