package etc;

import java.util.*;
import java.io.*;

public class Main_g5_14503_로봇청소기 {
    static int N, M, answer = 0;
    static int[] dr = {-1, 0, 1, 0},
                 dc = {0, 1, 0, -1};
    static int[][] map;

    static void clean(int[][] map, int r, int c, int f){
        if(map[r][c]==0){
            answer++;
            map[r][c] = -1;
        }

        for(int d=0; d<4; d++){
            int new_f = (f-d+3)%4;
            if(0<=r+dr[new_f]&&r+dr[new_f]<N &&
               0<=c+dc[new_f]&&c+dc[new_f]<M &&
               map[r+dr[new_f]][c+dc[new_f]]==0){
                clean(map, r+dr[new_f], c+dc[new_f], new_f);
                return;
            }
        }

        int new_f = (f+2)%4;
        if(0<=r+dr[new_f]&&r+dr[new_f]<N &&
           0<=c+dc[new_f]&&c+dc[new_f]<M &&
           map[r+dr[new_f]][c+dc[new_f]]!=1){
            clean(map, r+dr[new_f], c+dc[new_f], f);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()),
            c = Integer.parseInt(st.nextToken()),
            f = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++) map[n][m] = Integer.parseInt(st.nextToken());
        }
        clean(map, r, c, f);
        System.out.println(answer);
    }
}
