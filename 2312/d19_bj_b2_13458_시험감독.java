package a2312;

import java.io.*;
import java.util.*;

public class d19_bj_b2_13458_시험감독 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++) A[n] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken()),
            C = Integer.parseInt(st.nextToken());
        long answer = N;
        for(int n=0; n<N; n++){
            if(A[n]<=B) continue;
            answer += Math.ceil((double)(A[n]-B)/C);
        }
        System.out.println(answer);
    }
}