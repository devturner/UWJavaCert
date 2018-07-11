

public class FibonacciDisplay {

	public static void main(String[] args) {
		String string1 = args[0];
		int howFar = Integer.parseInt(string1);
		int fibNum1 = 0;
		int fibNum2 = 1;
		int next;
		System.out.print(fibNum1 + ", " + fibNum2);

		
		for (int count = 3; count <= howFar; count++){
			next = fibNum1 + fibNum2;
			System.out.print(", " + next);
			fibNum1 = fibNum2;
			fibNum2 = next;
		}

		
	}

}

//public class classNotes {
//
//	public static int add(int num1, int num2) {
//		return num1 + num2;	
//	}
//}
