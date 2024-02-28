package a2402;

import java.io.*;
import java.util.*;

public class d28_bj_s1_2502_떡먹는호랑이 {
    static int fib(int now){
        if(now==0 || now==1){ return 1; }
        return fib(now-2) + fib(now-1);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int a = fib(D-3);
        int b = fib(D-2);
        for(int cnt=1; ; cnt++){
            if((K-a*cnt)%b == 0){
                System.out.println(cnt);
                System.out.println((K-a*cnt)/b);
                return;
            }
        }
    }
}
