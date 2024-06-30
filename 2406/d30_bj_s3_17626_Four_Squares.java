package a2406;

import java.io.*;
import java.util.*;

public class d30_bj_s3_17626_Four_Squares {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N < 4){
            System.out.println(N);
            return;
        }
        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4; i<=N; i++){
            int M = (int)Math.sqrt(i);
            for(int j=M; 1<=j; j--){
                int left = i - (int)Math.pow(j, 2);
                dp[i] = Math.min(dp[i], dp[left] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}
