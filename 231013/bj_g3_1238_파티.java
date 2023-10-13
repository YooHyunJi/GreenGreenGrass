package a231019;

import java.util.*;
import java.io.*;

public class Main_g3_1238_파티 {
	static boolean[] visit;
	static int[][] map;
	static int N, M, X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		int answer = 0;
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()),
				toto = Integer.parseInt(st.nextToken()),
				dist = Integer.parseInt(st.nextToken());
			map[from][toto] = dist; }
		int[] back = Dijkstra(X);
		for(int n=1; n<=N; n++) {
			Arrays.fill(visit, false);
			int[] gogo = Dijkstra(n);
			if(gogo[X]+back[n]>answer) answer = gogo[X]+back[n]; }
		System.out.println(answer); }
	
	static int[] Dijkstra(int V) {
		int[] result = new int[N+1];
		Arrays.fill(result, Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((v1, v2)->v1[1]-v2[1]);
		pq.offer(new int[] {V, 0});
		result[V] = 0;
		while(!pq.isEmpty()) {
			int[] village = pq.poll();
			int vNumb = village[0], vDist = village[1];
			if(visit[vNumb]) continue;
			for(int n=1; n<=N; n++) {
				if(map[vNumb][n]!=0) {
					int nDist = vDist+map[vNumb][n];
					if( result[n] > nDist) {
						result[n] = nDist;
						pq.offer(new int[] {n, nDist}); }}}}
		return result; }
}
