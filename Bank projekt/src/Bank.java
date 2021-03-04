import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> accounts;

	/** Skapar en ny bank utan konton. */
	public Bank() {
		this.accounts = new ArrayList<BankAccount>();
	}

	/**
	 * �ppna ett nytt konto i banken. Om det redan finns en kontoinnehavare med de
	 * givna uppgifterna ska inte en ny Customer skapas, utan ist�llet den
	 * befintliga anv�ndas. Det nya kontonumret returneras.
	 */
	public int addAccount(String holderName, long idNr) {
		Customer holder = findHolder(idNr);
		if (holder == null) {
			holder = new Customer(holderName, idNr);
		}
		if (!holder.getName().equals(holderName)) {
			return -1; // F�r bara finnas en kund med id nr och namn
		}

		BankAccount account = new BankAccount(holder);
		accounts.add(account);
		return account.getAccountNumber();

	}

	/**
	 * Returnerar den kontoinnehavaren som har det givna id-numret, eller null om
	 * ingen s�dan finns.
	 */

	public Customer findHolder(long idNr) {
		for (BankAccount acc : accounts) {
			if (acc.getHolder().getIdNr() == idNr) {
				return acc.getHolder();
			}
		}
		return null;
	}

	/**
	 * Tar bort konto med nummer �number� fr�n banken. Returnerar true om kontot
	 * fanns (och kunde tas bort), annars false.
	 */
	public boolean removeAccount(int number) {
		BankAccount accountToRemove = null;
		for (BankAccount acc : accounts) {
			if (acc.getAccountNumber() == number) {
				accountToRemove = acc;
			}
		}
		accounts.remove(accountToRemove);
		return accountToRemove != null;
	}

	/**
	 * Returnerar en lista inneh�llande samtliga bankkonton i banken. Listan �r
	 * sorterad p� kontoinnehavarnas namn.
	 */
	public ArrayList<BankAccount> getAllAccounts() {
		if (this.accounts.size() < 1) {
			return this.accounts;
		}

		ArrayList<BankAccount> sorted = new ArrayList<BankAccount>();

		for (BankAccount a : this.accounts) {
			sorted.add(a);
		}

		for (int i = 0; i < sorted.size(); i++) {
			for (int j = i + 1; j < sorted.size(); j++) {
				BankAccount a1 = sorted.get(i);
				BankAccount a2 = sorted.get(j);

				// J�mf�r namnen och bytar position om det beh�vs
				if (a1.getHolder().getName().compareToIgnoreCase(a2.getHolder().getName()) > 0) {
					sorted.set(i, a2);
					sorted.set(j, a1);
				}
			}
		}

		return sorted;
	}

	/**
	 * S�ker upp och returnerar bankkontot med kontonummer �accountNumber�.
	 * Returnerar null om inget s�dant konto finns.
	 */
	public BankAccount findByNumber(int accountNumber) {
		for (BankAccount acc : accounts) {
			if (acc.getAccountNumber() == accountNumber) {
				return acc;
			}
		}
		return null;
	}

	/**
	 * S�ker upp alla bankkonton som innehas av kunden med id-nummer �idNr�. Kontona
	 * returneras i en lista. Kunderna antas ha unika id-nummer.
	 */

	public ArrayList<BankAccount> findAccountsForHolder(long idNr) {
		ArrayList<BankAccount> accs = new ArrayList<>();
		for (BankAccount acc : accounts) {
			if (acc.getHolder().getIdNr() == idNr) {
				accs.add(acc);
			}
		}
		return accs;
	}

	/**
	 * S�ker upp kunder utifr�n en s�kning p� namn eller del av namn. Alla personer
	 * vars namn inneh�ller str�ngen �namePart� inkluderas i resultatet, som
	 * returneras som en lista. Samma person kan f�rekomma flera g�nger i
	 * resultatet. S�kningen �r "case insensitive", det vill s�ga g�r ingen skillnad
	 * p� stora och sm� bokst�ver.
	 */

	public ArrayList<Customer> findByPartOfName(String namePart) {
		ArrayList<Customer> customers = new ArrayList<>();
		String name;
		long id;
		ArrayList<Long> ids = new ArrayList<Long>();
		for (BankAccount acc : accounts) {
			name = acc.getHolder().getName();
			id = acc.getHolder().getIdNr();

			// G�r alla bokst�ver till versaler
			if (name.toUpperCase().contains(namePart.toUpperCase()) && !ids.contains(id)) {
				ids.add(id);
				customers.add(acc.getHolder());
			}
		}
		return customers;

	}

}
