public class SummerDelivery {
	private static TropicalJuice tropicalJuice = new TropicalJuice();
	private static TropicalJuice.JuiceMan juiceMan = tropicalJuice.new JuiceMan();

	public static void main(String[] args) {
		for (String order: args) {
			switch(order) {
				case "PEACH_TENTATION":
					System.out.println("Peach Tentation Order...");
					juiceMan.preparePeachTentation();
					break;
				case "FROZZEN_APPLE":
					System.out.println("Frozzen Apple Order...");
					juiceMan.prepareFrozzenApple();
					break;
				default:
					System.out.println("Unexpected Order...");
					break;
			}
		}	
	}
}