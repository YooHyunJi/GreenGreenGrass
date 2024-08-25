package a2408;

import java.io.*;
import java.util.*;

public class d25_bj_s2_5567_결혼식 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[][] graph = new boolean[N+1][N+1];
        for(int m=0; m<M; m++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
            graph[b][a] = true;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int n=2; n<=N; n++){
            if(!graph[1][n]){ continue; }
            set.add(n);
            for(int nn=2; nn<=N; nn++){
                if(!graph[n][nn]){ continue; }
                set.add(nn);
            }
        }
        System.out.println(set.size());
    }
}
