package a2410;

import java.io.*;
import java.util.*;

public class d27_bj_s5_2303_숫자_게임 {
    static int MAX;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arrMax = new int[N];
        for(int n=0; n<N; n++){
            MAX = -1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[5];
            for(int i=0; i<5; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            makeSet(0, 0, arr, new int[3], new boolean[5]);
            arrMax[n] = MAX;
        }
        int maxResult = 0, maxIdx = 0;
        for(int n=0; n<N; n++){
            if(maxResult <= arrMax[n]){
                maxResult = arrMax[n];
                maxIdx = n+1;
            }
        }
        System.out.println(maxIdx);
    }
    private static void makeSet(int start, int cnt, int[] source, int[] result, boolean[] visit){
        if(cnt == 3){
            int sum = (result[0] + result[1] + result[2]) % 10;
            MAX = Math.max(MAX, sum);
            return;
        }
        for(int i=start; i<5; i++){
            if(visit[i]){ continue; }
            result[cnt] = source[i];
            visit[i] = true;
            makeSet(start+1, cnt+1, source, result, visit);
            visit[i] = false;
        }
    }
}
