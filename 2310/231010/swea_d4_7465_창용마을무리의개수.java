package a1010.offline;

import java.util.*;
import java.io.*;

public class Solution_d4_7465_창용마을무리의개수_서울_20반_유현지 {
	static int[] p;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_7465.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()),
				M = Integer.parseInt(st.nextToken()),
				answer = N;
			p = new int[N+1];
			for(int n=1; n<=N; n++) p[n] = n;
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()),
					y = Integer.parseInt(st.nextToken());
				if(find(x)==find(y)) continue;
				union(x, y);
				answer--;
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}	
		System.out.println(sb.toString());
		br.close();
	}
	
	private static int find(int x) {
		if(p[x]==x) return x;
		return p[x] = find(p[x]);
	}

	private static void union(int x, int y) {
		int px = find(x), py = find(y);
		p[py] = px;
	}

}