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
		
		System.out.println("Select one of these options:\n");
		System.out.println("\t(P) Play game");
		System.out.println("\t(S) Search");
		System.out.println("\t(E) Exit\n");
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
		System.out.println("Enter a name here: ");
		String name = input.nextLine().trim();
		return name;
	}
	
	public void showTopPlayers() {
		String name = "test";
		
		int wins = 20;
		int balance = 90;
		
		System.out.println("+====================+======================+");
		System.out.println("|NAME                |# WINS                |");
		System.out.println("+====================+======================+");
		System.out.println("|"+name+"                |"+wins+"                    |");
		System.out.println("|"+name+"------------+"+wins+"--------------|");
	}
}
