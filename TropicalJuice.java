public class TropicalJuice {

	class Storage {
		public static final String PEACH_JUICE = "Peach juice";
		public static final String APPLE_JUICE = "Apple juice";
		public static final String LIMON_JUICE = "Limon juice";		
	}

	class Fridge {
		public static final String ICE_CUBES = "Ice cubes";
		public static final String CHERRY = "Cherry";
		public static final String LIMON_SHOT = "Limon shot";		
	}

	public class JuiceMan {
		public void preparePeachTentation() {
			System.out.println(String.format("Mixing a 250ml of %s with a %s and a few crushed %s.", 
				Storage.PEACH_JUICE, Fridge.LIMON_SHOT, Fridge.ICE_CUBES));
		}

		public void prepareFrozzenApple() {
			System.out.println(String.format("Mixing a 250ml of %s with 2 parts of crushed %s adding 100ml of %s.", 
				Storage.APPLE_JUICE, Fridge.ICE_CUBES, Storage.LIMON_JUICE));
		}
	}
}