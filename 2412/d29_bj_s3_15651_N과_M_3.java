package a2412;

import java.io.*;
import java.util.*;

public class d29_bj_s3_15651_N과_M_3 {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr, result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        for(int n=0; n<N; n++){
            arr[n] = n+1;
        }
        makePerm(0);
        System.out.println(sb);
    }

    static void makePerm(int cnt){
        if(cnt == M){
            for(int m=0; m<M; m++){
                sb.append(result[m]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<N; i++){
            result[cnt] = arr[i];
            makePerm(cnt+1);
        }
    }
}
