package a231012;

import java.util.*;
import java.io.*;

public class Main_g4_17478 {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N= Integer.parseInt(st.nextToken()), M= Integer.parseInt(st.nextToken());
		st= new StringTokenizer(br.readLine());
		int F= Integer.parseInt(st.nextToken()), answer= M;
		
		if(F==0) {
			System.out.println(M);
			return;
		}
		
		parent = new int[N+1];
		for(int n=1; n<=N; n++) parent[n] = n;
		
		boolean[] fact = new boolean[N+1];
		for(int f=0; f<F; f++) fact[Integer.parseInt(st.nextToken())] = true;
		
		int[][] party= new int[M][];
		
		for(int m=0; m<M; m++) {
			st= new StringTokenizer(br.readLine());
			int P= Integer.parseInt(st.nextToken());
			party[m]= new int[P];
			
			for(int p=0; p<P; p++) party[m][p] = Integer.parseInt(st.nextToken());
			if(P==1) continue;
			for(int p=1; p<P; p++) {
				union(party[m][p-1], party[m][p]);
			}
		}
		
		for(int n=1; n<=N; n++) {
			if(fact[n]) {
				int fn= find(n);
				for(int nn=1; nn<=N; nn++) {
					int fnn= find(nn);
					if(fn== fnn && !fact[nn]) fact[nn] = true;
				}
			}
		}
		
		for(int m=0; m<M; m++) {
			int L = party[m].length;
			boolean dontBluff = false;
			
			for(int l=0; l<L; l++) {
				if(fact[party[m][l]]) {
					dontBluff = true;
					break;
				}
			}
			if(dontBluff) answer--;
		}
		System.out.println(answer);
		
		br.close();
	}
	
	private static int find(int x) {
		if(x==parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}
	
	private static void union(int x, int y) {
		int px= find(x), py= find(y);
		if(px==py) return;
		parent[py]= px;
	}
}