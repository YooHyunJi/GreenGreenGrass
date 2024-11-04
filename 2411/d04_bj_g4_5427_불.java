package a2411;

import java.io.*;
import java.util.*;

public class d04_bj_g4_5427_불 {
    static int W, H;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static char[][] map;
    static ArrayList<int[]> fireList = new ArrayList<>();
    static boolean[][] fireVisit;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            fireVisit = new boolean[H][W];
            fireList.clear();
            int[] sangkeun = new int[2];
            for (int h = 0; h < H; h++) {
                map[h] = br.readLine().toCharArray();
                for (int w = 0; w < W; w++) {
                    if (map[h][w] == '@') {
                        sangkeun[0] = h;
                        sangkeun[1] = w;
                        map[h][w] = '.';
                    } else if (map[h][w] == '*') {
                        fireList.add(new int[]{h, w});
                    }
                }
            }
            int result = escape(sangkeun);
            sb.append(result == -1 ? "IMPOSSIBLE" : result).append("\n");
        }
        System.out.println(sb);
    }

    static int escape(int[] sangkeun) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[H][W];
        int r = sangkeun[0];
        int c = sangkeun[1];
        if (isEscape(r, c)) {
            return 1;
        }
        queue.offerLast(new int[]{r, c, 1});
        visit[r][c] = true;
        int prevStep = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.pollFirst();
            r = now[0];
            c = now[1];
            int step = now[2];
            if (prevStep != step) {
                prevStep = step;
                setFires();
            }
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                int ns = step + 1;
                if (isOut(nr, nc) || visit[nr][nc] || map[nr][nc] != '.') {
                    continue;
                } else if (isEscape(nr, nc)) {
                    return ns;
                }
                queue.offerLast(new int[]{nr, nc, ns});
                visit[nr][nc] = true;
            }
        }
        return -1;
    }

    static boolean isOut(int r, int c) {
        return r < 0 || H <= r || c < 0 || W <= c;
    }

    static boolean isEscape(int r, int c) {
        return (r == 0 || c == 0 || r == H - 1 || c == W - 1) && map[r][c] == '.';
    }

    static void setFires() {
        ArrayList<int[]> tmpList = new ArrayList<>();

        for (int[] fire : fireList) {
            int r = fire[0];
            int c = fire[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (isOut(nr, nc) || map[nr][nc] != '.' || fireVisit[nr][nc]) {
                    continue;
                }
                fireVisit[nr][nc] = true;
                map[nr][nc] = '*';
                tmpList.add(new int[]{nr, nc});
            }
        }
        fireList = new ArrayList<>(tmpList);
    }
}