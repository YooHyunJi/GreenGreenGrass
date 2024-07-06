package a2407;

import java.io.*;
import java.util.*;

public class d06_bj_s1_11403_경로_찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                graph[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for(int r=0; r<N; r++){
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            boolean[] visit = new boolean[N];
            for(int c=0; c<N; c++){
                if(graph[r][c] == 1){
                    visit[c] = true;
                    queue.offerLast(c);
                }
            }
            while(!queue.isEmpty()){
                int now = queue.pollFirst();
                for(int d=0; d<N; d++){
                    if(graph[now][d] == 1 && !visit[d]){
                        visit[d] = true;
                        queue.offerLast(d);
                        graph[r][d] = 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int rr=0; rr<N; rr++){
            for(int cc=0; cc<N; cc++){
                sb.append(graph[rr][cc]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
