package a2407;

import java.io.*;
import java.util.*;

public class d18_bj_s1_1629_곱셈 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        System.out.println(multi(A, B, C));
    }

    static long multi(long a, long b, long c){
        if(b==0){ return 1; }
        if(b==1){ return a%c; }
        long result = multi(a, b/2, c);
        result = result * result % c;
        if(b%2==0){ return result; }
        else{ return result * a % c; }
    }
}
