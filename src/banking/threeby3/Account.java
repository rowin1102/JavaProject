package banking.threeby3;

import java.io.Serializable;
import java.util.Objects;

public abstract class Account implements Serializable {
	
	private String account;
	private String name;
	private int money;
	
	public Account(String account, String name, int money) {
		this.account = account;
		this.name = name;
		this.money = money;
	}
	
	public String getAccount() {
		return account;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void deposit(int amount) {
		this.money += amount;
	}
	
	public void showAccInfo() {
		System.out.println("계좌번호>" + account);
		System.out.println("고객이름>" + name);
		System.out.println("잔고>" + money);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.account);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || !(obj instanceof Account)) return false;
		
	    Account other = (Account) obj;
	    return this.account.equals(other.account);
	}
	
	@Override
	public String toString() {
		return String.format("[계좌]계좌번호=%s, 이름=%s, 잔고=%d", account, name, money);
	}
	
	private static final long serialVersionUID = 1L;
	
}
