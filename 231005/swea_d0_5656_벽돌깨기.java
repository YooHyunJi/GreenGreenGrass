package a1005.offline;

import java.util.*;
import java.io.*;

public class Solution_d0_5656_벽돌깨기_서울_20반_유현지 {
	static int		N, W, H, answer;
	static int[]	dr={-1, 0, 1, 0}, dc= {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d0_5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			answer = Integer.MAX_VALUE;
			int blocks = 0;
			int[][]	map = new int[H][W];
			
			for(int r=0; r<H; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c]!=0) blocks++;
				}
			}
			play(map, blocks, 0);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void play(int[][] map, int blocks, int marble) {
		if(blocks==0) answer = 0;
		if(answer==0) return;
		if(marble==N) {
			answer = Math.min(answer, blocks);
			return;
		}
		for(int c=0; c<W; c++) {
			for(int r=0; r<H; r++) {
				if(map[r][c]!=0) {
					int[][] copyMap = copy(map);
					int popped = pop(copyMap, new int[] {r, c, copyMap[r][c]});
					rearrange(copyMap);
					play(copyMap, blocks-popped, marble+1);
					break;
		}}}
	}

	private static int[][] copy(int[][] map){
		int[][] copyMap = new int[H][W];
		for(int r=0; r<H; r++) for(int c=0; c<W; c++) copyMap[r][c] = map[r][c];
		return copyMap;
	}
	
	private static int pop(int[][] map, int[] start) {
		int popped = 0;
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		map[start[0]][start[1]] = 0;
		q.offer(start);
		popped++;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nr = now[0], nc = now[1], np = now[2];
			
			for(int p=1; p<=np-1; p++) {
				for(int d=0; d<4; d++) {
					int rr = nr+dr[d]*p,
						cc = nc+dc[d]*p;
					if(0<=rr&&rr<H && 0<=cc&&cc<W && map[rr][cc]!=0) {
						q.offer(new int[] {rr, cc, map[rr][cc]});
						map[rr][cc] = 0;
						popped++;
		}}}}
		return popped;
	}
	
	private static void rearrange(int[][] map) {
		for(int c=0; c<W; c++) {
			int[] newCol = new int[H];
			int	len = H-1;
			for(int r=H-1; r>=0; r--) { if(map[r][c]!=0) newCol[len--] = map[r][c]; }
			for(int r=H-1; r>=0; r--) { map[r][c] = newCol[r]; }
		}
	}
}