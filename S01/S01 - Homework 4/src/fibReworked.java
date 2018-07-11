
public class fibReworked {

	public static void main(String[] args) {
		fibonacci(15);
		
	}

	public static String fibonacci(int count){
		int fibNum1 = 0;
		int fibNum2 = 1;
		int next = 1;
		String parts2 = "";
		parts2 = "0, 1";
		
		for (int thisCounts = 3; thisCounts <= count; thisCounts++){
			next = fibNum1 + fibNum2;
			parts2 += ", " + next;
			fibNum1 = fibNum2;
			fibNum2 = next;
			
		}
		System.out.println();
		System.out.print(parts2);
		return parts2;
	}
	
}