package a2507;

import java.io.*;
import java.util.*;

public class d15_bj_g5_2660_회장뽑기 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] graph = new boolean[N+1][N+1];
        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1){ break; }
            graph[a][b] = true;
            graph[b][a] = true;
        }
        for(int i=1; i<=N; i++){
            boolean[] visit = new boolean[N+1];
            ArrayDeque<int[]> queue = new ArrayDeque<>();
            int max = 0;
            visit[i] = true;
            for(int j=1; j<=N; j++){
                if(graph[i][j]){
                    queue.offerLast(new int[] {1, j});
                    visit[j] = true;
                }
            }
            while(!queue.isEmpty()){
                int[] now = queue.pollFirst();
                int dist = now[0];
                int node = now[1];
                max = Math.max(max, dist);
                for(int j=1; j<=N; j++){
                    if(!graph[node][j] || visit[j]){ continue; }
                    queue.offerLast(new int[] {dist+1, j});
                    visit[j] = true;
                }
            }
            if(max < min){
                min = max;
                pq.clear();
            }
            if(max == min){
                pq.offer(i);
            }
        }
        sb.append(min).append(" ").append(pq.size()).append("\n");
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(sb);
    }
}
