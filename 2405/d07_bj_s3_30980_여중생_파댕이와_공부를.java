package a2405;

import java.io.*;
import java.util.*;

public class d07_bj_s3_30980_여중생_파댕이와_공부를 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;
        char[][] paper = new char[3 * N][8 * M];
        char[] ops = new char[8];
        int[] result = new int[N * M];
        for (int r = 0; r < 3 * N; r++) {
            paper[r] = br.readLine().toCharArray();
            if (r % 3 != 1) {
                continue;
            }
            for (int c = 0; c < 8 * M; c++) {
                ops[c % 8] = paper[r][c];
                if (c % 8 == 7) {
                    result[cnt++] = calculate(ops);
                }
            }
        }
        cnt = 0;
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                int nowResult = result[cnt++];
                if (0 < nowResult) {
                    int startR = 3 * n;
                    int startC = 8 * m + 1;
                    for (int d = 0; d <= 2; d += 2) {
                        for (int dd = 0; dd < 4 + nowResult; dd++) {
                            paper[startR + d][startC + dd] = '*';
                        }
                    }
                    paper[++startR][startC - 1] = '*';
                    paper[startR][startC + 4 + nowResult] = '*';
                } else {
                    int startR = 3 * n;
                    int startC = 8 * m + 3;
                    for (int d = 0; d < 3; d++) {
                        paper[startR++][startC--] = '/';
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < 3 * N; n++) {
            sb.append(paper[n]).append("\n");
        }
        System.out.println(sb);
    }

    private static int calculate(char[] ops) {
        int iX = ops[1] - '0';
        int iY = ops[3] - '0';
        int iResult = 0;
        if (ops[6] == '.') {
            iResult = ops[5] - '0';
            if (iX + iY == iResult) {
                return 1;
            }
        } else {
            iResult = 10 * (ops[5] - '0') + ops[6] - '0';
            if (iX + iY == iResult) {
                return 2;
            }
        }
        return 0;
    }
}