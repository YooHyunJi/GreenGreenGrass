package a2408;

import java.io.*;
import java.util.*;

public class d06_bj_s3_17484_진우의_달_여행_Small {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int MAX = 99999;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[][][] dp = new int[N][M][3];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        for(int m=0; m<M; m++){
            for(int k=0; k<3; k++){
                dp[0][m][k] = arr[0][m];
            }
        }
        dp[0][0][0] = MAX;
        dp[0][M-1][2] = MAX;
        for(int n=1; n<N; n++){
            for(int m=0; m<M; m++){
                dp[n][m][0] = m==0? dp[n-1][m][0]: Math.min(dp[n-1][m-1][1], dp[n-1][m-1][2]) + arr[n][m];
                dp[n][m][1] = Math.min(dp[n-1][m][0], dp[n-1][m][2]) + arr[n][m];
                dp[n][m][2] = m==M-1? dp[n-1][m][2]: Math.min(dp[n-1][m+1][0], dp[n-1][m+1][1]) + arr[n][m];
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int m=0; m<M; m++){
            for(int k=0; k<3; k++){
                answer = Math.min(answer, dp[N-1][m][k]);
            }
        }
        System.out.println(answer);
    }
}