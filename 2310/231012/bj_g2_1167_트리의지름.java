package a231012;

import java.util.*;

import java.io.*;

public class Main_g2_1167_트리의지름 {
	
	static Node[] list;
	static boolean[] visit;
	static int mVertex = -1;
	static int[] mDist = new int[2];
	
	static class Node {
		int  num;
		int  dst;
		Node nxt;
		
		public Node(int num, int dst, Node nxt) {
			this.num = num;
			this.dst = dst;
			this.nxt = nxt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		list = new Node[V+1];
		visit = new boolean[V+1];
		
		for(int v=1; v<=V; v++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			while(true) {
				int toto = Integer.parseInt(st.nextToken()); if(toto==-1) break;
				int dist = Integer.parseInt(st.nextToken());
				Node node = new Node(toto, dist, list[from]);
				list[from] = node; }}
		dfs(1, 0, 0);
		visit = new boolean[V+1];
		dfs(mVertex, 0, 1);
		System.out.println(mDist[1]);
	}
	
	static void dfs(int v, int dist, int round) {
		visit[v] = true;
		if(dist > mDist[round]) {
			mDist[round] = dist;
			mVertex = v;
		}
		for(Node n=list[v]; n!=null; n=n.nxt) {
			if(!visit[n.num]) dfs(n.num, dist+n.dst, round);
		}
	}
}