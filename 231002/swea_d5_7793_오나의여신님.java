package a0927.offline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution_d5_7793_오나의여신님_서울_20반_유현지 {
	static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static int answer, R, C;
	static char[][] map;
	static ArrayDeque<int[]> q_water = new ArrayDeque<int[]>();
	static ArrayDeque<int[]> q_dochi = new ArrayDeque<int[]>();
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			answer = Integer.MAX_VALUE/2;
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			q_water.clear();
			q_dochi.clear();
			
			for(int r=0; r<R; r++) {
				String line = br.readLine();
				map[r] = line.toCharArray();
				for(int c=0; c<C; c++) {
					if(map[r][c]=='*') q_water.offer(new int[] {r, c});
					if(map[r][c]=='S') q_dochi.offer(new int[] {r, c});
				}
			}
			bfs();
			sb.append("#").append(t).append(" ").append(answer==Integer.MAX_VALUE/2? "GAME OVER": answer).append("\n");
		}
		System.out.println(sb.toString());
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
			}
		}
	}
}