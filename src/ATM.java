import java.util.Scanner;

public class ATM{
	Scanner in = new Scanner(System.in);
	private bankAccount account;
	
	public static void main(String[] args) {
		ATM atm = new ATM(new bankAccount(2500.00, new accountHolder(1234, "Shane Schwartz", "July 31, 2001", "123 Street Way")));
		atm.menu();
	}
	
	public ATM(bankAccount account) {
		this.account = account;
	}
	
	public bankAccount getAccount() {
		return account;
	}
	public void setAccount(bankAccount account) {
		this.account = account;
	}
	
	public void menu() {
		System.out.println("What is your account number: \n");
		account.setAccountNumber(in.nextLong());
		System.out.println("Please input your pin to continue: \n");
		int pinCheck = in.nextInt();
		while(account.getAcctHolder().getPin() != pinCheck) {
			System.out.println("Incorrect Pin. Please try again. \n");
			System.out.println("Please input your pin to continue: \n");
			pinCheck = in.nextInt();
		}
		int escape = 0;
		while(escape != -1) {
			System.out.println("Available actions include: \n\t- show balance\n\t- deposit\n\t- withdraw\n\t- exit");
			System.out.println("Please select an option now: \n");
			String action = in.nextLine().toLowerCase();
			
			switch(action) {
				case "show balance":
					System.out.println("The balance for account " + account.getAccountNumber() + " is currently: " + account.getBalance() + "\n");
					break;
				case "deposit":
					double depositVal = -1;
					while(depositVal != 0) {
						System.out.println("How much would you like to deposit? enter 0 to cancel\n");
						depositVal = in.nextDouble();
						if (depositVal <= -1) {
							System.out.println("You cannot deposit negative money. Did you mean \'withdraw\'? Please enter a valid deposit to continue or enter 0 to exit \n");
							depositVal = in.nextDouble();
						}
						else {
						account.deposit(depositVal);
						System.out.println("Deposit successful. Your new balance is " + account.getBalance() + ".\n");
						System.out.println("To make another deposit, please enter another value. To exit the deposit window please enter 0");
						depositVal = in.nextDouble();
						}
					}
					if(depositVal == 0) {
						escape = -1;
						break;
					}
				case "withdraw":
					double withdrawVal = -1;
					while(withdrawVal != 0) {
						System.out.println("Your current balance is " + account.getBalance() + ". How much would you like to withdraw? or enter 0 to exit.\n");
						withdrawVal = in.nextDouble();
						if(withdrawVal > account.getBalance()) {
							System.out.println("You cannot withdraw more money than is in your account. Please enter a valid withdraw value or enter 0 to cancel. \n");
						}
						else {
							account.withdraw(withdrawVal);
							System.out.println("Withdraw successful. Your new balance is " + account.getBalance() + ".\n");
							System.out.println("To make another withdrawl, please enter another value. To exit the withdrawl window please enter 0\"\n"); 
							depositVal = in.nextDouble();
						}
					}
					if(withdrawVal == 0) {
						escape = -1;
						break;
					}
					
					break;
				case "exit":
					System.out.println("Thank you. Have a nice day! \n");
					escape = -1;
					break;
				default:
					System.out.println("Invalid option. Please try again \n");
					break;
			}
		}
	}
	
}