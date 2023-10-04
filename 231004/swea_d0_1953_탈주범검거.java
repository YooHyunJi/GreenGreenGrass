package a1004.offline;

import java.util.*;
import java.io.*;

public class Solution_d__1953_탈주범검거_서울_20반_유현지 {
	private static boolean[][] v;
	private static int[][] map;
	private static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	private static int N, M;
	private static int[][] root = {{1, 2, 5, 6}, {1, 3, 6, 7}, {1, 2, 4, 7}, {1, 3, 4, 5}};
	
	private static int tunnel(int[][] map, int R, int C, int L) {
		int total=1;
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {R, C, 1}); // r좌표, c좌표, 진출 단계
		v[R][C] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int r=now[0], c=now[1], l=now[2], type=map[r][c];
			int start=0, end=4, size=1;
			
			if(l==L) return total;
			
			switch(type) {
			case 0: 				 continue;
			case 1: 				 break;
			case 2: size++; 		 break;
			case 3: start++; size++; break;
			case 4: end=2; 			 break;
			case 5: start++; end--;  break;
			case 6: start=2; 		 break;
			case 7: size=3; 		 break;
			}
			for(int d=start; d<end; d+=size) {
				int nr = r+dr[d], nc = c+dc[d];
				if(0<=nr&&nr<N && 0<=nc&&nc<M && !v[nr][nc] && map[nr][nc]!=0) {
					for(int i=0; i<4; i++) {
						if(map[nr][nc] == root[d][i]) { 
							q.offer(new int[] {nr, nc, l+1});
							v[nr][nc] = true;
							total++;
		}}}}}
		return total;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d__1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			v = new boolean[N][M];
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m=0; m<M; m++) map[n][m] = Integer.parseInt(st.nextToken());
			}
			int answer = tunnel(map, R, C, L);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
