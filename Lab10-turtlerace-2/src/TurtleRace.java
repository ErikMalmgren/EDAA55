import java.util.ArrayList;
import java.util.Random;

public class TurtleRace {
	public static void main(String[] args) {
		ArrayList<RaceTurtle> turtles = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> finishedTurtles = new ArrayList<RaceTurtle>();
		RaceWindow w = new RaceWindow();
		Random rand = new Random();

		for (int i = 1; i < 9; i++) {
			RaceTurtle t;
			switch(rand.nextInt(3)) {
			case 0:
				t = new MoleTurtle(w, i);
				break;
			case 1:
				t = new AbsentMindedTurtle(w, i);
				break;
			case 2:
				t = new DizzyTurtle(w, i );
				break;
			default:
				t = new RaceTurtle(w, i);
			}
			
			turtles.add(t);
			System.out.println(t);
		}

		
		while (!turtles.isEmpty()) {
			for (int i = 0; i < turtles.size(); i++) {
				RaceTurtle t = turtles.get(i);
				t.raceStep();
				RaceWindow.delay(2);

				if (t.getX() >= RaceWindow.X_END_POS) {
					finishedTurtles.add(t);
					turtles.remove(t);
					i--;
				}

			}

		}
		System.out.println("\rLoppet är över");

		for (int i = 0; i < 3; i++) {
			System.out.println("På plats " + (i + 1) + ": " + finishedTurtles.get(i));
		}
	}
}
