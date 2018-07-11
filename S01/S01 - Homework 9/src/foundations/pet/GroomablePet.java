package foundations.pet;


public abstract class GroomablePet extends Pet implements Groomable {

	private boolean needsGrooming = true;

	public void groom() {
		needsGrooming = false;
	}

	public boolean needsGrooming() {
		return needsGrooming;
	}
}

/*
 * GroomablePet abstract class
 * 
 * X - extends Pet and implements Groomable 
 * 
 * X - contains a boolean member needsGrooming. On construction, this is set to true.
 * 
 * X - groom method changes needsGrooming to false.
 * 
 * 
 * X - needsGrooming returns the needsGrooming variable.
 */