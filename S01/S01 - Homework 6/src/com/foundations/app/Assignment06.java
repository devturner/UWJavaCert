package com.foundations.app;

import com.foundations.hand.Hand;
import com.foundations.card.Card;


public class Assignment06{

	public static void main(String[] args) {
		String string1 = args[0];
		int numberOfCards = Integer.parseInt(string1);
	
		
		
		Hand test = new Hand(numberOfCards);
		System.out.println(test.toString());
		boolean flush = test.suitsMatch();
		//System.out.print(flush);
		//System.out.println(" ");
		if (flush == false){ 
			System.out.println("Not a flush!");
			}
		else {
			System.out.print("Got a flush!");
		}
		
		System.out.println(" ");

		
		Hand test2 = new Hand(numberOfCards);
		System.out.println(test2.toString());
		boolean flush2 = test2.suitsMatch();
		//System.out.print(flush2);
		//System.out.println(" ");
		if (flush2 == false){ 
			System.out.println("Not a flush!");
			}
		else {
			System.out.print("Got a flush!");
		}
		System.out.println(" ");
		
		
		Hand test3 = new Hand(numberOfCards);
		System.out.println(test3.toString());
		boolean flush3 = test3.suitsMatch();
		if (flush3 == false){ 
			System.out.println("Not a flush!");
			}
		else {
			System.out.print("Got a flush!");
		}
		System.out.println(" ");
		
		
		Hand test4 = new Hand(numberOfCards);
		System.out.println(test4.toString());
		boolean flush4 = test4.suitsMatch();
		if (flush4 == false){ 
			System.out.println("Not a flush!");
			}
		else {
			System.out.print("Got a flush!");
		}
		System.out.println(" ");
		
		
		Hand test5 = new Hand(numberOfCards);
		System.out.println(test5.toString());
		boolean flush5 = test5.suitsMatch();
		if (flush5 == false){ 
			System.out.println("Not a flush!");
			}
		else {
			System.out.print("Got a flush!");
		}
		
		
	}

}
//System.out.println("They are not the same!");

//System.out.println("You got a flush!");