package a2412;

import java.io.*;
import java.util.*;

public class d01_bj_s1_2156_포도주_시식 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] wine = new int[N];
        int[] dp = new int[N];
        for(int n=0; n<N; n++){
            wine[n] = Integer.parseInt(br.readLine());
        }
        if(N < 3){
            int answer = 0;
            for(int n=0; n<N; n++){
                answer += wine[n];
            }
            System.out.println(answer);
            return;
        }
        dp[0] = wine[0];
        dp[1] = wine[0] + wine[1];
        dp[2] = Math.max(wine[0] + wine[2], Math.max(wine[1] + wine[2], dp[1]));
        for(int n=3; n<N; n++){
            dp[n] = Math.max(dp[n-2] + wine[n], Math.max(dp[n-3] + wine[n-1] + wine[n], dp[n-1]));
        }
        System.out.println(dp[N-1]);
    }
}
