package a2312;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d19_bj_b3_23971_ZOAC4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()),
                W = Integer.parseInt(st.nextToken()),
                N = Integer.parseInt(st.nextToken()),
                M = Integer.parseInt(st.nextToken());
        System.out.println((int) (Math.ceil((double) H / (N + 1)) * Math.ceil((double) W / (M + 1))));
    }
}