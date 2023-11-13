package a1010.offline;

import java.util.*;
import java.io.*;

public class Main_bj_17144_미세먼지안녕_서울_20반_유현지 {
	static int R, C, AC, answer;
	static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static int[][] room;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		AC = -1;
		room = new int[R][C];
		answer = 2;
		int T = Integer.parseInt(st.nextToken());
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
				answer += room[r][c];
				if(AC==-1 && room[r][c]==-1) AC = r;
			}
		}
		for(int t=0; t<T; t++) {
			room = diffuse();
			purify();
		}
		System.out.println(answer);
	}
	
	private static int[][] diffuse() {
		int[][] newRoom = new int[R][C];
		newRoom[AC][0] = newRoom[AC+1][0] = -1;
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(room[r][c]>0) {
					int div = room[r][c]/5;
					for(int d=0; d<4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if(0<=nr&&nr<R && 0<=nc&&nc<C && room[nr][nc]!=-1) {
							newRoom[nr][nc] += div;
							room[r][c] -= div;
					}}
					newRoom[r][c] += room[r][c];
		}}}
		return newRoom;
	}

	private static void purify() {
		int r = AC-1, c = 0;
		answer -= room[r--][c];
		for(int i=0; i<AC-1 ; i++) room[r+1][c] = room[r--][c];	r++; c++;
		for(int i=0; i<C-1 ; i++)  room[r][c-1] = room[r][c++]; r++; c--;
		for(int i=0; i<AC ; i++)   room[r-1][c] = room[r++][c]; r--; c--;
		for(int i=0; i<C-2 ; i++)  room[r][c+1] = room[r][c--]; 	 c++;
		room[r][c] = 0;
		
		r = AC+2; c = 0;
		answer -= room[r++][c];
		for(int i=0; i<R-AC-3 ; i++) room[r-1][c] = room[r++][c];	r--; c++;
		for(int i=0; i<C-1 ; i++) room[r][c-1]   = room[r][c++]; r--; c--;
		for(int i=0; i<R-AC-2 ; i++)  room[r+1][c]   = room[r--][c]; r++;c--;
		for(int i=0; i<C-2 ; i++) room[r][c+1] = room[r][c--]; c++;
		room[r][c] = 0;
	}
}
