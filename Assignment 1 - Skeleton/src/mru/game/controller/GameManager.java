package mru.game.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import mru.game.model.Player;
import mru.game.view.AppMenu;
import mru.game.view.GameMenu;

public class GameManager {
	
	/* In this class toy'll need these methods:
	 * A constructor
	 * A method to load the txt file into an arraylist (if it exists, so you check if the txt file exists first)
	 * A save method to store the arraylist into the the txt file 
	 * A method to search for a player based their name
	 * A method to find the top players
	 * Depending on your designing technique you may need and you can add more methods here 
	 */

	
	private final String FILE_PATH = "res/CasinoInfo.txt";
	public ArrayList<Player> players;
	public AppMenu menu;
	public PuntoBancoGame game;
	private GameMenu gMenu;
	public int initBalance = 100;
	
	public GameManager() throws Exception {
		menu = new AppMenu();
		gMenu = new GameMenu();
		players = new ArrayList<>();
		game = new PuntoBancoGame();

		loadData();
		launchApp();
		
	}

	public void launchApp() throws Exception{
		//Runs app, displays menu to console
		boolean flag = true;
		
		
		while(flag) {
			char option = menu.showMainMenu();
			switch (option) {
			case 'p':
				playGame();
				break;
			case 's':
				Search();
				flag = false;
				break;
			case 'e':
				flag = false;
				Save();
				System.out.println("Saving...");
				System.out.println("Thanks for playing");
				break;
			default:
				System.out.println("Invalid input");
				flag = false;
				break;
			}
			
		}
		
	}

	
	private void Save() throws Exception {
		/**
		 * Updates CasinoInfo.txt with new info
		 * 
		 * 
		 * */
		File db = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(db);
		
		
		for(Player p: players) {
			pw.println(p.format());
		}
		pw.close();
	}

	

	private void playGame() throws Exception {
		/**
		 * Runs Punto Banco
		 * */
		// TODO Auto-generated method stub
		
		char bet;
		int betAmount;
		ArrayList<Integer> points;
		boolean flag = true;
		Player p = getPlayer();
			
		
		while (flag) {
			
			
			game.clearHand();
			points = game.play(p);
			
			points.clear();
			
			char option = gMenu.promptPlayAgain();
			
			if (option == 'n') {
				launchApp();
				flag = false;
				break;
				
			}
			flag = false;
		}
		
	
	}
	
	public Player getPlayer() {
		/**
		 * Gets a new player if they exists and displays returning playing banner
		 * 
		 * @return Player object
		 * */
		
		String name = menu.promptName();
		Player p = searchByName(name);
		Player newP = null;
		if (p == null) {
			newP = new Player(name, 100, 0);
			players.add(newP);	
			gMenu.showNewPlayer(name, 100);
			

		}
		else {
			gMenu.showReturningPlayer(name, p.getBalance());
			newP = p;

		}
		return newP;
	}
	

	private void Search() throws Exception {
		//Allows user to navigate sub menu
		
		char option = menu.showSubMenu();
		
		switch (option) {
		case 't':
			showTopPlayer();
			break;
		case 'n':
			String name = menu.promptName();

			Player currentP = searchByName(name);
			if(currentP == null) {
				throw new NullPointerException("Player not found. Please restart");
			}
			menu.formatPlayerInfo(currentP.getName(), currentP.getWins(), currentP.getBalance());
			break;
		case 'b':
			this.launchApp();
			break;
		default:
			System.out.println("Inavlid input");
			
			break;
		}
	}
	
	

	public Player searchByName(String name) {
		/**
		 * Check if given name exists in Player array
		 * and creates a new Player object if the name is not found
		 * @return Newly created player object
		 * */
		Player currentP = null;
		
		for (Player p: players) {
			if (p.getName().equalsIgnoreCase(name)) {
				currentP = p;
				break;
			}
		}
		return currentP;
	}

	private ArrayList<Integer> getTopPlayer() {
		/**
		 * Returns an array of wins in descending order
		 * */
		
		ArrayList<Integer> w = new ArrayList<>();
		
		for (Player p : players) {
			int wins = p.getWins();
			
			w.add(wins);
		}
		
		Collections.sort(w, Collections.reverseOrder());
		return w;
		
	}


	
	public void showTopPlayer() {
		/**
		 * Prints the top 3 players
		 * 
		 * */
		System.out.println("\n         - TOP 3 PLAYERS -");
		System.out.println("+===============+===============+");
		System.out.println("|NAME\t\t|# WINS\t\t|");
		System.out.println("+---------------+---------------+");
		for(int i = 0; i < 3; i++) {
			for(Player p: players) {
				if (p.getWins() == getTopPlayer().get(i)) {
					System.out.println("|" + p.getName()+ "\t\t|" + p.getWins() + "\t\t|");
					System.out.println("+---------------+---------------+");

					
				}
			}
		}
		
		
	}

	public void loadData() throws Exception{
		/**
		 * Reads through file and creates Player objects of existing users
		 * 
		 * */
	
	// Checks if file exists
		File db = new File(FILE_PATH);
		String line;
		String[] splitLine;
				
		if(db.exists()) {
			Scanner fileReader = new Scanner(db);
			
			while(fileReader.hasNextLine()) {
				//Reads the first line of a file
				line = fileReader.nextLine();
				
				splitLine = line.split(",");
				Player p = new Player(splitLine[0], Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]));
				players.add(p);
			}
			fileReader.close();
		}
		
	}
	
}
