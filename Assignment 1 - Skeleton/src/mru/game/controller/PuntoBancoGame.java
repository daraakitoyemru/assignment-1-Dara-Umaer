package mru.game.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PuntoBancoGame {
	
	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 */
	
	int total;
	ArrayList<String> hand = new ArrayList<String>();
	
	CardDeck deck = new CardDeck();
	int currentCard = 0;
	ArrayList<Object> currentDeck = new ArrayList<Object>(deck.getDeck());
	ArrayList<String> playerDeal = new ArrayList<String>();
	ArrayList<String> bankerDeal = new ArrayList<String>();
	
	public Object deal() {
		
		if(currentCard < currentDeck.size()) {
			return currentDeck.get(currentCard++);
		}
		else {
			return null;
		}
		
		
	}
		
		public ArrayList<String> gameDeal() {
			Object deal1 = deal();
			Object deal2 = deal();
			Object deal3 = deal();
			Object deal4 = deal();
			
			hand.add(deal1.toString());
			hand.add(deal2.toString());
			
			hand.add(deal3.toString());
			hand.add(deal4.toString());
			
			//System.out.println("Testing: " + hand);
			//System.out.println("hiii: " + bankerDeal);
			
			return hand;
		}
	
		
//		public ArrayList<String> initBankerDeal() {
//			Object deal1 = deal();
//			Object deal2 = deal();
//			bankerDeal.add(deal1.toString());
//			bankerDeal.add(deal2.toString());
//			String listString = String.join(", ", bankerDeal);
//			
//			System.out.println(listString);
//			return bankerDeal;
//		}
		
		public List<String> getCard() {
			String card = String.join(" , ", this.gameDeal());
			String[] cards = card.split(" ");
			ArrayList<String> items = new ArrayList<String>();
			items.add("Jack");
			items.add("Queen");
			items.add("King");
			items.add("Ace");
			items.add("2");
			items.add("3");
			items.add("4");
			items.add("5");
			items.add("6");
			items.add("7");
			items.add("8");
			items.add("9");
			items.add("10");
			
			
			ArrayList<String> arr = new ArrayList<String>();
			
			for (int i = 0; i < cards.length; i++) {
				
				arr.add(cards[i]);
			}
			
			arr.retainAll(items);
			
			return arr.subList(0, 4);
			
			
		}
	
		
		public boolean runGame() {
			List<String> totalDeals = this.getCard();
			playerDeal.add(totalDeals.get(0));
			playerDeal.add(totalDeals.get(1));
			bankerDeal.add(totalDeals.get(2));
			bankerDeal.add(totalDeals.get(3));
			
			System.out.println("Player: " + playerDeal + " Banker: " + bankerDeal);
			return false;
			
		}
}
