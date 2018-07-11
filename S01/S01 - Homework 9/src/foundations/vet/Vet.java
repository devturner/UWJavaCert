package foundations.vet;

import java.util.ArrayList;
import foundations.pet.GroomablePet;
import foundations.pet.Pet;

public class Vet {

	private ArrayList<Pet> pets = new ArrayList<Pet>();

	// adds a pet to the array
	public void checkIn(Pet pPet) {
		pets.add(pPet);

	}

	// removes a pet from the array
	public void checkOut(Pet pPet) {
		pets.remove(pPet);
	}

	// this grooms the groomable pets

	public void groom() {
		for (int i = 0; i < pets.size(); i++) {
			Pet p = pets.get(i);
			if (p instanceof GroomablePet) {
				GroomablePet gp = (GroomablePet) p;
				gp.groom();

			}
		}
	}

	// this vaccinates the pets in the array
	public void vaccinate() {
		foundations.pet.Pet.vaccinate();

		//this is not the way it should have been done, this vaccinates the entire pet class, not the pets in the array list
		//should be done with the same way that the groom was completed.


	}

	// returns number of pets
	public int getNumberOfPatients() {
		int number = pets.size();
		return number;
	}

	public void takeCare() {
		System.out.println("Take Care!");
	}

}

/*
 * contains an ArrayList of Pets. Best to declare this at Class scope, and
 * instantiate to a new ArrayList object in the constructor.
 *
 * defines a checkIn(Pet) method which adds the pet to the ArrayList.
 *
 * defines a checkOut(Pet) method which removes the pet from the ArrayList.
 *
 * defines a groom() method. Checks each checkedIn Pet to see if instanceof
 * Groomable, then calls groom() on the pet.
 *
 * defines a vaccinate() method. Calls vaccinate() on each checkedIn Pet.
 *
 * defines a getNumberOfPatients() method, which returns the number of Pets in
 * the checkedIn ArrayList.
 */