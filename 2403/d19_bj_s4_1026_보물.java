package a2403;

import java.io.*;
import java.util.*;

public class d19_bj_s4_1026_보물 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){ A[n] = Integer.parseInt(st.nextToken()); }
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){ B[n] = Integer.parseInt(st.nextToken()); }
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        for(int n=0; n<N; n++){ answer += A[n] * B[N-1-n]; }
        System.out.println(answer);
    }
}
