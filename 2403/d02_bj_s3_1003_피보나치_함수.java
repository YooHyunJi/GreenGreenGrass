package a2403;

import java.io.*;

public class d02_bj_s3_1003_피보나치_함수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[41][2];
        int T = Integer.parseInt(br.readLine());
        dp[0][0] = 1; dp[0][1] = 0;
        dp[1][0] = 0; dp[1][1] = 1;
        for(int n=2; n<=40; n++){
            dp[n][0] = dp[n-2][0] + dp[n-1][0];
            dp[n][1] = dp[n-2][1] + dp[n-1][1];
        }
        for(int t=0; t<T; t++){
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num][0]).append(" ").append(dp[num][1]).append("\n");
        }
        System.out.println(sb);
    }
}
