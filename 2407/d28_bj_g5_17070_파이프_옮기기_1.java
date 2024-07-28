package a2407;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d28_bj_g5_17070_파이프_옮기기_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[N+1][N+1][4];
        for(int r=1; r<=N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=1; c<=N; c++){
                dp[r][c][0] = Integer.parseInt(st.nextToken());
            }
        }
        if(dp[1][2][0] == 0){ dp[1][2][1] = 1; }
        for(int r=1; r<=N; r++){
            for(int c=3; c<=N; c++){
                if(dp[r][c][0] == 0){
                    dp[r][c][1] = dp[r][c-1][1] + dp[r][c-1][2];
                    dp[r][c][3] = dp[r-1][c][2] + dp[r-1][c][3];
                    if(dp[r-1][c][0] == 0 && dp[r][c-1][0] == 0){
                        dp[r][c][2] = dp[r-1][c-1][1] + dp[r-1][c-1][2] + dp[r-1][c-1][3];
                    }
                }
            }
        }
        System.out.println(dp[N][N][1] + dp[N][N][2] + dp[N][N][3]);
    }
}
