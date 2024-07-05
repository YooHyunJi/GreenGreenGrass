package a2407;

import java.io.*;
import java.util.*;

public class d05_bj_s1_1389_케빈_베이컨의_6단계_법칙 {
    static int N;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int n=1; n<=N; n++){ graph[n] = new ArrayList<>(); }
        int M = Integer.parseInt(st.nextToken());
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            graph[B].add(A);
        }
        int kevin = 0, min = Integer.MAX_VALUE;
        for(int n=1; n<=N; n++){
            int result = Dijkstra(n);
            if(min <= result){ continue; }
            min = result;
            kevin = n;
        }
        System.out.println(kevin);
    }

    static int Dijkstra(int start){
        int result = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[1]-o2[1]));
        boolean[] visit = new boolean[N+1];
        visit[start] = true;
        queue.offer(new int[]{start, 0});
        int[] min = new int[N+1];
        for(int d=1; d<=N; d++){ min[d] = Integer.MAX_VALUE; }
        min[start] = 0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int num = now[0];
            int dist = now[1] + 1;
            for(int d: graph[num]){
                if(min[d] < dist || visit[d]){ continue; }
                min[d] = dist;
                queue.offer(new int[]{d, dist});
                visit[d] = true;
                result += dist;
            }
        }
        return result;
    }
}
