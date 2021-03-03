public class BankAccount {
	private Customer holder;
	private double balance;
	private int accountNr;
	private static int nextAccountNr = 1000;

	/**
	 * Skapar ett nytt bankkonto �t en innehavare med namn �holderName� och id
	 * �holderId�. Kontot tilldelas ett unikt kontonummer och inneh�ller
	 * inledningsvis 0 kr.
	 */

	public BankAccount(String holderName, long holderId) {
		this.holder = new Customer(holderName, holderId);
		this.balance = 0;
		accountNr = nextAccountNr;
		nextAccountNr++;
	}

	/**
	 * Skapar ett nytt bankkonto med innehavare �holder�. Kontot tilldelas ett unikt
	 * kontonummer och inneh�ller inledningsvis 0 kr.
	 */

	public BankAccount(Customer holder) {
		this.holder = holder;
		this.balance = 0;
		accountNr = nextAccountNr;
		nextAccountNr++;
	}

	/** Tar reda p� kontots innehavare. */

	public Customer getHolder() {
		return this.holder;
	}

	/** Tar reda p� det kontonummer som identifierar detta konto. */

	public int getAccountNumber() {
		return this.accountNr;
	}

	/** Tar reda p� hur mycket pengar som finns p� kontot. */

	public double getAmount() {
		return this.balance;
	}

	/** S�tter in beloppet �amount� p� kontot. */

	public void deposit(double amount) {
		this.balance += amount;
	}

	/**
	 * Tar ut beloppet �amount� fr�n kontot. Om kontot saknar t�ckning blir saldot
	 * negativt.
	 */

	public void withdraw(double amount) {
		this.balance -= amount;
	}

	/** Returnerar en str�ngrepresentation av bankkontot. */

	public String toString() {
		return String.format("konto %d (%s)", accountNr, holder);
	}
}
