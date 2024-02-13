package a2402;

import java.io.*;

public class d14_bj_b1_24416_알고리즘수업_피보나치수1 {
    static int cnt1 = 1, cnt2 = 0;

    static int fib1(int n){
        if(n==1 || n==2){
            return 1;
        }
        cnt1++;
        return fib1(n-1) + fib1(n-2);
    }

    static int fib2(int N){
        int[] f = new int[N+1];
        f[1] = 1;
        f[2] = 1;
        for(int n=3; n<=N; n++){
            f[n] = f[n-1]+f[n-2];
            cnt2++;
        }
        return f[N];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fib1(N);
        fib2(N);
        System.out.println(cnt1+" "+cnt2);
    }
}
