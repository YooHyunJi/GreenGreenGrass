package a2406;

import java.io.*;

public class d29_bj_s3_11727_2xn_타일링_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = 1;
        if(1 < N){ dp[2] = 3; }
        for(int i=3; i<=N; i++){ dp[i] = (2*dp[i-2] + dp[i-1]) % 10_007; }
        System.out.println(dp[N]);
    }
}
