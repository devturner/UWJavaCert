
public class OrderDelivery {
	private int tableNumber;
	boolean toGo;
	
	public void table (int tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public void takeAway (boolean toGo){
		this.toGo = false;
	}
}
