package a2507;

import java.io.*;
import java.util.*;

public class d20_bj_g3_16236_아기_상어 {
    static int N, answer = 0;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, -1, 0, 1}, shark;
    static int[][] pool;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pool = new int[N][N];
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                pool[r][c] = Integer.parseInt(st.nextToken());
                if(pool[r][c] == 9){
                    shark = new int[] {r, c, 2, 0};
                    pool[r][c] = 0;
                }
            }
        }
        while(BFS()){        }
        System.out.println(answer);
    }

    static boolean isOut(int r, int c){
        return r < 0 || N <= r ||c < 0 || N <= c;
    }

    static boolean isEat(int r, int c){
        return (pool[r][c] != 0) && (pool[r][c] < shark[2]);
    }

    static boolean BFS(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[2] == o2[2]){
                if(o1[0] == o2[0]){ return o1[1] - o2[1]; }
                return o1[0] - o2[0];
            }
            return o1[2] - o2[2];
        });
        boolean[][] visit = new boolean[N][N];
        pq.offer(new int[] {shark[0], shark[1], 0});
        visit[shark[0]][shark[1]] = true;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int r = now[0];
            int c = now[1];
            int t = now[2];
            if(isEat(r, c)){
                pool[r][c] = 0;
                shark[0] = r;
                shark[1] = c;
                if(++shark[3] == shark[2]){
                    shark[2]++;
                    shark[3] = 0;
                }
                answer += t;
                return true;
            }
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isOut(nr, nc) || shark[2] < pool[nr][nc] || visit[nr][nc]){ continue; }
                pq.offer(new int[] {nr, nc, t+1});
                visit[nr][nc] = true;
            }
        }
        return false;
    }
}
