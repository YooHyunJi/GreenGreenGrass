package a2407;

import java.io.*;
import java.util.*;

public class d17_bj_s1_9465_스티커 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][N+1];
            int[][] dp = new int[2][N+1];
            for(int r=0; r<2; r++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int c=1; c<=N; c++){ stickers[r][c] = Integer.parseInt(st.nextToken()); }
            }
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];
            for(int n=2; n<=N; n++){
                for(int r=0; r<2; r++){
                    int row = (r+1)%2;
                    dp[r][n] = Math.max(dp[row][n-1], Math.max(dp[row][n-2], dp[r][n-2])) + stickers[r][n];
                }
            }
            sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");
        }
        System.out.println(sb);
    }
}
