package mru.game.application;

import mru.game.controller.GameManager;
import mru.game.view.AppMenu;

public class AppDriver {

	public static void main(String[] args) throws Exception {
		
		// This is the starting point of the project!
		// hint - It usually calls method from GameManager class to start the app, so only one or two lines will be written here
		
		AppMenu display = new AppMenu();
		GameManager g = new GameManager();
		
		g.launchApp();
	}

}
