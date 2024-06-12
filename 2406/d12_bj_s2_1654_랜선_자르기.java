package a2406;

import java.io.*;
import java.util.*;

public class d12_bj_s2_1654_랜선_자르기 {
    static int K, N;
    static long answer;
    static long[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[K];
        for(int k=0; k<K; k++){
            arr[k] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        findLength(1, arr[K-1]);
        System.out.println(answer);
    }
    static void findLength(long min, long max){
        long mid = (min + max) / 2;
        if(mid <= answer || max < min){ return; }

        long cnt = 0;
        for(int k=0; k<K; k++){ cnt += arr[k] / mid; }

        if(cnt < N){
            findLength(min, mid-1);
            return;
        }
        answer = mid;
        findLength(mid+1, max);
    }
}
