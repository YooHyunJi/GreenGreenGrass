package a2409;

import java.io.*;
import java.util.*;

public class d04_bj_g3_20058_마법사_상어와_파이어스톰 {

    static int N, M, L;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static int[][] board;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = power2(N);
        int Q = Integer.parseInt(st.nextToken());
        board = new int[M][M];
        for (int r = 0; r < M; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int q = 0; q < Q; q++) {
            L = Integer.parseInt(st.nextToken());
            play();
        }
        visit = new boolean[M][M];
        int answer = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < M; c++) {
                if (visit[r][c] || board[r][c] == 0) {
                    continue;
                }
                answer = Math.max(answer, BFS(r, c));
            }
        }
        sb.append(total()).append("\n").append(answer);
        System.out.println(sb);
    }

    private static int power2(int base) {
        return (int) Math.pow(2, base);
    }

    private static int[][] copyArr(int[][] from) {
        int[][] to = new int[M][M];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < M; c++) {
                to[r][c] = from[r][c];
            }
        }
        return to;
    }

    private static void play() {
        int size = power2(L);
        if (1 < size) {
            for (int r = 0; r < M; r += size) {
                for (int c = 0; c < M; c += size) {
                    rotate(r, c, size);
                }
            }
        }
        melt();
    }

    private static void rotate(int R, int C, int size) {
        int[][] tmp = copyArr(board);

        for(int br = R, nc = C + size - 1; br < R + size; br++, nc--){
            for(int bc = C, nr = R; bc < C + size; bc++, nr++){
                tmp[nr][nc] = board[br][bc];
            }
        }
        board = copyArr(tmp);
    }

    private static boolean isOut(int r, int c) {
        return r < 0 || M <= r || c < 0 || M <= c;
    }

    private static void melt() {
        int[][] tmp = copyArr(board);

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < M; c++) {
                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (isOut(nr, nc) || board[nr][nc] == 0) {
                        count++;
                    }
                }
                if (2 <= count && tmp[r][c] != 0) {
                    tmp[r][c]--;
                }
            }
        }
        board = copyArr(tmp);
    }

    private static int total() {
        int answer = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < M; c++) {
                answer += board[r][c];
            }
        }
        return answer;
    }

    private static int BFS(int R, int C) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[]{R, C});
        visit[R][C] = true;
        int result = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.pollFirst();
            int r = now[0];
            int c = now[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (isOut(nr, nc) || board[nr][nc] == 0 || visit[nr][nc]) {
                    continue;
                }
                queue.offerLast(new int[]{nr, nc});
                visit[nr][nc] = true;
                result++;
            }
        }
        return result;
    }
}