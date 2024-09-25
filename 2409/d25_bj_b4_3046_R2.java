package a2409;

import java.io.*;
import java.util.*;

public class d25_bj_b4_3046_R2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R1 = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        System.out.println(2 * S - R1);
    }
}
