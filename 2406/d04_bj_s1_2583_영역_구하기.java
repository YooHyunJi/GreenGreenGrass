package a2406;

import java.io.*;
import java.util.*;

public class d04_bj_s1_2583_영역_구하기 {
    static int N, M, K;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int lbx = Integer.parseInt(st.nextToken());
            int lby = Integer.parseInt(st.nextToken());
            int rtx = Integer.parseInt(st.nextToken());
            int rty = Integer.parseInt(st.nextToken());
            for(int r=N-1-lby; N-1-rty<r; r--){
                for(int c=lbx; c<rtx; c++){
                    map[r][c] = 1;
                }
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(map[r][c] == 0){
                    pq.offer(BFS(r, c));
                }
            }
        }
        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(sb);
    }

    static int BFS(int r, int c){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int size = 0;
        map[r][c] = -1;
        queue.offerLast(new int[] {r, c});

        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            size++;
            for(int d=0; d<4; d++){
                int nr = now[0]+dr[d];
                int nc = now[1]+dc[d];
                if(nr<0 || N<=nr || nc<0 || M<=nc || map[nr][nc]!=0){ continue; }
                map[nr][nc] = -1;
                queue.offerLast(new int[] {nr, nc});
            }
        }
        return size;
    }
}
