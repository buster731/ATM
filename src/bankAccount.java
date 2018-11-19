public class bankAccount{
	
	private static long generatedAccountNumber = 100000001L;
	
	private long accountNumber;
	private double balance;
	private accountHolder acctHolder;
	
	public bankAccount(double balance, accountHolder accountHolder) {
		this.accountNumber = bankAccount.generatedAccountNumber++;
		this.balance = balance;
		this.acctHolder = accountHolder;
	}
	
	public double getBalance() {
		return balance;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public accountHolder getAcctHolder() {
		return acctHolder;
	}
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setAcctHolder(accountHolder acctHolder) {
		this.acctHolder = acctHolder;
	}
	
	public int deposit(double depositVal) {
		if(depositVal < -1) {
			return 0;
		}
		else {
			this.balance = balance + depositVal;
			return 1;
		}
	}
	
	public int withdraw(double withdrawVal) {
		if(withdrawVal < -1) {
			return 0;
		}
		else if(withdrawVal > balance) {
			return -1;
		}
		else {
			this.balance = balance - withdrawVal;
			return 1;
		}
	}
}