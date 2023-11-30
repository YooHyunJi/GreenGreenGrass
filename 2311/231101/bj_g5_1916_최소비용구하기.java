package a231102;

import java.util.*;
import java.io.*;

public class Main_g5_1916_최소비용구하기 {
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine()),
    		M = Integer.parseInt(br.readLine()),
    		arr[][] = new int[N+1][N+1],
    		min[] = new int[N+1];
    	boolean v[] = new boolean[N+1];
    	for(int n=1; n<=N; n++)	Arrays.fill(arr[n], -1);
    	Arrays.fill(min, Integer.MAX_VALUE);
    	
    	for(int m=0; m<M; m++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int from = Integer.parseInt(st.nextToken()),
    	    	toto = Integer.parseInt(st.nextToken()),
	    		dist = Integer.parseInt(st.nextToken());
    		if(arr[from][toto]==-1 || arr[from][toto]>dist) arr[from][toto] = dist; }
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int from = Integer.parseInt(st.nextToken()),
    		toto = Integer.parseInt(st.nextToken());
    	Dijkstra(from, arr, N, min, v);
    	System.out.println(min[toto]);
    }
    static void Dijkstra(int from, int[][] arr, int N, int[] min, boolean[] v) {
    	PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]);
    	pq.offer(new int[] {from, 0});
    	min[from] = 0;
    	while(!pq.isEmpty()) {
    		int[] now = pq.poll();
    		int num = now[0],
    			sum = now[1];
    		v[num] = true;
    		for(int n=1; n<=N; n++) {
    			if(!v[n] && arr[num][n]!=-1 && min[n]>sum+arr[num][n]) {
    				int newMin = sum+arr[num][n];
    				pq.offer(new int[] {n, newMin});
    		    	min[n] = newMin; }}}
    }
}
