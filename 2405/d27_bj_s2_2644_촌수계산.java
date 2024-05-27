package a2405;

import java.io.*;
import java.util.*;

public class d27_bj_s2_2644_촌수계산 {
    static int N;
    static boolean[] v;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        v = new boolean[N+1];
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){ graph[i] = new ArrayList<>(); }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        System.out.println(BFS(A, B));
    }

    static int BFS(int A, int B){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        v[A] = true;
        queue.offerLast(new int[] {A, 0});

        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int num = now[0];
            int depth = now[1];
            if(num == B){ return depth; }
            for(int g: graph[num]){
                if(v[g]){ continue; }
                v[g] = true;
                queue.offerLast(new int[] {g, depth+1});
            }
        }
        return -1;
    }
}
