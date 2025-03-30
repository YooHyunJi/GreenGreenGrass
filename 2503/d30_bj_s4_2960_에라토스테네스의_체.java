package a2503;

import java.io.*;
import java.util.*;

public class d30_bj_s4_2960_에라토스테네스의_체 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] num = new boolean[N+1];
        int cnt = 0;
        int min = 2;
        while(true){
            for(int i=2; i<=N; i++){
                if(num[i]){
                    continue;
                }
                min = i;
                break;
            }
            for(int i=min; i<=N; i+=min){
                if(num[i]){
                    continue;
                }
                num[i] = true;
                if(++cnt == K){
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
