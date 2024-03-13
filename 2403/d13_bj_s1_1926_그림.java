package a2403;

import java.io.*;
import java.util.*;

public class d13_bj_s1_1926_그림 {
    static int N, M, drawing = 0, max = 0;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static boolean[][] paper, v;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new boolean[N][M];
        v = new boolean[N][M];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                paper[n][m] = st.nextToken().equals("1");
            }
        }
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                if(!paper[n][m] || v[n][m]){ continue; }
                BFS(n, m);
            }
        }
        System.out.println(drawing);
        System.out.println(max);
    }

    static void BFS(int n, int m){
        drawing++;
        int size = 1;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[] {n, m});
        v[n][m] = true;
        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int r = now[0];
            int c = now[1];
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isOutPaper(nr, nc) || !paper[nr][nc] || v[nr][nc]){ continue; }
                queue.offerLast(new int[] {nr, nc});
                v[nr][nc] = true;
                size++;
            }
        }
        max = Math.max(max, size);
    }

    static boolean isOutPaper(int r, int c){
        return r<0 || r>=N || c<0 || c>=M;
    }
}
