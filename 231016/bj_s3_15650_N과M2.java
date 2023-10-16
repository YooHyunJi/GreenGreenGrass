package etc;

import java.util.*;
import java.io.*;

public class Main_s3_15650_N과M2 {
	
	static int N, M;
	static int[] arr, answer;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i=1; i<=N; i++) arr[i-1] = i;
		answer = new int[M];
		v = new boolean[N];
		perm(0, 0);
	}
//	static void perm(int cnt, int start) {
//		if(cnt==M) {
//			for(int i=0; i<M; i++) System.out.print(answer[i]+" "); System.out.println();
//			return;
//		}
//		for(int i=start; i<N; i++) {
//			
//			answer[cnt] = arr[i];
//			v[i] = true;
//			perm(cnt+1, start+1);
//		}
//	}
	
	static void perm(int cnt, int prev) {
		if(cnt==M) {
			for(int i=0; i<M; i++) System.out.print(answer[i]+" "); System.out.println();
			return;
		}
		for(int i=cnt; i<N; i++) {
			if(v[i]||arr[i]<prev) continue;
			answer[cnt] = arr[i];
			v[i] = true;
			perm(cnt+1, arr[i]);
			v[i] = false;
		}
	}

}
