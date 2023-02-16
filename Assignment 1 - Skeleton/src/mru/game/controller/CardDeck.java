package mru.game.controller;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents a card deck
 * @author ksalmani
 * @version 1.0
 */
public class CardDeck {
	
	/**
	 * deck holds all of the cards that currently are in the current deck
	 */
	private ArrayList <Card> deck;
	private int currentCard;
	
	/**
	 * This constructor initiate the arraylist and calls the repective methods to create a new deck
	 */
	public CardDeck() {
		deck = new ArrayList<Card>();
		currentCard = 0;
		createDeck();
		shuffleDeck();
	}

	/**
	 * This method creates the deck
	 */
	private void createDeck() {
		// suits holds the name of the suits
		String[] suits = {"Spades", "Diamond", "Clubs", "Hearts"};
		
		/*
		 * The for loop creates a whole new deck based on their suit and rank
		 */
		for (int i = 0 ; i < 4; i++) {
			for (int j = 1 ; j <=13 ; j++) {
				deck.add(new Card (j,suits[i]));
			}
		}
		
	}
	
	public int cardsRemaining() {
		return deck.size() - currentCard;
	}

	public Card deal() {
		if (currentCard == deck.size()) {
			System.out.println("No cards left for this game. Play again to reset the deck");
			throw new IllegalStateException("No cards left");
		}
		currentCard++;
		deck.remove(currentCard);
		return deck.get(currentCard - 1);
	}
	
	/**
	 * this method shuffle the deck after creating a new deck
	 */
	private void shuffleDeck() {
		Collections.shuffle(deck); 
	}

	/**
	 * The deck getter method
	 * @return the deck
	 */
	public ArrayList<Card> getDeck() {
		return deck;
	}
}
