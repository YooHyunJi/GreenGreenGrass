package a2406;

import java.io.*;

public class d24_bj_s3_2579_계단_오르기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N+3];
        int[] dp = new int[N+3];
        for(int n=3; n<N+3; n++){
            stairs[n] = Integer.parseInt(br.readLine());
            dp[n] = Math.max(
                    stairs[n] + dp[n-2],
                    stairs[n] + stairs[n-1] + dp[n-3]);
        }
        System.out.println(dp[N+2]);
    }
}
