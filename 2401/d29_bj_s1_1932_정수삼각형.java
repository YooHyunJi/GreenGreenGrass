package a2401;

import java.io.*;
import java.util.*;

public class d29_bj_s1_1932_정수삼각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[2][N];
        dp[0][0] = Integer.parseInt(br.readLine());
        for(int n=1; n<N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int m=0; m<=n; m++) {
                int num = Integer.parseInt(st.nextToken());
                int left = m==0? 0: dp[(n-1)%2][m-1];
                int right = m==n? 0: dp[(n-1)%2][m];
                dp[n%2][m] = Math.max(num+left, num+right);
            }
        }
        Arrays.sort(dp[(N-1)%2]);
        System.out.println(dp[(N-1)%2][N-1]);
    }
}
