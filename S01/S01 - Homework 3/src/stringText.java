
public class stringText {

	public static void main(String [] args) {
		trying("this is a small test");
	}

	public static void trying(String word) {
		
		for(int i = 0; i < word.length(); i++) {
			//System.out.print(i);
			//System.out.print(": ");
			//System.out.println(word.charAt(i));
			System.out.println(String.format("%s : %c", i, word.charAt(i)));
			
		}
		
	}

}

