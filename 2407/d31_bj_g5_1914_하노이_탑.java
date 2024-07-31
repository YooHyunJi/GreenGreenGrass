package a2407;

import java.io.*;
import java.math.BigInteger;

public class d31_bj_g5_1914_하노이_탑 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(new BigInteger("2").pow(N).subtract(BigInteger.ONE));
        if(N <= 20){
            hanoi(N, 1, 2, 3);
            System.out.println(sb);
        }
    }

    static void hanoi(int n, int from, int mid, int to){
        if(n == 1){
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(n-1, from, to, mid);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n-1, mid, from, to);
    }
}
