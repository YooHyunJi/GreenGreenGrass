package a2405;

import java.io.*;
import java.util.*;

public class d22_bj_g4_14722_우유_도시 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] city = new int[N+1][N+1];
        int[][][] dp = new int[N+1][N+1][2];
        for(int r=1; r<=N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=1; c<=N; c++){
                city[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for(int r=1; r<=N; r++){
            for(int c=1; c<=N; c++){
                int R, C;
                if(dp[r-1][c][1] < dp[r][c-1][1]){
                    R = r;
                    C = c-1;
                }
                else{
                    R = r-1;
                    C = c;
                }
                int nextMilk = dp[R][C][0];
                int nextResult = dp[R][C][1];
                if(city[r][c] == nextMilk){
                    nextResult++;
                    nextMilk = (nextMilk+1)%3;
                }
                dp[r][c] = new int[]{nextMilk, nextResult};
            }
        }
        System.out.println(dp[N][N][1]);
    }
}