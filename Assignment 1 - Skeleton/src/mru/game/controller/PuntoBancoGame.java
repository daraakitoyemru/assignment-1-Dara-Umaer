package mru.game.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mru.game.model.Player;
import mru.game.view.GameMenu;

public class PuntoBancoGame {
	
	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 */

	CardDeck deck;
	private Card dealtCard;
	private ArrayList<Card> currentDeck;
	private ArrayList<Card> playerDeal;
	private ArrayList<Card> bankerDeal;
	private ArrayList<Integer> pRank;
	private ArrayList<Integer> bRank;
	private int pTotal;
	private int bTotal;
	private ArrayList<Integer> points;
	private GameMenu menu;
	public ArrayList<Player> players;
	
	
	
	public PuntoBancoGame() {
		deck = new CardDeck();
		playerDeal = new ArrayList<Card>();
		bankerDeal = new ArrayList<Card>();
		points = new ArrayList<Integer>();
		players = new ArrayList<>();
		menu = new GameMenu();
		currentDeck = deck.getDeck();
		dealtCard = deck.deal();
	}
	
	
	private ArrayList<Integer> setRank(ArrayList<Card> deal) {
		ArrayList<Integer> rank = new ArrayList<Integer>();
		for (Card c : deal) {
			rank.add(c.getRank());
		}
		return rank;
		
	}
	
	public void clearHand() {
		playerDeal.clear();
		bankerDeal.clear();
	}
	
	
	public int setPoints(ArrayList<Integer> ranks) {
		//Scores each players deal based on game rules
		int sum = 0;
		for (int rank : ranks) {
			if (rank <=10) {
				sum += rank;
			} else { 
				//Check if rank is for King, Queen, or Jack
				sum += 10;
			}
		}
		
		return sum % 10;
		
	}
	
	public ArrayList<Integer> play(Player g) {
		/**
		 * Computes game logic and scoring
		 * 
		 * @return an ArrayList of points per player
		 * @param Current player object
		 * */
		char bet = menu.showBetMenu();
		int betAmount = menu.getBetAmount();
		
		
		for (int i = 0; i < 2; i++) {
			//Dealing 2 cards per player
			playerDeal.add(deck.deal());
			bankerDeal.add(deck.deal());
			
		}
		
		
		
		if (betAmount > g.getBalance()) {
			System.out.println("Insufficent funds");
			g.setBalance(g.getBalance() + 0);
			
		} else if (betAmount <= g.getBalance()) {
			pRank = setRank(playerDeal);
			bRank = setRank(bankerDeal);
			pTotal = setPoints(pRank);
			bTotal = setPoints(bRank);

			if((pTotal == 8 || pTotal == 9 )|| (bTotal == 8 || bTotal == 9)) {
				System.out.println("Done");
		
			} else if (pTotal <= 5 && playerDeal.size() == 2) {
				playerDeal.add(deck.deal());
			} else if (playerDeal.size() == 2 && (bTotal < 6 && !(bTotal == 6 || bTotal == 7) )) {
				bankerDeal.add(dealtCard);
			} else if ((pRank.get(2) == 2 && playerDeal.size() == 3 || pRank.get(2) == 3) && (bTotal < 5 && !(bTotal >= 5 && bTotal <= 7) )) {
				bankerDeal.add(dealtCard);
			} else if ((pRank.get(2) == 4 || pRank.get(2) == 5) && (bTotal < 7)) {
				bankerDeal.add(dealtCard);
			} else if (pRank.get(2) == 8 && (bTotal <=2 && !(bTotal >= 3 && bTotal <= 7) )) {
				bankerDeal.add(dealtCard);
			} else if (pRank.get(2) == 1 || pRank.get(2) == 9 || pRank.get(2) == 10 && (bTotal < 3 && !(bTotal >=4 && bTotal <= 7) )) {
				bankerDeal.add(dealtCard);
			}
			
			pRank = setRank(playerDeal);
			bRank = setRank(bankerDeal);
			pTotal = setPoints(pRank);
			bTotal = setPoints(bRank);
			
			
			
			points.add(pTotal);
			points.add(bTotal);
			showGame();
			
			if (bet == 'p' && pTotal > bTotal ) {
				 g.setBalance(g.getBalance() + betAmount);
				 g.setWins(g.getWins() + 1);
				menu.showWinBanner(betAmount);
			} else if (bet == 'b' && pTotal < bTotal ) {
				g.setBalance(g.getBalance() + betAmount);
				g.setWins(g.getWins() + 1);
				menu.showWinBanner(betAmount);
			} else if (bet == 't' && pTotal == bTotal ) {
				g.setBalance(g.getBalance() + betAmount);
				g.setWins(g.getWins() + 1);
				menu.showWinBanner(betAmount);
			} else {
				g.setBalance(g.getBalance() - betAmount);
				menu.showLoseBanner(betAmount);
			}
		}
		
		
		
		
		return points;
		
	}
	
	
	

	public void showGame() {
		/**
		 * Formats results for readability
		 * */
			System.out.println("\n\t\t - PUNTO BANCO - \t\t");
			System.out.println("+=======================+=======================+");
			System.out.println("||PLAYER\t\t\t|BANKER\t\t\t||");
			System.out.println("+-----------------------+-----------------------+");
			System.out.println("||" +playerDeal.get(0)+ "\t\t|" + bankerDeal.get(0)+"\t\t||");
			System.out.println("+-----------------------+-----------------------+");
			System.out.println("||" +playerDeal.get(1)+ "\t\t|" + bankerDeal.get(1)+"\t\t||");

			if(playerDeal.size() == 3 && bankerDeal.size() == 3) {
				System.out.println("+-----------------------+-----------------------+");
				System.out.println("||" +playerDeal.get(2)+ "\t\t|" + bankerDeal.get(2)+"\t\t||");
				
			} else if (playerDeal.size() == 3 && bankerDeal.size() == 2) {
				System.out.println("+-----------------------+-----------------------+");
				System.out.println("||" +playerDeal.get(2)+ "\t\t|" +"\t\t\t||");

			} else if (playerDeal.size() == 2 && bankerDeal.size() == 3) {
				System.out.println("+-----------------------+-----------------------+");
				System.out.println("||\t\t\t|" + bankerDeal.get(2)+"\t\t||");
			} else {
				System.out.println("+=======================+=======================+");
				System.out.println("||\t\t\t|\t\t\t||");
			}
			System.out.println("+-----------------------+-----------------------+");
			System.out.println("|PLAYER POINTS: " +points.get(0)+ "\t|BANKER POINTS: " + points.get(1)+"\t||");
			System.out.println("+=======================+=======================+");

		}
		
		
}
