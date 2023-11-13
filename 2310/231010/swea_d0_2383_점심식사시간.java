package a1010.offline;

import java.util.*;
import java.io.*;

public class Solution_d0_2383_점심식사시간_서울_20반_유현지 {
	static int[][]	room, people, stair;
	static int[]	goTo;
	static int		N, P, S, answer;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d0_2383.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			P = 0;
			S = 0;
			room = new int[N][N];
			stair = new int[2][3];
			people = new int[10][2];
			
			for(int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					room[r][c] = Integer.parseInt(st.nextToken());
					if(room[r][c]>1) {
						stair[S][0] = r; stair[S][1] = c; stair[S++][2] = room[r][c];
					}
					else if(room[r][c]==1) {
						people[P][0] = r; people[P++][1] = c;}}}
			goTo = new int[P];
			subset(0);
			sb.append("#").append(t).append(" ").append(answer).append("\n");}
		System.out.println(sb.toString());
		br.close();
	}
	
	private static void subset(int cnt) {
		if(cnt==P) { answer = Math.min(answer, Math.max(downstairs(0), downstairs(1))); return; }
		goTo[cnt] = 0;
		subset(cnt+1);
		goTo[cnt] = 1;
		subset(cnt+1);}
	
	private static int downstairs(int dest) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int p=0; p<P; p++) if(goTo[p]==dest) pq.offer(dist(people[p], dest));
		List<Integer> using = new ArrayList<Integer>();
		List<Integer> going = new ArrayList<Integer>();
		while(!pq.isEmpty()) going.add(pq.poll());
		
		int time = 0;
		while(true) {
			if(time++ >= answer) return Integer.MAX_VALUE;
			if(going.size()==0) {
				int max = 0;
				for(int t: using) if(t>max) max = t;
				return time+max;}
			for(int t=using.size()-1; t>=0; t--) {
				using.set(t, using.get(t)-1);
				if(using.get(t)==0) using.remove(t);}
			for(int t=going.size()-1; t>=0; t--) {
				if(going.get(t)>0) going.set(t, going.get(t)-1);
				if(going.get(t)==0) {
					if(using.size()<3) {
						using.add(stair[dest][2]);
						going.remove(t);}
					else continue;}}}}
	
	private static int dist(int[] people, int dest) {
		return Math.abs(stair[dest][0]-people[0]) + Math.abs(stair[dest][1]-people[1]);
	}
}