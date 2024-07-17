package a2407;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class d17_bj_s1_2591_숫자카드 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int L = line.length();
        int[] arr = new int[L];
        int[] dp = new int[L+1];
        for(int i=0; i<L; i++){ arr[i] = line.charAt(i) - '0'; }
        dp[0] = 1;
        for(int i=0; i<L; i++){
            if(arr[i] != 0){
                dp[i+1] += dp[i];
                if(i+1 != L && 10*arr[i] + arr[i+1] <= 34){
                    dp[i+2] += dp[i];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[L]);
    }
}
