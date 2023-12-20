package a2312;

import java.io.*;
import java.util.*;

public class d20_bj_g5_2294_동전2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),
            K = Integer.parseInt(st.nextToken());
        int[] price = new int[10_001];
        Arrays.fill(price, 10_001);
        for(int n=0; n<N; n++){
            int coin = Integer.parseInt(br.readLine());
            if(coin>10_000) continue;
            if(price[coin]!=0) price[coin] = 1;
        }
        for(int k=1; k<=K; k++) {
            if (price[k] != 10_001) continue;
            for (int one = 1; one <= k / 2; one++) {
                int two = k - one;
                price[k] = Math.min(price[k], price[one] + price[two]);
            }
        }
        if(price[K]==10_001) price[K] = -1;
        System.out.println(price[K]);
    }
}