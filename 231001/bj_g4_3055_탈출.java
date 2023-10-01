package a0927.offline;

import java.util.*;
import java.io.*;

public class Main_bj_3055_탈출_서울_20반_유현지 {
	static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static int answer = Integer.MAX_VALUE/2, R, C;
	static char[][] map;
	static ArrayDeque<int[]> q_water = new ArrayDeque<int[]>();
	static ArrayDeque<int[]> q_dochi = new ArrayDeque<int[]>();
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int r=0; r<R; r++) {
			String line = br.readLine();
			map[r] = line.toCharArray();
			for(int c=0; c<C; c++) {
				if(map[r][c]=='*') q_water.offer(new int[] {r, c});
				if(map[r][c]=='S') q_dochi.offer(new int[] {r, c});
			}
		}
		
		bfs();
		System.out.println(answer==Integer.MAX_VALUE/2? "KAKTUS": answer);
	}



	private static void bfs() {
		int round = 0;
		
		while(!q_dochi.isEmpty()) {
			round++;
			
			// spread water
			int len = q_water.size();
			for(int i=0; i<len; i++) {
				int[] water = q_water.poll();
				for(int d=0; d<4; d++) {
					int nr = water[0] + dr[d];
					int nc = water[1] + dc[d];
					if(0<=nr&&nr<R && 0<=nc&&nc<C && map[nr][nc]=='.'){
						map[nr][nc] = '*';
						q_water.offer(new int[] {nr, nc});
					}
				}
			}
			
			// dochi move
			len = q_dochi.size();
			for(int i=0; i<len; i++) {
				int[] dochi = q_dochi.poll();
				for(int d=0; d<4; d++) {
					int nr = dochi[0] + dr[d];
					int nc = dochi[1] + dc[d];
					if(0<=nr&&nr<R && 0<=nc&&nc<C){
						if(map[nr][nc]=='D') {
							answer = Math.min(answer, round);
							return;
						}
						else if(map[nr][nc]=='.') {
							map[nr][nc] = 'S';
							q_dochi.offer(new int[] {nr, nc});
						}
					}
				}
				map[dochi[0]][dochi[1]] = '.';
			}
		}
	}
}