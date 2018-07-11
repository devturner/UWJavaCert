package com.foundations.calc;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcTests {

	
	@Test
		public void Add() {
		Arithmetic.Add(100, 50);
		assertEquals(Integer.valueOf(150), Arithmetic.getMySum());
		System.out.println(Arithmetic.getMySum());
		System.out.println();
	}
	@Test
		public void Sub() {
		Arithmetic.Sub(75, 50);
		assertEquals(Integer.valueOf(25), Arithmetic.getMySub());
		System.out.println(Arithmetic.getMySub());
		System.out.println();
	}
	@Test
		public void Mult() {
		Arithmetic.Mult(3, 50);
		assertEquals(Integer.valueOf(150), Arithmetic.getMyMult());
		System.out.println(Arithmetic.getMyMult());
		System.out.println();
	}
	@Test
		public void Div() {
		Arithmetic.Div(75, 3);
		assertEquals(Integer.valueOf(25), Arithmetic.getMyDiv());
		System.out.println(Arithmetic.getMyDiv());
		System.out.println();
	}
	@Test
		public void Rem() {
		Arithmetic.Rem(100, 3);
		assertEquals(Integer.valueOf(1), Arithmetic.getMyRem());
		System.out.println(Arithmetic.getMyRem());
		System.out.println();
	}
	
	
	
}


//http://www.tutorialspoint.com/java/number_valueof.htm
//http://stackoverflow.com/questions/1811103/java-junit-the-method-x-is-ambiguous-for-type-y