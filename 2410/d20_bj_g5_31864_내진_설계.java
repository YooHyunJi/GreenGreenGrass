package a2410;

import java.io.*;
import java.util.*;

public class d20_bj_g5_31864_내진_설계 {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1}, start = new int[2];
        int[][] hits = new int[N][M];
        char[][] map = new char[N][M];

        int whole = 0;
        for (int n = 0; n < N; n++) {
            map[n] = br.readLine().toCharArray();
            for (int m = 0; m < M; m++) {
                if (map[n][m] == '*' || map[n][m] == '#') {
                    whole++;
                }
                else if (map[n][m] == '@') {
                    start = new int[]{n, m};
                }
            }
        }

        ArrayDeque<int[]> pops = new ArrayDeque<>();
        for (int l = 1; l <= 2; l++) {
            for (int d = 0; d < 4; d++) {
                int nr = start[0] + dr[d] * l;
                int nc = start[1] + dc[d] * l;

                if (isOut(nr, nc) || map[nr][nc] == '|') {
                    continue;
                }

                int pr = nr + dr[(2 + d) % 4];
                int pc = nc + dc[(2 + d) % 4];
                if (map[nr][nc] == '*') {
                    if (map[pr][pc] == '|') {
                        continue;
                    }
                    map[nr][nc] = '.';
                    pops.offerLast(new int[]{nr, nc});
                    continue;
                }
                if (map[nr][nc] == '#') {
                    if (map[pr][pc] == '|') {
                        continue;
                    }
                    if (++hits[nr][nc] == 2) {
                        map[nr][nc] = '.';
                        pops.offerLast(new int[]{nr, nc});
                    }
                }
            }
        }

        int broken = 0;
        while (!pops.isEmpty()) {
            int[] now = pops.pollFirst();
            broken++;
            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];
                if (isOut(nr, nc) || map[nr][nc] == '|') {
                    continue;
                }
                if (map[nr][nc] == '*') {
                    map[nr][nc] = '.';
                    pops.offerLast(new int[]{nr, nc});
                    continue;
                }
                if (map[nr][nc] == '#') {
                    if (++hits[nr][nc] == 2) {
                        map[nr][nc] = '.';
                        pops.offerLast(new int[]{nr, nc});
                    }
                }
            }
        }

        System.out.println(broken + " " + (whole - broken));
    }

    static boolean isOut(int r, int c) {
        return r < 0 || N <= r || c < 0 || M <= c;
    }
}