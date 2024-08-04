package a2408;

import java.io.*;
import java.util.*;

public class d05_bj_s3_13305_주유소 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine())-1;
        int[] dist = new int[N];
        int[] price = new int[N];
        StringTokenizer stDist = new StringTokenizer(br.readLine());
        StringTokenizer stPrice = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            dist[n] = Integer.parseInt(stDist.nextToken());
            price[n] = Integer.parseInt(stPrice.nextToken());
        }
        int priceNow = Integer.MAX_VALUE;
        long answer = 0;
        for(int n=0; n<N; n++){
            if(price[n] < priceNow){
                priceNow = price[n];
            }
            answer += (long) priceNow * dist[n];
        }
        System.out.println(answer);
    }
}