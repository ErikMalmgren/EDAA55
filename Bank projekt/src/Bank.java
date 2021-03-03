public class Bank {
	private String name;
	private long idNr;
	private int customerNr;
	private static int nextCustomerNr = 100;
	
	// Skapar ett konto med "name" och "idNr" samt tilldelas ett unikt kundnummer

	public Customer(String name, long idNr) {
        this.name = name;
        this.idNr = idNr;
        this.customerNr = nextCustomerNr;
        nextCustomerNr++;
    }

	public String getName() {
		return this.name;
	}

	public long getIdNr() {
		return this.idNr;
	}

	public int getCustomerNr() {
		return this.customerNr;
	}

	public String toString() {
		return this.name + ", id " + this.idNr + ", kundnr " + this.getCustomerNr();
	}
}
