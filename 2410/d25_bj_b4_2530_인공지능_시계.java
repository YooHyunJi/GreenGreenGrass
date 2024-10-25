package a2410;

import java.io.*;
import java.util.*;

public class d25_bj_b4_2530_인공지능_시계 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(br.readLine());
        C += D;

        B += C/60;
        C %= 60;

        A += B/60;
        B %= 60;

        A %= 24;
        System.out.println(A+" "+B+" "+C);
    }
}
