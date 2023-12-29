package a2312;

import java.io.*;
import java.util.*;

public class d29_bj_s5_16435_스네이크버드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] fruits = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){ fruits[n] = Integer.parseInt(st.nextToken()); }
        Arrays.sort(fruits);
        for(int n=0; n<N; n++){
            if(fruits[n]>L) break;
            L++;
        }
        System.out.println(L);
    }
}
