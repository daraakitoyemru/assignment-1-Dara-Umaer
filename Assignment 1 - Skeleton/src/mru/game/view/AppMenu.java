package mru.game.view;

import java.util.Scanner;

public class AppMenu {

	/**
	 * This class will be used to show the menus and sub menus to the user
	 * It also prompts the user for the inputs and validates them 
	 */
	
	private Scanner input;
	
	public AppMenu() {
		input = new Scanner(System.in);
	}
	
	public char showMainMenu() {
		
		System.out.println("\nSelect one of these options:\n");
		System.out.println("\t(P) Play game");
		System.out.println("\t(S) Search");
		System.out.println("\t(E) Save and Exit\n");
		System.out.print("Enter a choice: ");
		char option = input.nextLine().charAt(0);

		return Character.toLowerCase(option);
	}
	
	public char showSubMenu() {
		
		System.out.println("Select one of these options:\n");
		System.out.println("\t(T) Top player");
		System.out.println("\t(N) Look for a name");
		System.out.println("\t(B) Back to main\n");
		System.out.print("Enter a choice: ");
		char option = input.nextLine().charAt(0);

		return Character.toLowerCase(option);
	}
	
	public String promptName() {
		System.out.print("Enter a name here: ");
		String name = input.nextLine().trim().toLowerCase();
		return name;
	}
	
	public void formatPlayerInfo(String name, int wins, int balance) {
		System.out.println("                 - PLAYER INFO -");
		System.out.println("+===============+===============+========================+");
		System.out.println("|NAME\t\t|# WINS\t\t|BALANCE\t\t\t|");
		System.out.println("+===============+===============+========================+");
		System.out.println("|" + name+ "\t\t|" + wins + "\t\t|" + balance +" $" + "\t\t\t|");
		System.out.println("+---------------+---------------+------------------------+");

	}
	
	public void formatTopPlayer() {
		

	}
	

}
