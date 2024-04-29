package a2404;

import java.io.*;
import java.util.*;

public class d29_bj_s2_11724_연결_요소의_개수 {
    static int[] p;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        p = new int[N+1];
        boolean[] visit = new boolean[N+1];
        for(int n=1; n<=N; n++){ p[n] = n; }
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }
        int answer = 0;
        for(int n=1; n<=N; n++){
            if(visit[p[p[n]]]){ continue; }
            visit[p[p[n]]] = true;
            answer++;
        }
        System.out.println(answer);
    }

    static int find(int x){
        if(p[x] == x){ return x; }
        return p[x] = find(p[x]);
    }

    static void union(int x, int y){
        int px = find(x), py = find(y);
        if(px == py){ return; }
        if(px < py){ p[py] = px; }
        else{ p[px] = py; }
    }
}