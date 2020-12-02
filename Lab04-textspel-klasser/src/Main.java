import java.util.Scanner;

public class Main {

	private SmallGame s = new SmallGame();

	public static void main(String[] args) {
		Main m = new Main();
		m.spel();
	}

	public void spel() {
		System.out.println("Skriv in två siffror");
		Scanner scan = new Scanner(System.in);
		int nbr1 = scan.nextInt();
		int nbr2 = scan.nextInt();
		System.out.println("Hur många gissnings försök?");
		int diff = scan.nextInt();
		int slumpTal = s.getRand(nbr1, nbr2);
		// System.out.println(slumpTal);
		for (int i = 0; i < diff; i++) {

			System.out.println(diff - i + " Försök kvar");
			int nbr3 = scan.nextInt();

			if (nbr3 == slumpTal) {
				i = diff;
				System.out.println("Grattis du gissade rätt");

			} else if (nbr3 < slumpTal) {
				System.out.println("Din gissing är för låg");

			} else if (nbr3 > slumpTal) {
				System.out.println("Din gissning är för hög");

			}

		}
		System.out.println("Du klarade tyvärr inte det");
	}
}
