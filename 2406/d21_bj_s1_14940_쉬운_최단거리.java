package a2406;

import java.io.*;
import java.util.*;

public class d21_bj_s1_14940_쉬운_최단거리 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1}, start = new int[2];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                switch (map[r][c]){
                    case 0:
                        continue;
                    case 1:
                        map[r][c] = -1;
                        break;
                    case 2:
                        start = new int[] {r, c, 0};
                        break;
                }
            }
        }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(start);
        map[start[0]][start[1]] = 0;
        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            for(int d=0; d<4; d++){
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];
                int depth = now[2];
                if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc]==-1){
                    queue.offerLast(new int[] {nr, nc, depth + 1});
                    map[nr][nc] = depth + 1;
                }
            }
        }
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                sb.append(map[r][c]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
