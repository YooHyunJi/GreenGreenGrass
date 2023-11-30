package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_b1_1259_팰린드롬수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = br.readLine();
			if(line.equals("0")) return;
			System.out.println(palindrome(line));
		}
	}

	private static String palindrome(String line) {
		for(int i = 0; i< line.length()/2; i++){
			char front = line.charAt(i);
			char back = line.charAt(line.length()-1-i);
			if(front != back) return "no";
		}
		return "yes";
	}
}