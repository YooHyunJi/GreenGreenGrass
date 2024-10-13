package a2410;

import java.io.*;
import java.util.*;

public class d13_bj_s3_1735_분수_합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int a3 = a1 * b2 + a2 * b1;
        int b3 = b1 * b2;

        int num = gcd(a3, b3);
        a3 /= num;
        b3 /= num;
        System.out.println(a3 + " " + b3);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}