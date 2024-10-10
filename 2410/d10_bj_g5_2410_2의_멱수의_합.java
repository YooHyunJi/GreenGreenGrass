package a2410;

import java.io.*;

public class d10_bj_g5_2410_2의_멱수의_합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println(1);
            return;
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            if (i % 2 == 1) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = (dp[i - 1] + dp[i / 2]) % 1000000000;
        }
        System.out.println(dp[N]);
    }
}