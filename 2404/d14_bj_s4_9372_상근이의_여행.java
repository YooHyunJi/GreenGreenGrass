package a2404;

import java.io.*;
import java.util.*;

public class d14_bj_s4_9372_상근이의_여행 {
    static int[] p;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int left = N-1;
            int cnt = 0;
            p = new int[N+1];
            for(int i=1; i<=N; i++){ p[i] = i; }
            for(int m=1; m<=M; m++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int pa = find(a);
                int pb = find(b);
                if(pa == pb){ continue; }
                p[b] = find(a);
                cnt++;
                if(--left == 0){ sb.append(cnt).append("\n"); }
            }
        }
        System.out.println(sb);
    }

    static int find(int a){
        if(a == p[a]){ return a; }
        return p[a] = find(p[a]);
    }
}
