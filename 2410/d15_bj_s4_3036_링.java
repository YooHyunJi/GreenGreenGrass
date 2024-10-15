package a2410;

import java.io.*;
import java.util.*;

public class d15_bj_s4_3036_링 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int base = Integer.parseInt(st.nextToken());
        for(int n=0; n<N-1; n++){
            int ring = Integer.parseInt(st.nextToken());
            int max = gcd(base, ring);
            sb.append(base/max).append("/").append(ring/max).append("\n");
        }
        System.out.println(sb);
    }

    private static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}
