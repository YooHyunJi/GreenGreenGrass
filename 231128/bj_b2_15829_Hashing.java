package etc;

import java.io.*;

public class Main_b2_15829_Hashing {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		char[] str = br.readLine().toCharArray();
		long answer = 0;
		long r = 1;
		for(int l=0; l<L; l++){
			answer += (str[l]-'a'+1)*r%1234567891;
			r = r * 31 % 1234567891;
		}
		System.out.println(answer%1234567891);
	}
}