package com.foundations.card;


public class Card {
	
	private String Rank;
	private String Suit;
	
	private static String [] suits =
		{"Hearts", "Clubs", "Diamonds", "Spades"};
	private static String [] ranks = 
		{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	
	//private static String [] myCard;

	//Getter
	public String getRank() {
		return Rank;
	}
	//Getter
	public String getSuit() {
		return Suit;
	}
	//Constructor
	public Card(String rank, String suit) {
		Rank = rank;
		Suit = suit;
	}
	//
	//public static void setMyCard(String [] myCard) {
	//	Card.myCard = myCard;
	//}
	
	public String toString(){
		return "(" + Rank + " of " + Suit + ") ";
	}
	
	public static Card getRandom(){
		int randomSuit = (int) (Math.random() * 4); 
		String mySuit = suits[randomSuit];
		int randomCardNumber = (int) (Math.random() * 13);
		String myRank = ranks[randomCardNumber];
		Card myCard = new Card(myRank, mySuit);
		return myCard;
		}


}





//
//public static void main (String [] args){
//	Card test = Card.getRandom();
//	System.out.println("this better work " + test.toString());
//	System.out.println("Suit is " + test.getSuit());
//	Card test2 = Card.getRandom();
//	System.out.println("this better work " + test2.toString());
//	Card test3 = Card.getRandom();
//	System.out.println("this better work " + test3.toString());
//	Card test4 = Card.getRandom();
//	System.out.println("this better work " + test4.toString());
//	}
//}	
