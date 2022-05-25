package oh_heaven.game;

/**
 * An exception thrown when a player breaks a rule
 */
import java.util.*;
import ch.aplu.jcardgame.*;
public class LegalPlayer implements BasePlayer {
	
	  static public final int seed = 30006;
	  static final Random random = new Random(seed);
	
	public Card selectCard(Hand hand, Oh_Heaven.Suit lead, Oh_Heaven.Suit trumps, Card winningCard) {
		ArrayList<Card> legalCards = findAllLegalCards(hand, lead);
		int x = random.nextInt(legalCards.size());
		return legalCards.get(x);
	}
}
