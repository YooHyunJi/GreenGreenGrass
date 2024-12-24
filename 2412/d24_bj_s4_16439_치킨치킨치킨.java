package a2412;

import java.io.*;
import java.util.*;

public class d24_bj_s4_16439_치킨치킨치킨 {
    static int N, M, MAX = 0;
    static int[] result = new int[3];
    static int[][] happy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        happy = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                int num = Integer.parseInt(st.nextToken());
                happy[n][m] = num;
            }
        }
        makeComb(0, 0);
        System.out.println(MAX);
    }

    static void makeComb(int cnt, int start) {
        if (cnt == 3) {
            int sum = 0;
            for (int n = 0; n < N; n++) {
                int max = 0;
                for (int r : result) {
                    max = Math.max(max, happy[n][r]);
                }
                sum += max;
            }
            MAX = Math.max(MAX, sum);
            return;
        }
        for (int m = start; m < M; m++) {
            result[cnt] = m;
            makeComb(cnt + 1, m + 1);
        }
    }
}