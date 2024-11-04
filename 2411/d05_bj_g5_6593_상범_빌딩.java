package a2411;

import java.io.*;
import java.util.*;

public class d05_bj_g5_6593_상범_빌딩 {

    static int L, R, C;
    static int[] dl = {0, 0, 0, 0, 1, -1},
            dr = {-1, 0, 1, 0, 0, 0},
            dc = {0, 1, 0, -1, 0, 0};
    static char[][][] map;
    static int[] START, END;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            map = new char[L][R][C];
            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    map[l][r] = br.readLine().toCharArray();
                    for (int c = 0; c < C; c++) {
                        if (map[l][r][c] == 'S') {
                            START = new int[]{l, r, c};
                        } else if (map[l][r][c] == 'E') {
                            END = new int[]{l, r, c};
                        }
                    }
                }
                br.readLine();
            }
            int result = escape();
            if (result == -1) {
                sb.append("Trapped!\n");
            } else {
                sb.append("Escaped in ").append(result).append(" minute(s).\n");
            }
        }
        System.out.println(sb);
    }

    static int escape() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][][] visit = new boolean[L][R][C];
        int l = START[0];
        int r = START[1];
        int c = START[2];
        queue.offerLast(new int[]{l, r, c, 0});
        visit[l][r][c] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.pollFirst();
            l = now[0];
            r = now[1];
            c = now[2];
            int s = now[3];
            for (int d = 0; d < 6; d++) {
                int nl = l + dl[d];
                int nr = r + dr[d];
                int nc = c + dc[d];
                int ns = s + 1;
                if (isOut(nl, nr, nc) || visit[nl][nr][nc] || map[nl][nr][nc] == '#') {
                    continue;
                }
                if (map[nl][nr][nc] == 'E') {
                    return ns;
                }
                queue.offerLast(new int[]{nl, nr, nc, ns});
                visit[nl][nr][nc] = true;
            }
        }
        return -1;
    }

    static boolean isOut(int l, int r, int c) {
        return l < 0 || L <= l || r < 0 || R <= r || c < 0 || C <= c;
    }
}