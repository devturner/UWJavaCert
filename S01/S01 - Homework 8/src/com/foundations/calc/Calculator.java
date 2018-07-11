package com.foundations.calc;
import com.foundations.calc.Arithmetic;


public class Calculator extends Arithmetic {

		public static void main(String[] args) {
			String string1 = args[0];
			String string2 = args[1];
			
			Integer intA = Integer.parseInt(string1);
			Integer intB = Integer.parseInt(string2);

			Add(intA, intB);
			System.out.println(getMySum());
			
			Sub(intA, intB);
			System.out.println(getMySub());
			
			Mult(intA, intB);
			System.out.println(getMyMult());
			
			Div(intA, intB);
			System.out.println(getMyDiv());
			
			Rem(intA, intB);
			System.out.println(getMyRem());
		}
}		





		
		
		


