package a2408;

import java.io.*;
import java.util.*;

public class d05_bj_s1_11660_구간_합_구하기_5 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        for(int r=1; r<=N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=1; c<=N; c++){
                int num = Integer.parseInt(st.nextToken());
                arr[r][c] = arr[r-1][c] + arr[r][c-1] - arr[r-1][c-1] + num;
            }
        }
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = arr[x2][y2] - arr[x1][y2] - arr[x2][y1] + arr[x1][y1];
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}