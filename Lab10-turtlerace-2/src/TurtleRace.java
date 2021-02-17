import java.util.ArrayList;

public class TurtleRace {
	public static void main(String[] args) {
		ArrayList<RaceTurtle> turtles = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> finishedTurtles = new ArrayList<RaceTurtle>();
		RaceWindow w = new RaceWindow();

		for (int i = 0; i < 8; i++) {
			turtles.add(new RaceTurtle(w, i + 1));
		}

		// Sköldpaddorna går i nummerordning, om två olika sköldpaddor ska gå in på
		// samma gång kommer den med lägre nummer gå in först
		// Lösn: Slumpa vilken sklöldpadda som går först
		while (!turtles.isEmpty()) {
			for (int i = 0; i < turtles.size(); i++) {
				RaceTurtle t = turtles.get(i);
				t.raceStep();
				RaceWindow.delay(10);

				if (t.getX() >= RaceWindow.X_END_POS) {
					finishedTurtles.add(t);
					turtles.remove(t);
					i--;
				}

			}

		}

		for (int i = 0; i < 3; i++) {
			System.out.println("På plats " + (i + 1) + ": " + finishedTurtles.get(i));
		}
	}
}
