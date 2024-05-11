package a2405;

import java.io.*;
import java.util.*;

public class d11_bj_s3_9095_123_더하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<=10; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}
