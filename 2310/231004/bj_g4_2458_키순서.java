package a1004.offline;

import java.util.*;
import java.io.*;

public class Main_bj_2458_키순서_서울_20반_유현지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), answer = 0;
		boolean[][] map = new boolean[N+1][N+1];
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
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
		System.out.println(answer);
	}
}
