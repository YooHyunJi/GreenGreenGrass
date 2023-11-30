package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_b2_2920_음계 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().trim().toCharArray();
		switch (arr[0]-'0') {
			case 1:
				int d1 = 1;
				for (int i = 2; i < 16; i += 2) {
					if (arr[i] - '0' != ++d1) break;
				}
				if (d1 == 8) {
					System.out.println("ascending");
					return;
				}
				break;
			case 8:
				int d2 = 8;
				for (int i = 2; i < 16; i += 2) {
					if (arr[i] - '0' != --d2) break;
				}
				if (d2 == 1) {
					System.out.println("descending");
					return;
				}
				break;
		}
		System.out.println("mixed");
	}
}