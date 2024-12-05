package a2412;

import java.io.*;
import java.util.*;

public class d06_bj_s1_1189_컴백홈 {

    static int R, C, K, answer = 0;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static boolean[][] map, visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];
        visit = new boolean[R][C];
        for(int r=0; r<R; r++){
            String line = br.readLine();
            for(int c=0; c<C; c++){
                map[r][c] = line.charAt(c) == '.';
            }
        }
        visit[R-1][0] = true;
        DFS(R-1, 0, 1);
        System.out.println(answer);
    }

    static void DFS(int r, int c, int k){
        if(r == 0 && c == C-1){
            System.out.println(k);
            if(k == K){ answer++; }
            return;
        }
        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isOut(nr, nc) || !map[nr][nc] || visit[nr][nc]){ continue; }
            visit[nr][nc] = true;
            DFS(nr, nc, k+1);
            visit[nr][nc] = false;
        }
    }

    static boolean isOut(int r, int c){
        return r < 0 || R <= r || c < 0 || C <= c;
    }
}
