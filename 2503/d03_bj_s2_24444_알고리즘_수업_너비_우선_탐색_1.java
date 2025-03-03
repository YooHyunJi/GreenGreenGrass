package a2503;

import java.io.*;
import java.util.*;

public class d03_bj_s2_24444_알고리즘_수업_너비_우선_탐색_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int n=1; n<=N; n++){
            graph[n] = new ArrayList<Integer>();
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int n=1; n<=N; n++){
            if(graph[n].isEmpty()){
                continue;
            }
            Collections.sort(graph[n]);
        }

        int[] answer = new int[N+1];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[N+1];
        queue.offerLast(new int[] {0, R});
        visit[R] = true;
        int cnt = 1;
        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int d = now[0];
            int n = now[1];
            answer[n] = cnt++;
            for (int next: graph[n]){
                if(visit[next]){
                    continue;
                }
                queue.offerLast(new int[] {d+1, next});
                visit[next] = true;
            }
        }

        for(int n=1; n<=N; n++){
            sb.append(answer[n]).append("\n");
        }
        System.out.println(sb);
    }
}

