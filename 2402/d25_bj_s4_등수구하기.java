package a2402;

import java.io.*;
import java.util.*;

public class d25_bj_s4_등수구하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        if(N==0){
            System.out.println(1);
            return;
        }
        Integer[] ranks = new Integer[P+1];
        Arrays.fill(ranks, -1);
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){ ranks[n] = Integer.parseInt(st.nextToken()); }
        ranks[P] = T;
        Arrays.sort(ranks, Collections.reverseOrder());
        if(ranks[P]==T){
            System.out.println(-1);
            return;
        }
        for(int i=0; i<P; i++){
            if(ranks[i]==T){
                System.out.println(i+1);
                return;
            }
        }
    }
}
