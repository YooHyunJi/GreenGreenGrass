package a1004.offline;

import java.util.*;
import java.io.*;

public class Solution_d4_5643_키순서_서울_20반_유현지2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine()), answer = 0;
			boolean[][] map = new boolean[N+1][N+1];
			
			for(int m=0; m<M; m++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
				map[a][b] = true;
			}
			
			ArrayDeque<Integer> q = new ArrayDeque<Integer>();
			for(int r=1; r<=N; r++) {
				for(int c=1; c<=N; c++) if(map[r][c]) q.offer(c);
				while(!q.isEmpty()) {
					int nr = q.poll();
					for(int nc=1; nc<=N; nc++) {
						if(map[nr][nc] && !map[r][nc]) {
							q.offer(nc);
							map[r][nc] = true;
						}}}}
			
			for(int r=1, cnt=0; r<=N; r++, cnt=0) {
				for(int c=1; c<=N; c++) { if(map[r][c] || map[c][r]) cnt++; }
				if(cnt+1==N) answer++;
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
