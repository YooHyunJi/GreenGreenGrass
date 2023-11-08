package a231109;

import java.util.*;
import java.io.*;

public class Main_g5_2096_내려가기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map	  = new int[N][4],
				dpMin = new int[N][5],
				dpMax = new int[N][5];
		for(int n=0; n<N; n++) {
			Arrays.fill(dpMin[n], 900_001);
			Arrays.fill(dpMax[n], -1);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=1; c<=3; c++)  map[n][c] = Integer.parseInt(st.nextToken());
		}
		for(int c=1; c<=3; c++) dpMax[0][c] = dpMin[0][c] = map[0][c];
		for(int n=1; n<N; n++) {
			for(int c=1; c<=3; c++) {
				dpMax[n][c] = map[n][c] + Math.max(dpMax[n-1][c-1], Math.max(dpMax[n-1][c], dpMax[n-1][c+1]));
				dpMin[n][c] = map[n][c] + Math.min(dpMin[n-1][c-1], Math.min(dpMin[n-1][c], dpMin[n-1][c+1]));
			}
		}
		System.out.println(
				Math.max(dpMax[N-1][1], Math.max(dpMax[N-1][2], dpMax[N-1][3]))+" "+
				Math.min(dpMin[N-1][1], Math.min(dpMin[N-1][2], dpMin[N-1][3]))
		);
	}
}
