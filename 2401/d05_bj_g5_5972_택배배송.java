package a2401;

import java.io.*;
import java.util.*;

public class d05_bj_g5_5972_택배배송 {
    static class Node {
        int toto;
        int cost;
        Node next;

        public Node(int toto, int cost, Node next) {
            this.toto = toto;
            this.cost = cost;
            this.next = next;
        }
    }

    static int N, M;
    static int[] arr;
    static boolean[] v;
    static Node[] graph;

    static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        pq.offer(new int[] {1, 0});
        arr[1] = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int num = now[0];
            int cost = now[1];
            if(v[num]) continue;
            v[num] = true;
            Node ptr = graph[num];
            while(ptr!=null){
                if(arr[ptr.toto]>cost+ptr.cost){
                    arr[ptr.toto] = cost+ptr.cost;
                    pq.offer(new int[] {ptr.toto, cost+ptr.cost});
                }
                ptr = ptr.next;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        v = new boolean[N+1];
        graph = new Node[N+1];
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int toto = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from] = new Node(toto, cost, graph[from]);
            graph[toto] = new Node(from, cost, graph[toto]);
        }
        dijkstra();
        System.out.println(arr[N]);
    }
}