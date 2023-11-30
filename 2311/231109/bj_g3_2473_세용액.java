package a231109;

import java.util.*;
import java.io.*;

public class Main_g3_2473_세용액 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long answer = Long.MAX_VALUE;
		int N = Integer.parseInt(br.readLine()),
			lq1=-1, lq2=-1, lq3=-1;
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) arr[n] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		for(int i=0;i<N-2; i++) {
			int frnt = i+1, back = N-1;
			while(frnt < back) {
				long sum = (long)arr[i] + arr[frnt] + arr[back];
				if(sum==0) {
					lq1 = arr[i]; lq2 = arr[frnt]; lq3 = arr[back];
					System.out.println(lq1+" "+lq2+" "+lq3);
					return; }
				else if(answer > Math.abs(sum)) {
					answer = Math.abs(sum);
					lq1 = arr[i]; lq2 = arr[frnt]; lq3 = arr[back]; }
				else if(sum > 0) back--;
				else frnt++; } }
		System.out.println(lq1+" "+lq2+" "+lq3);
	}
}
