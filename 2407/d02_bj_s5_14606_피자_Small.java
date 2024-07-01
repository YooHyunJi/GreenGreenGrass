package a2407;

import java.io.*;

public class d02_bj_s5_14606_피자_Small {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[11];
        dp[2] = 1;
        dp[3] = 3;
        for(int i=2; i<=10; i++){
            int half = i/2;
            if(i%2 == 0){ dp[i] = half * half + 2 * dp[half]; }
            else{ dp[i] = half * (half + 1) + dp[half] + dp[half + 1]; }
        }
        System.out.println(dp[Integer.parseInt(br.readLine())]);
    }
}
