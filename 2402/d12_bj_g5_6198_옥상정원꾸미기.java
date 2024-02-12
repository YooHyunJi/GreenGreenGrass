package a2402;

import java.io.*;
import java.util.*;

public class d12_bj_g5_6198_옥상정원꾸미기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        int[] buildings = new int[N];
        int[] dp = new int[N];
        buildings[0] = Integer.parseInt(br.readLine());
        dp[0] = 0;
        for(int n=1; n<N; n++) {
            int m = n;
            buildings[n] = Integer.parseInt(br.readLine());
            while(--m>=0) {
                if(buildings[m] > buildings[n]) {
                    dp[n] += dp[m]+1;
                    answer += dp[n];
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
