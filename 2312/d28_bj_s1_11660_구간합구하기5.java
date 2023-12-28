package a2312;

import java.io.*;
import java.util.*;

public class d28_bj_s1_11660_구간합구하기5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] chart = new int[N+1][N+1];
        for(int n=1; n<=N; n++){
            st = new StringTokenizer(br.readLine());
            for(int nn=1; nn<=N; nn++){ chart[n][nn] = chart[n][nn-1]+Integer.parseInt(st.nextToken()); }
        }
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int[] from = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] toto = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int answer = 0;
            for(int r=from[0]; r<=toto[0]; r++){ answer += chart[r][toto[1]]-chart[r][from[1]-1]; }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}