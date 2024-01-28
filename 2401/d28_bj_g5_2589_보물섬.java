package a2401;

import java.io.*;
import java.util.*;

public class d28_bj_g5_2589_보물섬 {
    static int R, C, answer = 0;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static char[][] map;

    static void BFS(int rr, int cc) {
        ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
        boolean[][] v = new boolean[R][C];
        queue.offerLast(new int[] {rr, cc, 0});
        v[rr][cc] = true;
        while(!queue.isEmpty()) {
            int[] now = queue.pollFirst();
            int r = now[0];
            int c = now[1];
            int dist = now[2];
            answer = Math.max(answer, dist);
            for(int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr<0 || nr>=R || nc<0 || nc>=C || map[nr][nc]=='W' || v[nr][nc]) { continue; }
                queue.offerLast(new int[] {nr, nc, dist+1});
                v[nr][nc] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int r=0; r<R; r++) { map[r] = br.readLine().toCharArray(); }
        for(int r=0; r<R; r++) { for(int c=0; c<C; c++) { if(map[r][c]=='L') { BFS(r, c); } } }
        System.out.println(answer);
    }
}