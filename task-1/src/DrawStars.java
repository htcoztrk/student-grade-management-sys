
public class DrawStars {

	public static void main(String[] args) {
		int number = 7;
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j < number; j++) {
				if (i <= j) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}

			}
			number--;
			System.out.println("");
		}
	}

}
