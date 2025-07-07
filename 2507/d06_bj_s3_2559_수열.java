package a2507;

import java.io.*;
import java.util.*;

public class d06_bj_s3_2559_수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for(int k=0; k<K; k++){
            sum += arr[k];
        }
        int max = sum;
        for(int n=K; n<N; n++){
            sum -= arr[n-K];
            sum += arr[n];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
