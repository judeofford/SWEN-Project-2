package oh_heaven.game;

/**
 * An exception thrown when a player breaks a rule
 */
import java.util.*;
import ch.aplu.jcardgame.*;
public class SmartPlayer implements BasePlayer {
	  public void setListener(Hand hand) {}
	  
	  public Card selectCard(Hand hand, Game.Suit lead, Game.Suit trumps, Card winningCard, Boolean metBid) {
		  ArrayList<Card> legalCards = findAllLegalCards(hand, lead);
		  
		  //Try to win if bid is not met
		  //Try to lose if bid is met
		  
		  //There is no lead card
		  if(lead==null) {
			  // bid is met
			  // Play highest value card with trump suit
			  // Play lowest value card if there is no card with a trump suit
			  
			  //bid is not met
			  // Play lowest value non trump card
			  // Play lowest value trump card
			  
			  Card card = null;
			  for(int i=1; i<legalCards.size();i++) { 
				  if(!metBid) {
					  if(legalCards.get(i).getSuit() == trumps) {
						  if(card == null || rankGreater(legalCards.get(i),card)) {
							  card = legalCards.get(i);
						  } 
					  }  
				  } else {
					  if(legalCards.get(i).getSuit() != trumps) {
						  if(card==null || rankGreater(card,legalCards.get(i))) {
							  card =  legalCards.get(i);
						  }
					  }
				  }
			  }
			  
			  if(card==null) {
				  for(int i=1; i<legalCards.size();i++) { 
					  if(card == null || rankGreater(card,legalCards.get(i))) {
						  card = legalCards.get(i);
					  } 
				  }  
			  }
			  
			  return card;
			  
		  }
		  
		  //Player has a card with a lead suit 
		  if(legalCards.get(0).getSuit()==lead) {
			  
			  //bid is not met
			  //play highest value card if it is higher than the current winning card
			  //play lowest value card if player has no chance of winning
			  
			  //bid is met
			  //play lowest value lead suited card
			  
			  Card lowestCard = legalCards.get(0);
			  Card highestCard = legalCards.get(0);
			  
			  for(int i=1; i<legalCards.size();i++) { 
				  if(rankGreater(legalCards.get(i), highestCard)) {
					  highestCard = legalCards.get(i);
				  }
				  if(rankGreater(lowestCard,legalCards.get(i))) {
					  lowestCard = legalCards.get(i);
				  } 
			  }
			  if(rankGreater(highestCard,winningCard) && !metBid) {
				  return highestCard;
			  } else {  
				  return lowestCard;
			  }
		  }
		  else {
			  // Player does not have to play a lead card
			  
			  // bid is not met
			  // Play lowest value card with trump suit
			  // Play lowest value card if there is no card with a trump suit
			  
			  //bid is met
			  //Play lowest value non trump suit card
			  //Play lowest value card
			  
			  Card card = null;
			  for(int i=1; i<legalCards.size();i++) { 
				  if(!metBid) {
					  if(legalCards.get(i).getSuit() == trumps) {
						  if(card == null || rankGreater(card,legalCards.get(i))) {
							  card = legalCards.get(i);
						  } 
					  }  
				  } else {
					  if(legalCards.get(i).getSuit() != trumps) {
						  if(card==null || rankGreater(card,legalCards.get(i))) {
							  card = legalCards.get(i);
						  }
					  }
				  }
			  }
			  
			  if(card==null) {
				  for(int i=1; i<legalCards.size();i++) { 
					  if(card == null || rankGreater(card,legalCards.get(i))) {
						  card = legalCards.get(i);
					  } 
				  }
			  }
			  
			  return card;
		  }
	  }
}
