package a2508;

import java.io.*;
import java.util.*;

public class d08_bj_g4_10282_해킹 {

    static int N, D, C;
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken()) - 1;
            graph = new ArrayList[N];
            for(int n=0; n<N; n++){
                graph[n] = new ArrayList<>();
            }
            for(int d=0; d<D; d++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int s = Integer.parseInt(st.nextToken());
                graph[b].add(new int[]{a, s});
            }
            int[] result = Dijkstra();
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }
        System.out.println(sb);
    }

    static int[] Dijkstra(){
        int[] result = new int[2];
        int cnt = 0;
        int time = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{return o1[1] - o2[1];});

        boolean[] visit = new boolean[N];
        int[] arr_dist = new int[N];
        pq.offer(new int[] {C, 0});
        for(int n=0; n<N; n++){
            arr_dist[n] = Integer.MAX_VALUE;
        }
        arr_dist[C] = 0;

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int num = now[0];
            int dist = now[1];
            visit[num] = true;
            for(int[] neighbor: graph[num]){
                int nxt_num = neighbor[0];
                int nxt_dist = neighbor[1];
                int sum_dist = dist + nxt_dist;
                if(visit[nxt_num] || arr_dist[nxt_num] < sum_dist){
                    continue;
                }
                pq.offer(new int[] {nxt_num, sum_dist});
                arr_dist[nxt_num] = sum_dist;
            }
        }
        for(int n=0; n<N; n++){
            if(arr_dist[n] != Integer.MAX_VALUE){
                cnt++;
                time = Math.max(time, arr_dist[n]);
            }
        }
        result[0] = cnt;
        result[1] = time;

        return result;
    }
}
