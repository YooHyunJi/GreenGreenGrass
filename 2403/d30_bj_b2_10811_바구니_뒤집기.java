package a2403;

import java.io.*;
import java.util.*;

public class d30_bj_b2_10811_바구니_뒤집기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        for(int n=1; n<=N; n++){ arr[n] = n; }
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            while (from < to){
                int tmp = arr[from];
                arr[from] = arr[to];
                arr[to] = tmp;
                from++;
                to--;
            }
        }
        for(int n=1; n<=N; n++){ sb.append(arr[n]).append(" "); }
        System.out.println(sb);
    }
}
