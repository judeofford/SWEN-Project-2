package oh_heaven.game;

/**
 * An exception thrown when a player breaks a rule
 */
import java.util.*;
import ch.aplu.jcardgame.*;
public class LegalPlayer implements BasePlayer {
	
	  static final Random random = Game.random;
	  
	public void setListener(Hand hand) {}
	
	public Card selectCard(Hand hand, Game.Suit lead, Game.Suit trumps, Card winningCard, Boolean metBid) {
		ArrayList<Card> legalCards = findAllLegalCards(hand, lead);
		int x = random.nextInt(legalCards.size());
		return legalCards.get(x);
	}
}
