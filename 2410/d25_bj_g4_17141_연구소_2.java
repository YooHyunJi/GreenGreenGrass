package a2410;

import java.io.*;
import java.util.*;

public class d25_bj_g4_17141_연구소_2 {

    static int N, M, cntVirus = 0, MIN_STEP = Integer.MAX_VALUE;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1}, selectedVirus;
    static int[][] originalMap;
    static List<int[]> virus = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        originalMap = new int[N][N];
        selectedVirus = new int[M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                originalMap[r][c] = Integer.parseInt(st.nextToken());
                if (originalMap[r][c] == 2) {
                    cntVirus++;
                    virus.add(new int[]{r, c});
                }
            }
        }
        setVirus(0, 0);
        System.out.println(MIN_STEP == Integer.MAX_VALUE ? -1 : MIN_STEP);
    }

    static void setVirus(int cnt, int from) {
        if (cnt == M) {
            sprayVirus();
            return;
        }
        for (int i = from; i < cntVirus; i++) {
            selectedVirus[cnt] = i;
            setVirus(cnt + 1, i + 1);
        }
    }

    static void sprayVirus() {
        int[][] copiedMap = copyArray();
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];
        for (int idx : selectedVirus) {
            int[] v = virus.get(idx);
            int r = v[0];
            int c = v[1];
            visit[r][c] = true;
            queue.offerLast(new int[]{0, r, c});
            copiedMap[r][c] = 3;
        }
        int totalLevel = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.pollFirst();
            int l = now[0];
            int r = now[1];
            int c = now[2];
            totalLevel = Math.max(totalLevel, l);
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (isOut(nr, nc) || visit[nr][nc] || copiedMap[nr][nc] == 1) {
                    continue;
                }
                visit[nr][nc] = true;
                queue.offerLast(new int[]{l + 1, nr, nc});
                copiedMap[nr][nc] = 3;
            }
        }
        if (isAllFilled(copiedMap)) {
            MIN_STEP = Math.min(MIN_STEP, totalLevel);
        }
    }

    static boolean isAllFilled(int[][] map) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 0 || map[r][c] == 2) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isOut(int r, int c) {
        return r < 0 || N <= r || c < 0 || N <= c;
    }

    static int[][] copyArray() {
        int[][] map = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = originalMap[r][c];
            }
        }
        return map;
    }
}

/*
5 1
2 1 1 1 1
1 2 0 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
-1
*/