package oh_heaven.game;

import java.util.*;
import ch.aplu.jcardgame.*;
public class RandomPlayer implements BasePlayer {
	
	  static final Random random = Game.random;
	  
	public void setListener(Hand hand) {}
	
	public Card selectCard(Hand hand, Game.Suit lead, Game.Suit trumps, Card winningCard, Boolean metBid) {
		ArrayList<Card> allCards = findAllCards(hand);
		int x = random.nextInt(allCards.size());
		return allCards.get(x);
	}
}