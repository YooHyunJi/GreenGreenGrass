package a2407;

import java.io.*;
import java.util.*;

public class d23_bj_s3_23351_물_주기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] pots = new int[N];
        Arrays.fill(pots, K);
        int idx = -1;
        for(int d=1; ; d++){
            for(int i=0; i<A; i++){
                idx = (idx+1) % N;
                pots[idx] += B;
            }
            for(int i=0; i<N; i++){
                if(--pots[i] == 0){
                    System.out.println(d);
                    return;
                }
            }
        }
    }
}
