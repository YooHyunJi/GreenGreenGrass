package a1010.offline;

import java.util.*;
import java.io.*;

public class Solution_d0_4013_특이한자석_서울_20반_유현지 {
	static boolean[][] gears = new boolean[4][8];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d0_4013.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int answer = 0;
			int K = Integer.parseInt(br.readLine());
			
			for(int r=0; r<4; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<8; c++) gears[r][c] = Integer.parseInt(st.nextToken())==1? true: false;
			}
			for(int k=0; k<K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int G = Integer.parseInt(st.nextToken())-1;
				boolean D = Integer.parseInt(st.nextToken())==1? true: false;
				process(G, D, new boolean[4]);
			}
			for(int d=0; d<4; d++) if(gears[d][0]) answer += (int)(Math.pow(2.0, d));
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void process(int G, boolean D, boolean[] v) {
		v[G] = true;
		if(G>0 && !v[G-1] && (gears[G-1][2]^gears[G][6]))	process(G-1, !D, v);
		if(G<3 && !v[G+1] && (gears[G][2]  ^gears[G+1][6])) process(G+1, !D, v);
		rotate(G, D);
	}

	private static void rotate(int G, boolean D) {
		// clockwise
		if(D) {
			boolean tmp = gears[G][7];
			for(int d=7; d>0; d--) gears[G][d] = gears[G][d-1];
			gears[G][0] = tmp;
		}
		// anti-clockwise
		else {
			boolean tmp = gears[G][0];
			for(int d=0; d<7; d++) gears[G][d] = gears[G][d+1];
			gears[G][7] = tmp;
		}
	}
}
