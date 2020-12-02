import java.util.concurrent.ThreadLocalRandom;


public class SmallGame {

	
		public int getRand (int nbr1, int nbr2) {
		int randNum = ThreadLocalRandom.current().nextInt(nbr1, nbr2 +1);
		return randNum;
		
	}
	
	public double toSecDouble(long nbr1) {
		double nbr2 = (double) nbr1 / 1000 ;
		return nbr2;
	}
}
