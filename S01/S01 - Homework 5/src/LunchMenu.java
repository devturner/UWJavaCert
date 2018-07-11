
public class LunchMenu {

	//Rudimentary menu with 1 type for each category. This is a 1 type of food place at the moment. 
	private int sodas, beers, cocktails;
	double sodaCost = .99;
	double beerCost = 3.50;
	double cocktailCost = 5.00;
	
	private int sandwiches, sides, desserts;
	private double sandwichCost = 7.20;
	private double sideCost = 2.75;
	private double dessertCost = 3.99;
	double taxRate = .09;

	//bringing in the location class from our other class file.
	//This is instantiation. 

	private OrderDelivery table;
	
	//making a constructor. 
	public LunchMenu (int sandwiches, int sides, int desserts, int sodas, int beers, int cocktails){
		setSandwiches(sandwiches);
		setSides(sides);
		setDesserts(desserts);
	}
	
	//this is a method for finding the total cost of the order. 
	public double total(){
		return (sandwiches * sandwichCost) + (sides * sideCost) + (desserts * dessertCost) + 
				(sodas * sodaCost) + (beers * beerCost) + (cocktails * cocktailCost) * taxRate; 
		
	}
	
	
	
	
	//This is instantiation. 
	public void table(int tableNumber){
		table = new OrderDelivery();
		table.table(21);
	}
	

	
	
	
	public void setSandwiches(int sanewiches) {
		if(sandwiches >= 0){
		this.sandwiches = sanewiches;
		}
	}

	public void setSides(int sides) {
		if(sides >= 0) {
		this.sides = sides;
		}
	}

	public void setDesserts(int desserts) {
		if(desserts >= 0 ){
		this.desserts = desserts;
	 	}
	}
	
	public void setBeers(int beers) {
		if(beers >= 0 ){
		this.beers = beers;
	 	}
	}	
	
	public void setSodas(int sodas) {
		if(sodas >= 0 ){
		this.sodas = sodas;
	 	}
	}	
	
	public void setCocktails(int cocktails) {
		if(cocktails >= 0 ){
		this.cocktails = cocktails;
	 	}
	}
	
	

}

/*
 * Objectives:
X  Create two Classes in order to demonstrate the following principles:
X  Aggregation
X  Constructor with parameters
X  Encapsulation
X  Static methods
I expect at least two methods per class (with at least one static method). One class should be aggregated in the other. Beyond that, you have free reign. Feel free to be creative and think about real-life situations you might want to use these types of designs.
2. Write a JUnit test case to create Objects from these Classes.

*/

