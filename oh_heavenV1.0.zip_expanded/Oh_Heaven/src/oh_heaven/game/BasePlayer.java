package oh_heaven.game;

/**
 * An exception thrown when a player breaks a rule
 */
import java.util.*;
import ch.aplu.jcardgame.*;
public interface BasePlayer {
	public Card selectCard(Hand hand, Game.Suit lead, Game.Suit trumps, Card winningCard, Boolean metBid);
	public void setListener(Hand hand);  
	  public default boolean rankGreater(Card card1, Card card2) {
		  return card1.getRankId() < card2.getRankId(); // Warning: Reverse rank order of cards (see comment on enum)
	  }
	
	public default ArrayList<Card> findAllLegalCards(Hand hand, Game.Suit lead) {
		ArrayList<Card> legalCards = new ArrayList<Card>();
		for(int i=0; i<hand.getNumberOfCards();i++) {
			Card card = hand.get(i);
			if (hand.getNumberOfCardsWithSuit(lead) == 0 || card.getSuit() == lead) {
				legalCards.add(card);
			}
		}
		return legalCards;
	}
	
	public default ArrayList<Card> findAllCards(Hand hand) {
		ArrayList<Card> allCards = new ArrayList<Card>();
		for(int i=0; i<hand.getNumberOfCards();i++) {
			Card card = hand.get(i);
			allCards.add(card);
		}
		return allCards;
	}
}
