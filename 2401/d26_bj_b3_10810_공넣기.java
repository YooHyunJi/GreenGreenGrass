package a2401;

import java.io.*;
import java.util.*;

public class d26_bj_b3_10810_공넣기 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int M = Integer.parseInt(st.nextToken());
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int toto = Integer.parseInt(st.nextToken())-1;
            int numb = Integer.parseInt(st.nextToken());
            for(int d=from; d<=toto; d++) { arr[d] = numb; }
        }
        for(int n=0; n<N; n++) { sb.append(arr[n]+" "); }
        System.out.println(sb);
    }
}