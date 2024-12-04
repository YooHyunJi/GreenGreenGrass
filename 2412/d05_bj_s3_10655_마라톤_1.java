package a2412;

import java.io.*;
import java.util.*;

public class d05_bj_s3_10655_마라톤_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] checkPoints = new int[N][2];
        int[] sumArr = new int[N];
        int sumTotal = 0;
        int min = Integer.MAX_VALUE;
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            checkPoints[n][0] = x;
            checkPoints[n][1] = y;
        }
        for(int n=1; n<N; n++){
            sumArr[n] = Math.abs(checkPoints[n][0] - checkPoints[n-1][0]) +Math.abs(checkPoints[n][1] - checkPoints[n-1][1]);
            sumTotal += sumArr[n];
        }

        for(int n=1; n<N-1; n++){
            int sum = sumTotal - sumArr[n]- sumArr[n+1];
            sum += Math.abs(checkPoints[n+1][0] - checkPoints[n-1][0]) +Math.abs(checkPoints[n+1][1] - checkPoints[n-1][1]);
            if(sum < min){ min = sum; }
        }
        System.out.println(min);
    }
}
