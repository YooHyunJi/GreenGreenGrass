package a2410;

import java.io.*;
import java.util.*;

public class d18_bj_s5_12760_최후의_승자는_누구 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max_score = 0;
        int[] score = new int[N];
        int[][] cards = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                cards[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        for (int n = 0; n < N; n++) {
            Arrays.sort(cards[n]);
        }
        for (int m = 0; m < M; m++) {
            int max = 0;
            for (int n = 0; n < N; n++) {
                if (max < cards[n][m]) {
                    max = cards[n][m];
                }
            }
            for (int n = 0; n < N; n++) {
                if (max == cards[n][m]) {
                    score[n]++;
                }
                max_score = Math.max(max_score, score[n]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            if (score[n] == max_score) {
                sb.append(n + 1).append(" ");
            }
        }
        System.out.println(sb);
    }
}