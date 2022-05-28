package oh_heaven.game;

/**
 * An exception thrown when a player breaks a rule
 */
import ch.aplu.jcardgame.*;
public class HumanPlayer implements BasePlayer{

	public Card selectCard(Hand hand, Game.Suit lead, Game.Suit trumps, Card winningCard, Boolean metBid) {
		return null;
	}
	
	public void setListener(Hand hand) {
		CardListener cardListener = new CardAdapter()  // Human Player plays card
			    {
			      public void leftDoubleClicked(Card card) { 
			    	  hand.setTouchEnabled(false);
			    	  Game.selected = card;
			      }
			    };
		hand.addCardListener(cardListener);
	}
}