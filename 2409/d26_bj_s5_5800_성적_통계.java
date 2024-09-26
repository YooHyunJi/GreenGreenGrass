package a2409;

import java.io.*;
import java.util.*;

public class d26_bj_s5_5800_성적_통계 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for (int k = 1; k <= K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] score = new int[N];
            for (int n = 0; n < N; n++) {
                score[n] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(score);
            int gap = 0;
            for (int n = 1; n < N; n++) {
                gap = Math.max(gap, score[n] - score[n - 1]);
            }

            sb.append("Class ").append(k).append("\n")
                    .append("Max ").append(score[N - 1]).append(", ")
                    .append("Min ").append(score[0]).append(", ")
                    .append("Largest gap ").append(gap).append("\n");
        }
        System.out.println(sb);
    }
}
