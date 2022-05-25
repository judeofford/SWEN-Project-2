package oh_heaven.game;

/**
 * An exception thrown when a player breaks a rule
 */
import java.util.*;
import ch.aplu.jcardgame.*;
public class SmartPlayer implements BasePlayer {
	  public Card selectCard(Hand hand, Oh_Heaven.Suit lead, Oh_Heaven.Suit trumps, Card winningCard) {
		  ArrayList<Card> legalCards = findAllLegalCards(hand, lead);
		  
		  //There is no lead card
		  if(lead==null) {
			  // Play highest value card with trump suit
			  // Play lowest value card if there is no card with a trump suit
			  Card card = null;
			  for(int i=1; i<legalCards.size();i++) { 
				  if(legalCards.get(i).getSuit() == trumps) {
					  if(card == null || rankGreater(legalCards.get(i),card)) {
						  card = legalCards.get(i);
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
			  //play highest value card if it is higher than the current winning card
			  //play lowest value card if player has no chance of winning
			  
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
			  if(highestCard.getValue()>winningCard.getValue()) {
				  return highestCard;
			  } else {  
				  return lowestCard;
			  }
		  }
		  else {
			  // Player does not have to play a lead card
			  
			  // Play lowest value card with trump suit
			  // Play lowest value card if there is no card with a trump suit
			  Card card = null;
			  for(int i=1; i<legalCards.size();i++) { 
				  if(legalCards.get(i).getSuit() == trumps) {
					  if(card == null || rankGreater(card,legalCards.get(i))) {
						  card = legalCards.get(i);
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
