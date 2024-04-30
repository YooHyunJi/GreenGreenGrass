package a2404;

import java.io.*;
import java.util.*;

public class d30_bj_s3_19941_햄버거_분배 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        boolean[] v = new boolean[N];
        char[] arr = br.readLine().toCharArray();
        for(int n=N-1; n>=0; n--){
            int start = N <= n + K? N-1: n + K;
            for(int m=start; m>=n; m--) {
                if (!v[m] && arr[n] != arr[m]) {
                    v[n] = true;
                    v[m] = true;
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
