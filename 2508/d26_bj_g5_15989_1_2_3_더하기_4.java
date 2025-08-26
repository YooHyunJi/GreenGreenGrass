package a2508;

import java.io.*;
import java.util.*;

public class d26_bj_g5_15989_1_2_3_더하기_4 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[10_001];
        Arrays.fill(dp, 1);
        for(int i=2; i<=10_000; i++){
            dp[i] += dp[i-2];
        }
        for(int i=3; i<=10_000; i++){
            dp[i] += dp[i-3];
        }
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}
