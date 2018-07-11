package com.foundations.hand;

import com.foundations.card.Card;

public class Hand
{

	private Card  [] cards;


		public String toString(){
			String temp = "" ;
			for (int i = 0; i < cards.length; i++){
				temp += cards[i].toString();
			}
			return temp;
		}


		public Hand(int numberOfCards){
			cards = new Card[numberOfCards];
			for (int i = 0; i <= numberOfCards - 1; i++){
				cards[i] = Card.getRandom();
				}
		}


		public boolean suitsMatch(){
			boolean Same = true;
			for (int i = 0; i < cards.length-1; i++){
				if (!cards[i].getSuit().equals(cards[i+1].getSuit())){

				Same = false;
				break;
				}

			  }
			return Same;
			}


//			int first = hand[getSuit];
//			for (int element : array){
//				if element != first)
//				return false





			public static void main (String [] args){
				String string1 = args[0];
				int numberOfCards = Integer.parseInt(string1);
//
//
				Hand test = new Hand(numberOfCards);
				System.out.println(test.toString());
     			//System.out.println(test.getSuit());
			}
//			}
}



