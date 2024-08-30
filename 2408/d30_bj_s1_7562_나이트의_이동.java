package a2408;

import java.io.*;
import java.util.*;

public class d30_bj_s1_7562_나이트의_이동 {

    static int L;
    static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2}, dc = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[][] chess;

    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            L = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());
            int result = BFS(sr, sc, er, ec);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    static boolean isOut(int r, int c){
        return r<0 || L<=r || c<0 || L<=c;
    }

    static int BFS(int sr, int sc, int er, int ec){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[L][L];
        queue.offerLast(new int[] {sr, sc, 0});
        visit[sr][sc] = true;

        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int r = now[0];
            int c = now[1];
            int s = now[2];
            for(int d=0; d<8; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isOut(nr, nc) || visit[nr][nc]){
                    continue;
                }
                if(nr == er && nc == ec){
                    return s+1;
                }
                queue.offerLast(new int[] {nr, nc, s+1});
                visit[nr][nc] = true;
            }
        }
        return 0;
    }
}
