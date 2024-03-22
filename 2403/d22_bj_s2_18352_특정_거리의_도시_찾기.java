package a2403;

import java.io.*;
import java.util.*;

public class d22_bj_s2_18352_특정_거리의_도시_찾기 {
    static class Node{
        int num;
        boolean v;
        ArrayList<Integer> connected;

        public Node(int num){
            this.num = num;
            this.v = false;
            this.connected = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] dist = new int[N+1];
        Node[] graph = new Node[N+1];
        for(int n=1; n<=N; n++){
            graph[n] = new Node(n);
            dist[n] = Integer.MAX_VALUE;
        }
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].connected.add(B);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{X, 0});
        dist[X] = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int nIdx = now[0];
            int nDist = now[1];
            if(graph[nIdx].v){ continue; }
            graph[nIdx].v = true;
            for(int c: graph[nIdx].connected){
                if(graph[c].v){ continue; }
                if(dist[c] > nDist + 1){
                    dist[c] = nDist + 1;
                    pq.offer(new int[] {c, dist[c]});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int n=1; n<=N; n++){ { if(dist[n] == K){ sb.append(n).append("\n"); } } }
        System.out.println(sb.length()==0? "-1": sb);
    }
}
