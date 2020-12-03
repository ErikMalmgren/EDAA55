import java.util.Scanner;

public class Main {

	private SmallGame s = new SmallGame();

	public static void main(String[] args) {
		Main m = new Main();
		m.spel();
	}

	public void spel() {
		System.out.println("Spelet går ut på att gissa ett slumpat tal mellan två andra tal");
		System.out.println("Skriv in två tal");
		Scanner scan = new Scanner(System.in);
		int nbr1 = scan.nextInt();
		int nbr2 = scan.nextInt();

		if (nbr2 < nbr1) {
			int fix = nbr1;
			nbr1 = nbr2;
			nbr2 = fix;
		}
		int slumpTal = s.getRand(nbr1, nbr2);
		
		System.out.println("Hur många gissnings försök?");
		int giss = scan.nextInt();

		// System.out.println(slumpTal);

		long start = System.currentTimeMillis();
		for (int i = 0; i < giss; i++) {

			System.out.println(giss - i + " Försök kvar");
			int nbr3 = scan.nextInt();

			if (nbr3 == slumpTal) {
				i = giss;
				System.out.println("Grattis du gissade rätt");

			} else if (nbr3 < slumpTal) {
				System.out.println("Din gissing är för låg");

			} else if (nbr3 > slumpTal) {
				System.out.println("Din gissning är för hög");

			}
			if (i == giss - 1) {
				System.out.println("Du klarade tyvärr inte det");
			}

		}

		long end = System.currentTimeMillis();
		long elapsed = end - start;
		double elapsedDouble = s.toSecDouble(elapsed);
		
		System.out.println("Det tog " + elapsedDouble + "s");
	}
}
