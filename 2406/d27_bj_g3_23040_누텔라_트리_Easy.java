package a2406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class d27_bj_g3_23040_누텔라_트리_Easy {
    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        parent = new int[N+1];
        for(int n=1; n<=N; n++){
            graph[n] = new ArrayList<>();
            parent[n] = -1;
        }
        for(int n=0; n<N-1; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        String tmp = br.readLine();
        boolean[] red = new boolean[N+1];
        for(int i=1; i<=N; i++){
            red[i] = tmp.charAt(i-1)=='R';
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        HashSet<Integer> visit = new HashSet<>();
        queue.offerLast(1);
        visit.add(1);

        while(!queue.isEmpty()){
            int now = queue.pollFirst();
            for(int node: graph[now]){
                if(visit.contains(node)){ continue; }
                visit.add(node);
                if(red[now] && red[node]){ union(now, node); }
                queue.offerLast(node);
            }
        }

        long answer = 0;
        for(int i=1; i<=N; i++){
            if(red[i]){ continue; }
            visit = new HashSet<>();
            for(int node: graph[i]){
                if(!red[node] || visit.contains(find(node))){ continue; }
                visit.add(find(node));
                answer += -parent[find(node)];
            }
        }

        System.out.println(answer);
    }

    static int find(int x){
        if(parent[x] < 0){ return x; }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y){ return; }
        if(parent[x] < parent[y]){
            parent[x] += parent[y];
            parent[y] = x;
        }
        else{
            parent[y] += parent[x];
            parent[x] = y;
        }
    }
}
