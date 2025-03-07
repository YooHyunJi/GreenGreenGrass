package a2503;

import java.io.*;
import java.util.*;

public class d07_bj_s4_1487_물건_팔기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] price = new int[N];
        int[] fee = new int[N];
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            price[n] = p;
            fee[n] = f;
            min = Math.min(min, p);
            max = Math.max(max, p);
        }
        int answer = 0;
        int max_profit = 0;
        for(int suggest=min; suggest<=max; suggest++){
            int profit = 0;
            for(int n=0; n<N; n++){
                if(price[n] < suggest || suggest <= fee[n]){
                    continue;
                }
                profit += suggest - fee[n];
            }
            if(max_profit <= profit){
                if(max_profit < profit){
                    max_profit = profit;
                    answer = suggest;
                }
                else{
                    answer = Math.min(answer, suggest);
                }
            }
        }
        System.out.println(answer);
    }
}
