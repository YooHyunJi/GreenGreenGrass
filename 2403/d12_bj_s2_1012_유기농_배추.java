package a2403;

import java.io.*;
import java.util.*;

public class d12_bj_s2_1012_유기농_배추 {
    static int N, M;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1 ,0, -1};
    static boolean[][] field, v;
    static ArrayDeque<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            field = new boolean[N][M];
            v = new boolean[N][M];
            int answer = 0;
            for(int k=0; k<K; k++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                field[Y][X] = true;
            }
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(field[n][m] && !v[n][m]) {
                        BFS(n, m);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void BFS(int n, int m){
        v[n][m] = true;
        queue.offerLast(new int[] {n, m});
        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int nr = now[0];
            int nc = now[1];
            for(int d=0; d<4; d++){
                int r = nr + dr[d];
                int c = nc + dc[d];
                if(isOutField(r, c) || !field[r][c] || v[r][c]){ continue; }
                v[r][c] = true;
                queue.offerLast(new int[] {r, c});
            }
        }
    }

    static boolean isOutField(int r, int c){
        return r<0 || r>=N || c<0 || c>=M;
    }
}
