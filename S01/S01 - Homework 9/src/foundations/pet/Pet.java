package foundations.pet;


public abstract class Pet {
	private static boolean isVaccinated = false;

	public static void vaccinate(){
		isVaccinated = true;
	}
	
	public boolean isVaccinated() {
		return isVaccinated;
	}
}
/*
 * 
 * x - contains a boolean member for isVaccinated. On construction, this is set
 * to false.
 * 
 * x - vaccinate method changes the isVaccinated method to true.
 * 
 * x - isVaccinated method returns the isVaccinated variable.
 */