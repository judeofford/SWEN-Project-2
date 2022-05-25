package oh_heaven.game;

/**
 * An exception thrown when a player breaks a rule
 */
import java.util.*;
import ch.aplu.jcardgame.*;
public interface BasePlayer {
	public Card selectCard(Hand hand, Suit lead, Suit trumps, Card winningCard);
	
	  public static enum Suit
	  {
	    SPADES, HEARTS, DIAMONDS, CLUBS
	  }
	  
	  public static enum Rank
	  {
	    // Reverse order of rank importance (see rankGreater() below)
		// Order of cards is tied to card images
		ACE, KING, QUEEN, JACK, TEN, NINE, EIGHT, SEVEN, SIX, FIVE, FOUR, THREE, TWO
	  }
	  
	  public static boolean rankGreater(Card card1, Card card2) {
		  return card1.getRankId() < card2.getRankId(); // Warning: Reverse rank order of cards (see comment on enum)
	  }
	
	public static ArrayList<Card> findAllLegalCards(Hand hand, Suit lead) {
		ArrayList<Card> legalCards = new ArrayList<Card>();
		for(int i=0; i<hand.getNumberOfCards();i++) {
			Card card = hand.get(i);
			if (hand.getNumberOfCardsWithSuit(lead) == 0 || card.getSuit() == lead) {
				legalCards.add(card);
			}
		}
		return legalCards;
	}
}
