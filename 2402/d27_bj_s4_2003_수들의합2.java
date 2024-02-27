package a2402;

import java.io.*;
import java.util.*;

public class d27_bj_s4_2003_수들의합2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        arr[0] = 0;
        for(int n=1; n<=N; n++){ arr[n] = arr[n-1] + Integer.parseInt(st.nextToken()); }
        for(int n=1; n<=N; n++){
            for(int m=0; m<=n; m++){
                if(arr[n] - arr[m] == M){ answer++; }
            }
        }
        System.out.println(answer);
    }
}