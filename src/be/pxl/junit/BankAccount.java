package be.pxl.junit;

public class BankAccount {
	private String firstName;
	private String lastName;
	private double balance;

	public BankAccount(String firstName, String lastName, double balance) {
		setBalance(balance);
		setFirstName(firstName);
		setLastName(lastName);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		setBalance(getBalance()+amount);
	}
	
	public void withdraw(double amount, boolean branch) {
		if(amount > 500){
			if(branch == true){
				setBalance(getBalance()-amount);
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			setBalance(getBalance()-amount);
		}
	}
	
	public boolean isNegative() {
		if(getBalance() < 0){
			return true;
		} else {
			return false;
		}
	}

}
