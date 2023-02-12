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
	int playerTotal;
	int bankerTotal;
	ArrayList<Object> currentDeck = new ArrayList<Object>(deck.getDeck());
	ArrayList<String> playerDeal = new ArrayList<String>();
	ArrayList<String> bankerDeal = new ArrayList<String>();
	ArrayList<String> items; 
	ArrayList<Integer> points;
	
	
	public PuntoBancoGame() {
		points = new ArrayList<Integer>();
		items = new ArrayList<String>(); 
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
	}
	
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
	
		
		
		public List<String> getCard() {
			String card = String.join(" , ", this.gameDeal());
			String[] cards = card.split(" ");
			
			
			
			ArrayList<String> arr = new ArrayList<String>();
			
			for (int i = 0; i < cards.length; i++) {
				
				arr.add(cards[i]);
			}
			
			//include elements that are present within the item arraylist
			arr.retainAll(items);
			
			return arr;
			
			
		}
	
		
		public int getPoints(ArrayList<String> list) {
			int sum = 0;
			
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).equals("Ace")) {
					sum += 1;
				} else if(list.get(i).equals("2")) {
					sum += 2;
				} else if(list.get(i).equals("3")) {
					sum += 3;
				} else if(list.get(i).equals("4")) {
					sum += 4;
				} else if(list.get(i).equals("5")) {
					sum += 5;
				} else if(list.get(i).equals("6")) {
					sum += 6;
				} else if(list.get(i).equals("7")) {
					sum += 7;
				} else if(list.get(i).equals("8")) {
					sum += 8;
				} else if(list.get(i).equals("9")) {
					sum += 9;
				} else {
					sum += 10;
				}
			}
			
			return sum % 10;
			
		}
		
		public ArrayList<Integer> runGame() {
			//Player and banker are dealt the card
			List<String> totalDeals = this.getCard();
			playerDeal.add(totalDeals.get(0));
			playerDeal.add(totalDeals.get(1));
			bankerDeal.add(totalDeals.get(2));
			bankerDeal.add(totalDeals.get(3));
			
			
			
			playerTotal = getPoints(playerDeal);
			bankerTotal = getPoints(bankerDeal);
			
			
			if((playerTotal == 8 || playerTotal == 9) || (bankerTotal == 8 || bankerTotal == 9)) {
				System.out.println("Game over");
				
			} else if (playerTotal <=5) {
				playerDeal.add(totalDeals.get(4));
				playerTotal = getPoints(playerDeal);
				System.out.println(playerDeal);
				
				if(playerDeal.get(2).equals("2") || playerDeal.get(2).equals("3") && bankerTotal < 5) {
					
						bankerDeal.add(totalDeals.get(6));
						bankerTotal = getPoints(bankerDeal);
						System.out.println("Game over");
						
						
					
					
				} else if(playerDeal.get(2).equals("4") || playerDeal.get(2).equals("5") && (bankerTotal <= 5)) {
					bankerDeal.add(totalDeals.get(6));
					bankerTotal = getPoints(bankerDeal);
					System.out.println("Game over");
					
					
				} else if(playerDeal.get(2).equals("6") || playerDeal.get(2).equals("7") && (bankerTotal <= 6)) {
					bankerDeal.add(totalDeals.get(6));
					bankerTotal = getPoints(bankerDeal);
					System.out.println("Game over");
					
					
				} else if(playerDeal.get(2).equals("8")  && (bankerTotal <= 2)) {
					bankerDeal.add(totalDeals.get(6));
					bankerTotal = getPoints(bankerDeal);
					System.out.println("Game over");
					
					
				} else if(playerDeal.get(2).equals("9") || playerDeal.get(2).equals("10") || playerDeal.get(2).equals("Ace") && (bankerTotal <= 2)) {
					bankerDeal.add(totalDeals.get(6));
					bankerTotal = getPoints(bankerDeal);
					System.out.println("Game over");
					
				}
				
			} 
			points.add(playerTotal);
			points.add(bankerTotal);
			
			System.out.println("Player: " + playerDeal +"\nPlayersum: "  +playerTotal + "\nBanker: " + bankerDeal +"\nBankersum: "  + bankerTotal);
			return points;
			
		}
}
