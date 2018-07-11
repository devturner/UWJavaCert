package foundations.card.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import foundations.pet.Cat;
import foundations.pet.Dog;
import foundations.pet.Pet;
import foundations.pet.Rabbit;
import foundations.pet.Groomable;
import foundations.vet.Vet;

public class VetTest {

	Pet[] pets;
	Vet testVet;

	@Before
	public void setUp() {
		testVet = new Vet();
		pets = new Pet[7];
		pets[0] = new Dog();
		pets[1] = new Cat();
		pets[2] = new Rabbit();
		pets[3] = new Dog();
		pets[4] = new Cat();
		pets[5] = new Rabbit();
		pets[6] = new Dog();
		for (Pet p : pets)
			testVet.checkIn(p);
		
	}

	@Test
	public void dogTakeForAWalkTest() {
		assertEquals("Yap Yap!", ((Dog) pets[0]).takeForAWalk());
		System.out.println("the walked dog says: " + ((Dog) pets[0]).takeForAWalk());
	}

	@Test
	public void dogGroomTest() {
		assertTrue(((Groomable) pets[3]).needsGrooming());
		System.out.println("this needsGrooming DOG be (TRUE): " + (((Groomable) pets[3]).needsGrooming()));
		((Groomable) pets[3]).groom();
		assertFalse(((Groomable) pets[3]).needsGrooming());
		System.out.println("this needsGrooming DOG be (FALSE): " + (((Groomable) pets[3]).needsGrooming()));
	}

	@Test
	public void catPetTest() {
		assertEquals("Purr Purr!", ((Cat) pets[1]).pet());
		System.out.println("the petted cat says: " + ((Cat) pets[1]).pet());
	}

	@Test
	public void catGroomTest() {
		assertTrue(((Groomable) pets[4]).needsGrooming());
		System.out.println("this needsGrooming CAT be (TRUE): " + (((Groomable) pets[4]).needsGrooming()));
		((Groomable) pets[4]).groom();
		assertFalse(((Groomable) pets[4]).needsGrooming());
		System.out.println("this needsGrooming CAT be (FALSE): " + (((Groomable) pets[4]).needsGrooming()));
	}

	@Test
	public void rabbitFeedTriscuits() {
		assertEquals("Crunch Crunch!", ((Rabbit) pets[2]).feedTriscuits());
		System.out.println("the fed rabbit says : " + ((Rabbit) pets[2]).feedTriscuits());
	}

	@Test
	public void vetGroomTest() {
		assertTrue(((Groomable) pets[3]).needsGrooming());
		System.out.println("Groomable is (TRUE) : " + ((Groomable) pets[3]).needsGrooming());
		assertTrue(((Groomable) pets[6]).needsGrooming());
		System.out.println("Groomable is (TRUE) : " + ((Groomable) pets[6]).needsGrooming());
		testVet.groom();
		assertFalse(((Groomable) pets[3]).needsGrooming());
		System.out.println("Groomable is (FALSE) : " + ((Groomable) pets[3]).needsGrooming());
		assertFalse(((Groomable) pets[6]).needsGrooming());
		System.out.println("Groomable is (FALSE) : " + ((Groomable) pets[6]).needsGrooming());
	}

	@Test
	public void takeCareTest() {
		// no real assertion on this one. But it should print out below
		testVet.takeCare();
	}

	@Test
	public void checkInTest() {
		assertEquals(7, testVet.getNumberOfPatients());
		testVet.checkIn(new Dog());
		assertEquals(8, testVet.getNumberOfPatients());
	}

	@Test
	public void checkOutTest() {
		assertEquals(7, testVet.getNumberOfPatients());		
		System.out.println("Should say 7: " + testVet.getNumberOfPatients());
		testVet.checkOut(pets[1]);
		testVet.checkOut(pets[4]);
		assertEquals(5, testVet.getNumberOfPatients());
		System.out.println("Should say 5: " + testVet.getNumberOfPatients());
		// this shouldn't remove anything
		testVet.checkOut(new Cat());
		assertEquals(5, testVet.getNumberOfPatients());
		System.out.println("Should say 5: " + testVet.getNumberOfPatients());
	}

	@Test
	public void vaccinateTest() {
		assertFalse(pets[0].isVaccinated());
		System.out.println("this isVaccinated should be (FALSE): " + pets[0].isVaccinated());
		assertFalse(pets[5].isVaccinated());
		System.out.println("this isVaccinated should be (FALSE): " + pets[5].isVaccinated());
		testVet.vaccinate();
		assertTrue(pets[0].isVaccinated());
		System.out.println("this isVaccinated should be (TRUE): " + pets[0].isVaccinated());
		assertTrue(pets[5].isVaccinated());
		System.out.println("this isVaccinated should be (TRUE): " + pets[5].isVaccinated());
	}

}