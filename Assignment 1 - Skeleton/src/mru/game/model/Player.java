package mru.game.model;

public class Player {
	
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
	
	public String name;
	public int numOfWins;
	public int balance;
	
	public Player(String name, int numOfWins, int balance) {
		this.name = name;
		this.numOfWins = numOfWins;
		this.balance = balance;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setWins(int numOfWins) {
		this.numOfWins = numOfWins;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
		
	}
	
	public String getName() {
		return name;
	}
	
	public int getWins() {
		return numOfWins;
	}
	
	public int setBalance() {
		return balance;
	}
	
	public String format() {
		return name+","+numOfWins+","+balance;
	}
}
