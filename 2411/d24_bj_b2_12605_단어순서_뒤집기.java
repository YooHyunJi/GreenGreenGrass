package a2411;

import java.io.*;
import java.util.*;

public class d24_bj_b2_12605_단어순서_뒤집기 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int n = 1; n <= N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append("Case #").append(n).append(": ");
            int S = st.countTokens();
            String[] original = new String[S];
            for (int s = 0; s < S; s++) {
                original[s] = st.nextToken();
            }
            for (int s = S - 1; s >= 0; s--) {
                sb.append(original[s]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}