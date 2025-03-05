package a2503;

import java.io.*;
import java.util.*;

public class d05_bj_s2_24480_알고리즘_수업_깊이_우선_탐색_2 {

    static int N, M, R, cnt = 0;
    static int[] answer;
    static List<Integer>[] graph;
    static boolean[] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        answer = new int[N+1];
        graph = new ArrayList[N+1];
        for(int n=1; n<=N; n++){
            graph[n] = new ArrayList<>();
        }
        visit = new boolean[N+1];

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        for(int n=1; n<=N; n++){
            Collections.sort(graph[n], Collections.reverseOrder());
        }

        DFS(R);

        for(int n=1; n<=N; n++){
            sb.append(answer[n]).append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int num){
        if(0 < answer[num]){
            return;
        }
        answer[num] = ++cnt;
        for(int neighbor: graph[num]){
            if(visit[neighbor]){
                continue;
            }
            visit[neighbor] = true;
            DFS(neighbor);
            visit[neighbor] = false;
        }
    }
}
