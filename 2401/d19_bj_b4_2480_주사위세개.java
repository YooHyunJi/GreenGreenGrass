package a2401;

import java.io.*;
import java.util.*;

public class d19_bj_b4_2480_주사위세개 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        if(A==B && B==C) {
            System.out.println(10000+A*1000);
        } else if (A==B) {
            System.out.println(1000+A*100);
        } else if (A==C) {
            System.out.println(1000+A*100);
        } else if (B==C) {
            System.out.println(1000+B*100);
        } else {
            System.out.println(Math.max(A, Math.max(B, C))*100);
        }
    }
}