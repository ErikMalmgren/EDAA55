import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> accounts;

	/** Skapar en ny bank utan konton. */
	public Bank() {
		this.accounts = new ArrayList<BankAccount>();
	}

	/**
	 * Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare med de
	 * givna uppgifterna ska inte en ny Customer skapas, utan istället den
	 * befintliga användas. Det nya kontonumret returneras.
	 */
	public int addAccount(String holderName, long idNr) {
		Customer holder = findHolder(idNr);
		if (holder == null) {
			holder = new Customer(holderName, idNr);
		}
		if (!holder.getName().equals(holderName)) {
			return -1;  // Får bara finnas en kund med id nr och namn
			}

		BankAccount account = new BankAccount(holder);
		accounts.add(account);
		return account.getAccountNumber();
		
	}

	/**
	 * Returnerar den kontoinnehavaren som har det givna id-numret, eller null om
	 * ingen sådan finns.
	 */

	public Customer findHolder(long idNr) {
		for (BankAccount acc : accounts) {
			if (acc.getHolder().getIdNr() == idNr) {
				return acc.getHolder();
			}
		}
		return null;
	}
}
