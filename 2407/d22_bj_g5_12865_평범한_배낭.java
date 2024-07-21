package a2407;

import java.io.*;
import java.util.*;

public class d22_bj_g5_12865_평범한_배낭 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][2];
        int[][] dp = new int[N+1][K+1];
        for(int n=1; n<=N; n++){
            st = new StringTokenizer(br.readLine());
            arr[n] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        for(int n=1; n<=N; n++) {
            int w = arr[n][0];
            int v = arr[n][1];
            if (K < w) {
                for (int c = 1; c <= K; c++) {
                    dp[n][c] = dp[n - 1][c];
                }
                continue;
            }
            for (int c = 1; c < w; c++) {
                dp[n][c] = dp[n - 1][c];
            }
            for (int c = w; c <= K; c++) {
                dp[n][c] = Math.max(Math.max(dp[n - 1][c], dp[n][c - 1]), dp[n - 1][c - w] + v);
            }
        }
        System.out.println(dp[N][K]);
    }
}
