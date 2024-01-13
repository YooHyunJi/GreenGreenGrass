package a2401;

import java.io.*;
import java.util.*;

public class d13_bj_s1_2468_안전영역 {
    static int N;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] v;

    static int BFS(int R, int C) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[] {R, C});
        v[R][C] = true;
        while(!queue.isEmpty()) {
            int[] now = queue.pollFirst();
            int r = now[0];
            int c = now[1];
            for(int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr<0 || nr>=N || nc<0 || nc>=N || arr[nr][nc]==0 || v[nr][nc]) { continue; }
                queue.offerLast(new int[] {nr, nc});
                v[nr][nc] = true;
            }
        }
        return 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        v = new boolean[N][N];
        int land = N*N;
        int answer = -1;
        for(int r=0; r<N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++) { arr[r][c] = Integer.parseInt(st.nextToken()); }
        }
        for(int lev=1; ;lev++) {
            for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    if(arr[r][c]!=lev) { continue; }
                    arr[r][c] = 0;
                    land--;
                }
            }
            if(land==0) { break; }
            int areas = 0;
            for(boolean[] line: v){ Arrays.fill(line, false); }
            for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    if(arr[r][c]>0 && !v[r][c]) { areas += BFS(r, c); }
                }
            }
            answer = Math.max(answer, areas);
        }
        System.out.println(answer);
    }
}
