package a2402;

import java.io.*;
import java.util.*;

public class d09_bj_b2_10813_공바꾸기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] basket = new int[N+1];
        for(int n=1; n<=N; n++) { basket[n] = n; }
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int tmp = basket[a];
            basket[a] = basket[b];
            basket[b] = tmp;
        }
        for(int n=1; n<=N; n++) { System.out.print(basket[n]+" "); }
    }
}
