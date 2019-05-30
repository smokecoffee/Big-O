package bigO.orange01.finalExam;

import java.util.Scanner;

public class ORANGE_L16P5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int i = 0;
		while (i < n) {
			int value = scan.nextInt();
			System.out.println(2*value - 2);
			i++;
		}

		scan.close();
		System.exit(0);
	}

	
}
