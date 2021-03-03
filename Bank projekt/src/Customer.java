
public class Customer {

	private String name;
	private long idNr;
	private int customerNr;
	private static int nextCustomerNr = 100;

	/**
	 * Skapar en kund (kontoinnehavare) med namnet �name� och id-nummer �idNr�.
	 * Kunden tilldelas ocks� ett unikt kundnummer.
	 */

	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		this.customerNr = nextCustomerNr;
		nextCustomerNr++;
	}

	/** Tar reda p� kundens namn. */

	public String getName() {
		return this.name;
	}

	/** Tar reda p� kundens personnummer. */
	public long getIdNr() {
		return this.idNr;
	}

	/** Tar reda p� kundens kundnummer. */
	public int getCustomerNr() {
		return this.customerNr;
	}

	/** Returnerar en str�ngbeskrivning av kunden. */
	public String toString() {
		return this.name + ", id " + this.idNr + ", kundnr " + this.getCustomerNr();
	}
}
