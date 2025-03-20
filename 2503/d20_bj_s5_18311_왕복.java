package a2503;

import java.io.*;
import java.util.*;

public class d20_bj_s5_18311_왕복 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] token = new int[N];
        long[] course = new long[2 * N - 1];
        token[0] = Integer.parseInt(st.nextToken());
        course[0] = token[0];
        int n=1;
        for(int t=1; t<N; t++, n++){
            token[t] = Integer.parseInt(st.nextToken());
            course[n] = course[n-1] + token[t];
        }
        for(int t=N-1; t>0; t--, n++){
            course[n] = course[n-1] + token[t];
        }
        for(int t=0; t<2*N-1; t++){
            if(K < course[t]){
                System.out.println(t<N? t+1: t-2*(t-N));
                return;
            }
        }
        System.out.println(1);
    }
}
