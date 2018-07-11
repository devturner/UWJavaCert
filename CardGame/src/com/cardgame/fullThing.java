package com.cardgame;


public class fullThing {

	public static void main(String[] args) {
		String string1 = args[0];
		int numberOfCards = Integer.parseInt(string1);
		
		String rank;
		String suit;
		
	
	}
		private static String [] suits =
			{"Hearts", "Clubs", "Diamonds", "Spades"};
		private static String [] ranks = 
			{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		
		private static String [] myCard;
		
		public static Card getRandom(){
			int randomSuit = (int) (Math.random() * 4); 
			String mySuit = suits[randomSuit];
			int randomCardNumber = (int) (Math.random() * 13);
			String myRank = ranks[randomCardNumber];
			//HOW DO I GET THE CARD TO BE A SUIT AND A RANK?
			Card myCard = new Card();
			return myCard;
		}
			
			
			//array of card objects
			private Card  [] cards;
			
			//Constructor
			public Hand(int numberOfCards){
				cards = new Card [numberOfCards];

	}

}
