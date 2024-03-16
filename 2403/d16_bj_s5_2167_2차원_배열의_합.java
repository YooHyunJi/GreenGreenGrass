package a2403;

import java.io.*;
import java.util.*;

public class d16_bj_s5_2167_2차원_배열의_합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][M+1];
        for(int n=1; n<=N; n++){
            st = new StringTokenizer(br.readLine());
            arr[n][1] = Integer.parseInt(st.nextToken());
            for(int m=2; m<=M; m++){ arr[n][m] = arr[n][m-1] + Integer.parseInt(st.nextToken()); }
        }
        int K = Integer.parseInt(br.readLine());
        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int sum = 0;
            for(int r=i; r<=x; r++){
                sum += arr[r][y] - arr[r][j-1];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
