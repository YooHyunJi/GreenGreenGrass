package etc;

import java.util.*;
import java.io.*;

public class d05_bj_b5_11382_꼬마정민 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;
		for(int n=0; n<3; n++) answer += Long.parseLong(st.nextToken());
		System.out.println(answer);
	}
}
