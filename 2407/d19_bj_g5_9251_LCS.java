package a2407;

import java.io.*;

public class d19_bj_g5_9251_LCS {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        int lenA = A.length;
        int lenB = B.length;
        int[][] dp = new int[lenA+1][lenB+1];
        for(int i=1; i<=lenA; i++){
            for(int j=1; j<=lenB; j++){
                if(A[i-1] == B[j-1]){ dp[i][j] = dp[i-1][j-1] + 1; }
                else{ dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); }
            }
        }
        System.out.println(dp[lenA][lenB]);
    }
}
