package etc;

import java.io.*;
import java.util.*;

public class d10_bj_g5_7576_토마토 {
	private static int M, N, tomatos;
	private static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	private static int[][] box;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomatos = 0;
		box = new int [N][M];
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		for(int n=0; n<N; n++){
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++){
				box[n][m] = Integer.parseInt(st.nextToken());
				if(box[n][m]==0) tomatos++;
				else if(box[n][m]==1) queue.offerLast(new int[] {0, n, m});
			}
		}
		System.out.println(ripening(queue));
	}

	private static int ripening(ArrayDeque<int[]> queue){
		if(tomatos==0) return 0;
		int days = 0;
		while(!queue.isEmpty()){
			int[] ripen = queue.pollFirst();
			days = ripen[0];
			for(int d=0; d<4; d++){
				int newR = ripen[1]+dr[d];
				int newC = ripen[2]+dc[d];
				if(canRipen(newR, newC)){
					box[newR][newC] = 1;
					tomatos--;
					queue.offerLast(new int[] {days+1, newR, newC});
				}
			}
		}
		if(tomatos!=0) return -1;
		return days;
	}

	private static boolean canRipen(int r, int c){
		if(0>r || r>=N || 0>c || c>=M || box[r][c]!=0) return false;
		return true;
	}
}
