package a2403;

import java.io.*;
import java.util.*;

public class d24_bj_s4_11047_동전_0 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        for(int n=0; n<N; n++){ coins[n] = Integer.parseInt(br.readLine());}
        int cnt = 0;
        for(int n=N-1; n>=0 && K>0; n--){
            if(coins[n] > K){ continue; }
            cnt += K/coins[n];
            K -= coins[n] * (K/coins[n]);
        }
        System.out.println(cnt);
    }
}
