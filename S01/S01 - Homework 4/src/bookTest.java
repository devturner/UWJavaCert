
public class bookTest {
	public static void main (String [] args){
		char[] arr1;
		arr1 = new char[3];
		
		arr1[0] = 'a';
		arr1[1] = 'b';
		arr1[2] = 'c';
		
		System.out.println(arr1.length);
		System.out.println(arr1[0]);
		System.out.println(arr1[arr1.length - 1]);
		
		//double array
		
		double[] arr2 = new double[4];
		
		System.out.println(arr2.length);
		System.out.println(arr2[0] + ", " + arr2[1] + ", " + arr2[2] + ", " + arr2[3]);
		
		arr2[0] = 3.0;
		arr2[1] = 5.0;
		arr2[2] = arr2[1] + arr2[0];
		arr2[3] = arr2[1] - arr2[0];

		System.out.println(arr2[0] + ", " + arr2[1] + ", " + arr2[2] + ", " + arr2[3]);
		
		int[] arr3 =  {1, 4, 26, 0, 97, 75, 11, 28, 27, 3};
		System.out.println(arr3.length);
		
		System.out.println(arr3[2] + arr3[4]); 
		
		
	}
}
