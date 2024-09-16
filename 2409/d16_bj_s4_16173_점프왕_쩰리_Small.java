package a2409;

import java.io.*;
import java.util.*;

public class d16_bj_s4_16173_점프왕_쩰리_Small {

    static int N;
    static int[] dr = {0, 1}, dc = {1, 0};
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        BFS();
    }

    static boolean isOut(int r, int c){
        return r < 0 || N <= r || c < 0 || N <= c;
    }

    static void BFS(){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[] {0, 0});
        boolean[][] visit = new boolean[N][N];
        visit[0][0] = true;

        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int r = now[0];
            int c = now[1];
            int p = map[r][c];
            for(int d=0; d<2; d++){
                int nr = r + p * dr[d];
                int nc = c + p * dc[d];
                if(nr == N-1 && nc == N-1){
                    System.out.println("HaruHaru");
                    return;
                }
                if(isOut(nr, nc) || visit[nr][nc]){
                    continue;
                }
                queue.offerLast(new int[] {nr, nc});
                visit[nr][nc] = true;
            }
        }
        System.out.println("Hing");
        return;
    }
}
