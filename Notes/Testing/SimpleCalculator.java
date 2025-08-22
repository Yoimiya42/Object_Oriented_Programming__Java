
package Testing;

public class SimpleCalculator {
	private int balance;

	public SimpleCalculator(int initBalance){
		this.balance = initBalance;
	}

	public SimpleCalculator(){
		this.balance = 0;
	}

	public void deposit(int amount){
		balance += amount;
	}

	public void withdraw(int amount){
		balance -= amount;
	}

	public int getBalance(){
		return balance;
	}
}