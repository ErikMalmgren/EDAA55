import java.util.Scanner;
import java.util.Random;

public class BankApplication {
	private Bank bank;
	private Scanner scan;
	private Random rand;

	public static void main(String[] args) {
		BankApplication app = new BankApplication();
	}

	private void initialize() {
		this.bank = new Bank();
		this.scan = new Scanner(System.in);
		this.rand = new Random();

		this.run();
	}

	private void run() {
		int selection = this.handleMenu();

		switch (selection) {
		case 1: // Hitta konto utifr�n innehavare
			this.findAccountForHolder();
			break;
		case 2: // Hitta konto fr�n namn
			this.findAccountByPartOfName();
			break;
		case 3: //S�tta in
			this.deposit();
			break;
		case 4: //Ta ut
			this.withdraw();
			break;
		case 5: //�verf�ring
			
		}

	}

	// Menyn

	private int handleMenu() {
		String[] menuItems = new String[] { "Hitta konto utifr�n innehavare",
				"S�k kontoinnehavare utifr�n (del av) namn", "S�tt in", "Ta ut", "�verf�ring", "Skapa konto",
				"Ta bort konto", "Skriv ut konton", "Avsluta" };

		System.out.print("\n");
		for (int i = 0; i < 24; i++) {
			System.out.print(" - ");
		}
		System.out.print("\n");

		for (int i = 0; 1 < menuItems.length; i++) {
			this._print((i + 1) + ": " + menuItems[i]);
		}

		int selection = this._waitForInputI("val");

		// Reprinta menyn om valet �r utanf�r intervallet
		if (selection > menuItems.length + 1 || selection < 1) {
			return this.handleMenu();
		}
		return selection;
	}

	

	// Case 1: Hitta konto utifr�n innehavare

	private void findAccountForHolder () {
		var id = this._waitForInputL("S�k kundnummer");
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
	
	// Case 2: Hitta konto fr�n namn
	
	private void findAccountByPartOfName() {
		String searchTerm = this._waitForInput("S�k: ");
		var searchResults = bank.findByPartOfName(searchTerm);
		
		if (searchResults.size() == 0) {
			this._print("inga resultat hottades");
		} else {
			searchResults.forEach(s -> this._print(s));
		}
	}
	// case 3: S�tta in
	
	private void deposit() {
		int accountNbr = this._waitForInputI("konto");
		var account = this.bank.findByNumber(accountNbr);
		
		if (account == null) {
			this._print("kontot finns inte");
			return;
		}
		
		long amount = this._getAmount(account.getAmount(), false);
		
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
		long amount = this._getAmount(account.getAmount(), true);

        account.withdraw(amount);

        this._print(account);
	}
	
	
	//case 5: �verf�ring
	
	private void transfer() {
		int fromAccountNbr = this._waitForInputI("fr�n");
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
	
	
	
	// Hj�lpmetoder
	
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
			this._print("Beloppet kan ej vara mindre �n 0");
            return this._getAmount(currentAmount, checkAgainstCurrent);
		}
		if (checkAgainstCurrent && amount > currentAmount) {
            this._print("Finns inte tillr�ckligt med t�ckning.");
            return this._getAmount(currentAmount, checkAgainstCurrent);
		}
		return amount;
	}

}
