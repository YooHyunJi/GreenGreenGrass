package a2410;

import java.io.*;

public class d17_bj_s5_5426_비밀_편지 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String line = br.readLine();
            int L = (int) Math.sqrt(line.length());
            for (int c = L - 1; 0 <= c; c--) {
                for (int r = 0; r < L; r++) {
                    int idx = L * r + c;
                    sb.append(line.charAt(idx));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
