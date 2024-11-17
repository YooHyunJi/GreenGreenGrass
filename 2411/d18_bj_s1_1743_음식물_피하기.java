package a2411;

import java.io.*;
import java.util.*;

public class d18_bj_s1_1743_음식물_피하기 {

    static int N, M;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static boolean[][] map, visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        visit = new boolean[N][M];
        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())- 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = true;
        }
        
        int answer = 0;
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                if(visit[n][m]){ continue; }
                if(map[n][m]){ answer = Math.max(answer, BFS(n, m)); }
            }
        }
        System.out.println(answer);
    }

    static boolean isOut(int r, int c){
        return r < 0 || N <= r || c < 0 || M <= c;
    }

    static int BFS(int n, int m){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[] {n, m});
        visit[n][m] = true;

        int size = 1;
        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int r = now[0];
            int c = now[1];
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isOut(nr, nc) || !map[nr][nc] || visit[nr][nc]){ continue; }
                queue.offerLast(new int[] {nr, nc});
                visit[nr][nc] = true;
                size++;
            }
        }
        return size;
    }
}
