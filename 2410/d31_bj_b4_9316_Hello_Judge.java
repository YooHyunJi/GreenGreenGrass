package a2410;

import java.io.*;

public class d31_bj_b4_9316_Hello_Judge {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int n = 1; n <= N; n++) {
            sb.append("Hello World, Judge ").append(n).append("!\n");
        }
        System.out.println(sb);
    }
}
