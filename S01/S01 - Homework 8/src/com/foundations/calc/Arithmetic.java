package com.foundations.calc;

public class Arithmetic {
	private static Integer mySum = new Integer(8);
	private static Integer mySub = new Integer(8);
	private static Integer myMult = new Integer(8);
	private static Integer myDiv = new Integer(8);
	private static Integer myRem = new Integer(8);
	

	public static Integer getMySub() {
		return mySub;
	}
	public static void setMySub(Integer mySub) {
		Arithmetic.mySub = mySub;
	}
	public static Integer getMyMult() {
		return myMult;
	}
	public static void setMyMult(Integer myMult) {
		Arithmetic.myMult = myMult;
	}
	public static Integer getMyDiv() {
		return myDiv;
	}
	public static void setMyDiv(Integer myDiv) {
		Arithmetic.myDiv = myDiv;
	}
	public static Integer getMyRem() {
		return myRem;
	}
	public static void setMyRem(Integer myRem) {
		Arithmetic.myRem = myRem;
	}
	public static Integer getMySum()  {
		return mySum;
	}
	public static void setMySum(Integer mySum) {
		mySum = Arithmetic.mySum;
	}

	public static void Add(Integer intA, Integer intB) {
		mySum = intA + intB; 
		System.out.print(intA + " + " + intB + " = ");
		setMySum(mySum);
		
	}

	public static void Sub(Integer intA, Integer intB) {
		mySub = intA - intB; 
		System.out.print(intA + " - " + intB + " = ");
		setMySub(mySub);
		
	}	
	
	public static void Mult(Integer intA, Integer intB) {
		myMult = intA * intB; 
		System.out.print(intA + " * " + intB + " = ");
		setMyMult(myMult);
		
	}	
	public static void Div(Integer intA, Integer intB) {
		if(intA == 0 || intB == 0){
			System.out.print("Don't devide by zero! ");
			setMyDiv(null);
		}
		else{
			myDiv = intA / intB; 
			System.out.print(intA + " / " + intB + " = ");
			setMyDiv(myDiv);
		}
		
	}	
	public static void Rem(Integer intA, Integer intB) {
		if(intA == 0 || intB == 0){
			System.out.print("Don't devide by zero! ");
			setMyRem(null);
		}
		else{myRem = intA % intB; 
		System.out.print(intA + " % " + intB + " = ");
		setMyRem(myRem);
		
		}
	}
	
}