package a231019;

import java.util.*;
import java.io.*;

public class Main_g4_1504_특정한최단경로 {
	
	static int[][] mtrx;
	static int N, MAX = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		mtrx = new int[N+1][N+1];
		for(int e=0; e<E; e++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()),
				toto = Integer.parseInt(st.nextToken()),
				dist = Integer.parseInt(st.nextToken());
			mtrx[from][toto] = dist; mtrx[toto][from] = dist;
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken()),
			v2 = Integer.parseInt(st.nextToken());
			
		int[] from1  = Dijkstra(1, new boolean[N+1]),
			  fromv1 = Dijkstra(v1, new boolean[N+1]),
			  fromv2 = Dijkstra(v2, new boolean[N+1]);
		int dist1 = MAX, dist2 = MAX;
		if(from1[v1]!=MAX && fromv1[v2]!=MAX && fromv2[N]!=MAX) dist1 = from1[v1] + fromv1[v2] + fromv2[N];
		if(from1[v2]!=MAX && fromv2[v1]!=MAX && fromv1[N]!=MAX) dist2 = from1[v2] + fromv2[v1] + fromv1[N];
		int answer = dist1<dist2? dist1: dist2;
		answer = answer==MAX? -1: answer;
		System.out.println(answer);
	}
	
	static int[] Dijkstra(int from, boolean[] v) {
		int[] result = new int[N+1];
		Arrays.fill(result, Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((v1, v2)->v1[1]-v2[1]);
		result[from] = 0;
		pq.offer(new int[] {from, 0});
		while(!pq.isEmpty()) {
			int[] c = pq.poll();
			int cNumb = c[0], cDist = c[1];
			if(v[cNumb]) continue;
			v[cNumb] = true;
			for(int n=1; n<=N; n++) {
				if(mtrx[cNumb][n]!=0) {
					int nDist = cDist+mtrx[cNumb][n];
					if(result[n]>nDist) {
						result[n] = nDist;
						pq.offer(new int[] {n, nDist});
					}
				}
			}
		}
		return result;
	}
}
