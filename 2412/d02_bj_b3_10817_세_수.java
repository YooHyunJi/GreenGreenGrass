package a2412;

import java.io.*;
import java.util.*;

public class d02_bj_b3_10817_세_수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int sum = A + B + C;
        System.out.println(sum - Math.min(A, Math.min(B, C)) - Math.max(A, Math.max(B, C)));
    }
}
