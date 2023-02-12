package mru.game.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.model.Player;
import mru.game.view.AppMenu;

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
	
	public GameManager() throws Exception {
		menu = new AppMenu();
		players = new ArrayList<>();
		
		//loadData();
		launchApp();
		
	}

	public void launchApp() throws Exception{
		//Runs app, displays menu to console
		boolean flag = true;
		char option = menu.showMainMenu();
		
		
		
		while(flag) {
			switch (option) {
			case 'p':
				playGame();
				flag = false;
				break;
			case 's':
				Search();
				break;
			case 'e':
				Exit();
				flag = false;
				break;
			default:
				System.out.println("Invalid input");
				flag = false;
				break;
			}
			
		}
		
	}

	
	private void Exit() {
		// TODO Auto-generated method stub
		
	}

	private void playGame() {
		// TODO Auto-generated method stub
		game = new PuntoBancoGame();
		//Object card = game.deal();
		System.out.println("Overall deal: "+game.gameDeal());
		
		System.out.println(game.runGame());
	
	}

	private void Search() {
		// TODO Auto-generated method stub
		
		char option = menu.showSubMenu();
		
		switch (option) {
		case 't':
			showTopPlayer();
			break;
		case 'n':
			showPlayerInfo();
		case 'b':
			menu.showMainMenu();
		default:
			break;
		}
	}

	private void showTopPlayer() {
		// TODO Auto-generated method stub
		
	}

	private void showPlayerInfo() {
		// TODO Auto-generated method stub
		String name = menu.promptName();
	}

	public void loadData() throws Exception{
	
	// Checks if file exists
		File db = new File(FILE_PATH);
		String line;
		String[] splitLine;
				
		if(db.exists()) {
			Scanner fileReader = new Scanner(FILE_PATH);
			
			while(fileReader.hasNextLine()) {
				//Reads the first line of a file
				line = fileReader.nextLine();
				splitLine = line.split(",");
				Player p = new Player(splitLine[0], Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]));
				players.add(p);
			}
			
		}
		
	}
	
}
