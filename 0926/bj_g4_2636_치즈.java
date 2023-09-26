import java.util.*;
import java.io.*;

public class Main {
	static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	
	private static int bfs(int r, int c, int[][] arr, boolean[][] v) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c});
		v[r][c] = true;
		int border = 0;
		
		while(!q.isEmpty()) {
			int[] rc = q.poll();
			r = rc[0];
			c = rc[1];
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d], nc = c+dc[d];
				if(0<=nr&&nr<arr.length && 0<=nc&&nc<arr[0].length && !v[nr][nc]) {
					v[nr][nc] = true;
					if(arr[nr][nc]==0) {
						q.offer(new int[] {nr, nc});					
					}else {
						border++;
						arr[nr][nc] = 0;
					}
				}
			}
		}
		return border;
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int wholeCheese = 0, cheese = 0, cnt = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) wholeCheese++;
			}
		}
		
		while(wholeCheese>0) {
			cnt++;
			boolean[][] v = new boolean[N][M];
			cheese = bfs(0, 0, arr, v);
			wholeCheese -= cheese;
		}
		System.out.println(cnt);
		System.out.println(cheese);
	}
}