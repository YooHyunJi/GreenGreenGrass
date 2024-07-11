package a2407;

import java.io.*;
import java.util.*;

public class d12_bj_s3_15652_N과_M_4 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int n=0; n<N; n++){ arr[n] = n+1; };
        makePerm(0, 0, "");
        System.out.println(sb);
    }

    static void makePerm(int from, int cnt, String result){
        if(cnt == M){
            sb.append(result).append("\n");
            return;
        }
        for(int i=from; i<N; i++){
            makePerm(i, cnt+1, cnt==0? arr[i]+"": result+" "+arr[i]);
        }
    }
}
