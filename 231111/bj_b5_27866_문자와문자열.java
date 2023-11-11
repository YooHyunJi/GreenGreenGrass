package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.StringTokenizer;

public class Main_b5_27866_문자와문자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();
		int idx = Integer.parseInt(br.readLine())-1;
		System.out.printf(String.valueOf(string.charAt(idx)));
	}
}