import java.util.Scanner;
import java.util.Random;

public class BankApplication {
	private Bank bank;
	private Scanner scan;
	private Random rand;

	public static void main(String[] args) {
		BankApplication app = new BankApplication();
		app.initialize();
	}

	private void initialize() {
		this.bank = new Bank();
		this.scan = new Scanner(System.in);
		this.rand = new Random();
		this.seedAccounts();
		this.run();
		
		this.scan.close();
	}

	private void run() {
		int selection = this.handleMenu();

		switch (selection) {
		case 1: // Hitta konto utifrån innehavare
			this.findAccountForHolder();
			break;
		case 2: // Hitta konto från namn
			this.findAccountByPartOfName();
			break;
		case 3: //Sätta in
			this.deposit();
			break;
		case 4: //Ta ut
			this.withdraw();
			break;
		case 5: //Överföring
			this.transfer();
			break;
		case 6: //Skapa nytt konto
			this.createAccount();
			break;
		case 7: //Ta bort konto
			this.deleteAccount();
			break;
		case 8: //Printa alla konton
			this.printAccounts();
			break;
		case 9: //Avsluta
			this._print("Hejdå \n");
			return;
		}
		this.run();

	}

	// Menyn

	private int handleMenu() {
		String[] menuItems = new String[] { "Hitta konto utifrån innehavare",
				"Sök kontoinnehavare utifrån (del av) namn", "Sätt in", "Ta ut", "Överföring", "Skapa konto",
				"Ta bort konto", "Skriv ut konton", "Avsluta" };

		System.out.print("\n");
		for (int i = 0; i < 24; i++) {
			System.out.print(" - ");
		}
		System.out.print("\n");

		for (int i = 0; i < menuItems.length; i++) {
            this._print((i + 1) + ": " + menuItems[i]);
        }

		int selection = this._waitForInputI("val");

		// Reprinta menyn om valet är utanför intervallet
		if (selection > menuItems.length + 1 || selection < 1) {
			return this.handleMenu();
		}
		return selection;
	}

	

	// Case 1: Hitta konto utifrån innehavare

	private void findAccountForHolder () {
		var id = this._waitForInputL("Sök kundnummer");
		var found = this.bank.findAccountsForHolder(id);
		var length = found.size();
		
		if (length > 0) {
			for (int i = 0; i < length; i++) {
				var acc = found.get(i);
				this._print(acc);
			}
		} else {
			this._print("Inga resultat hittades");
		}
	}
	
	// Case 2: Hitta konto från namn
	
	private void findAccountByPartOfName() {
		String searchTerm = this._waitForInput("Sök: ");
		var searchResults = bank.findByPartOfName(searchTerm);
		
		if (searchResults.size() == 0) {
			this._print("inga resultat hottades");
		} else {
			searchResults.forEach(s -> this._print(s));
		}
	}
	// case 3: Sätta in
	
	private void deposit() {
		int accountNbr = this._waitForInputI("konto");
		var account = this.bank.findByNumber(accountNbr);
		
		if (account == null) {
			this._print("kontot finns inte");
			return;
		}
		
		double amount = this._getAmount(account.getAmount(), false);
		
		account.deposit(amount);
		this._print(account);
	}
	
	//case 4: Ta ut
	
	private void withdraw() {
		int accountNbr = this._waitForInputI("konto");
		var account = this.bank.findByNumber(accountNbr);
		
		if ( account == null) {
			this._print("Kontot finns inte");
			return;
		}
		double amount = this._getAmount(account.getAmount(), true);

        account.withdraw(amount);

        this._print(account);
	}
	
	
	//case 5: Överföring
	
	private void transfer() {
		int fromAccountNbr = this._waitForInputI("från");
        int toAccountNbr = this._waitForInputI("till");
        
        var fromAccount = this.bank.findByNumber(fromAccountNbr);

        if (fromAccount == null) {
            this._print("Kontot finns inte");
            return;
        }
        long amount = this._getAmount(fromAccount.getAmount(), true);

        fromAccount.withdraw(amount);
        
        var toAccount = this.bank.findByNumber(toAccountNbr);

        if (toAccount == null) {
            this._print("Kontot finns inte");
            return;
        }

        toAccount.deposit(amount);

        this._print(fromAccount);
        this._print(toAccount);
	}
	
	
	//case 6: Skapa nytt konto
	
	private void createAccount() {
		var name = this._waitForInput("namn");

        long id;
        try {
            id = this._waitForInputL("id");

        } catch (Exception e) {
            // Assign random value
            id = this.rand.nextInt(Integer.MAX_VALUE);
            this._print("Kontonummer är ej korrekt, ett slumpmässigt har genererats: " + id);
        }

        var accountNr = this.bank.addAccount(name, id);
        this._print("konto skapat: " + accountNr);
	}
	
	//case 7: Ta bort konto
	
	private void deleteAccount() {
        var accountNr = this._waitForInputI("kontonummer");

        if (!this.bank.removeAccount(accountNr)) {
            this._print("Felaktigt kontonummer!");
        } else {
            this._print("Kontot har tagits bort.");
        }

    }
	
	//case 8: Printa alla konton
	
	private void printAccounts() {
        var accs = bank.getAllAccounts();

        if (accs.size() < 1) {
            this._print("Det finns inga konton");
            return;
        }
        accs.forEach(acc -> this._print(acc));
    }
	
	// Hjälpmetoder
	
	private void _print(Object s) {
		System.out.println(s);
	}
	
	private String _waitForInput(String label) {
		if (label !="") {
			System.out.print(label + ": ");
		}
		var input = scan.nextLine();
		return input;
	}

	private int _waitForInputI(String label) {
		if (label != "") {
			System.out.print(label + ": ");
		}
		int input;

		try {
			input = scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			return this._waitForInputI(label);
		}
		scan.nextLine();
		return input;

	}

	private long _waitForInputL(String label) {
		if (label != "") {
			System.out.print(label + ": ");
		}

		long input;

		try {
			input = scan.nextLong();
		} catch (Exception e) {
			input = -1;
		}
		scan.nextLine();
		return input;
	}
	
	private long _getAmount(double currentAmount, Boolean checkAgainstCurrent) {
		long amount = this._waitForInputL("Belopp");
		if (amount < 0) {
			this._print("Beloppet kan ej vara mindre än 0");
            return this._getAmount(currentAmount, checkAgainstCurrent);
		}
		if (checkAgainstCurrent && amount > currentAmount) {
            this._print("Finns inte tillräckligt med täckning.");
            return this._getAmount(currentAmount, checkAgainstCurrent);
		}
		return amount;
	}
	
	//Testkonton
	
	private void seedAccounts() {
        var firstnames = new String[] { "Lucas", "Liam", "William", "Elias", "Noah", "Hugo", "Oliver", "Oscar", "Adam",
                "Matteo", };
        var lastnames = new String[] { "Andersson", "Johansson", "Karlsson", "Nilsson", "Eriksson", "Larsson", "Olsson",
                "Persson", "Svensson", };

        for (int i = 0; i < 12; i++) {
            this.bank.addAccount(
                    firstnames[rand.nextInt(firstnames.length)] + " " + lastnames[rand.nextInt(lastnames.length)],
                    rand.nextInt(100));
        }
    }
}
