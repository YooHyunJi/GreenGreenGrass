package a2409;

import java.io.*;

public class d19_bj_b3_2442_별_찍기_5 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int B = N - 1;
        for (int r = 0; r < N; r++) {
            for (int b = 0; b < B; b++) {
                sb.append(" ");
            }
            for (int s = 0; s < 2 * r + 1; s++) {
                sb.append("*");
            }
            B--;
            sb.append("\n");
        }
        System.out.println(sb);
    }
}