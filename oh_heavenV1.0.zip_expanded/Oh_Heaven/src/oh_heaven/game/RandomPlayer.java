package oh_heaven.game;

import java.util.*;
import ch.aplu.jcardgame.*;
public class RandomPlayer implements BasePlayer {
	
	  static public final int seed = 30006;
	  static final Random random = new Random(seed);
	  
	public void setListener(Hand hand) {}
	
	public Card selectCard(Hand hand, Game.Suit lead, Game.Suit trumps, Card winningCard) {
		ArrayList<Card> allCards = findAllCards(hand);
		int x = random.nextInt(allCards.size());
		return allCards.get(x);
	}
}