package a2405;

import java.io.*;
import java.util.*;

public class d25_bj_s2_17086_아기상어 {
    static int N, M, answer = 0;
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0}, dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[][] space;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        space = new int[N][M];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                space[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                if(space[n][m] == 1){ continue; }
                BFS(n, m);
            }
        }
        System.out.println(answer);
    }

    static void BFS(int R, int C){
        boolean[][] v = new boolean[N][M];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        v[R][C] = true;
        queue.offerLast(new int[]{R, C, 0});

        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int r = now[0];
            int c = now[1];
            int distance = now[2];
            if(space[r][c] == 1){
                answer = Math.max(answer, distance);
                break;
            }
            for(int d=0; d<8; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isOut(nr, nc) || v[nr][nc]){
                    continue;
                }
                v[nr][nc] = true;
                queue.offerLast(new int[]{nr, nc, distance+1});
            }
        }
    }

    static boolean isOut(int r, int c){
        return r<0 || N<=r || c<0 || M<=c;
    }
}
