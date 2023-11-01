package a231102;

import java.util.*;
import java.io.*;

public class Main_g5_1916_최소비용구하기 {
	static class Node{
		int	 num; int  dis; Node nxt;
		public Node(int num, int dis, Node nxt) { this.num = num; this.dis = dis; this.nxt = nxt; }
		@Override public String toString() { return "num: "+num+", dis: "+dis+" / "+nxt; }}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()),
			E = Integer.parseInt(st.nextToken()),
			K = Integer.parseInt(br.readLine());
		lst = new Node[V+1];
		min	 = new int[V+1];
		vst	 = new boolean[V+1];
		Arrays.fill(min, Integer.MAX_VALUE);
		for(int e=0; e<E; e++) {
			st = new StringTokenizer(br.readLine());
			int fr = Integer.parseInt(st.nextToken()),
				to = Integer.parseInt(st.nextToken()),
				di = Integer.parseInt(st.nextToken());
			Node newNode = new Node(to, di, lst[fr]);
			lst[fr] = newNode; }
		Dijkstra(V, K);
		for(int v=1; v<=V; v++) System.out.println(min[v]==Integer.MAX_VALUE? "INF": min[v]); }
	
	static Node[]	 lst;
	static int[]	 min;
	static boolean[] vst;
	
	private static void Dijkstra(int V, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((n1, n2)->n1[1]-n2[1]);
		vst[k] = true;
		pq.offer(new int[] {k, 0});
		min[k] = 0;
		while(!pq.isEmpty()) {
			int now[] = pq.poll(), 
				num = now[0],
				dis = now[1];
			vst[num] = true;
			Node ptr = lst[num];
			while(ptr != null) {
				int newDis = dis + ptr.dis;
				if(!vst[ptr.num] && newDis < min[ptr.num]) {
					min[ptr.num] = newDis;
					pq.offer(new int[] {ptr.num, newDis}); }
				ptr = ptr.nxt; }}}
}
