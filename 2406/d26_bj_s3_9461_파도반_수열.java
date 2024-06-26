package a2406;

import java.io.*;

public class d26_bj_s3_9461_파도반_수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[1] = dp[2] = 1;
        for(int i=3; i<=100; i++){ dp[i] = dp[i-3] + dp[i-2]; }
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}
