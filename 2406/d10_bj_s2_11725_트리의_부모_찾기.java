package a2406;

import java.io.*;
import java.util.*;

public class d10_bj_s2_11725_트리의_부모_찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        int[] p = new int[N+1];
        for(int n=1; n<=N; n++){
            graph[n] = new ArrayList<>();
        }

        for(int n=0; n<N-1; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(1);
        p[1] = 1;
        while(!queue.isEmpty()){
            int now = queue.pollFirst();
            for(int n: graph[now]){
                if(p[n]==0){
                    queue.offerLast(n);
                    p[n] = now;
                }
            }
        }
        for(int n=2; n<=N; n++){
            sb.append(p[n]).append("\n");
        }
        System.out.println(sb);
    }
}
