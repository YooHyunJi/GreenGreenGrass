package a2312;

import java.io.*;
import java.util.*;

public class d25_bj_g4_15683_감시 {
    static int N, M, C=0, blank=0, answer=Integer.MAX_VALUE;
    static int[] dr={-1, 0, 1, 0}, dc={0, 1, 0, -1};
    static int[][] room, cctv=new int[8][3];
    static int[][][] directions=new int[][][]{
        {{0}, {1}, {2}, {3}},
        {{0, 2}, {1, 3}},
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
        {{0, 1, 2, 3}},
    };

    static void dfs(int cnt){
        if(answer==0){ return; }
        if(cnt==C){
            answer=Math.min(answer, blank);
            return;
        }
        for(int d=0; d<directions[cctv[cnt][0]].length; d++){
            monitor(cctv[cnt], d);
            dfs(cnt+1);
            rollback(cctv[cnt], d);
        }
    }

    static void monitor(int[] now, int direction){
        int type=now[0], r=now[1], c=now[2];
        for(int d=0; d<directions[type][direction].length; d++){
            int one = directions[type][direction][d];
            int nr = r+dr[one];
            int nc = c+dc[one];
            while(true){
                if(nr<0 || nr>=N || nc<0 || nc>=M || room[nr][nc]==6){ break; }
                if(room[nr][nc]<1 && room[nr][nc]--==0){ blank--; }
                nr+=dr[one];
                nc+=dc[one];
            }
        }
    }

    static void rollback(int[] now, int direction){
        int type=now[0], r=now[1], c=now[2];
        for(int d=0; d<directions[type][direction].length; d++){
            int one = directions[type][direction][d];
            int nr = r+dr[one];
            int nc = c+dc[one];
            while(true){
                if(nr<0 || nr>=N || nc<0 || nc>=M || room[nr][nc]==6){ break; }
                if(room[nr][nc]<1 && ++room[nr][nc]==0){ blank++; }
                nr+=dr[one];
                nc+=dc[one];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for (int m=0; m<M; m++){
                room[n][m] = Integer.parseInt(st.nextToken());
                if(room[n][m]==0){ blank++; }
                else if(room[n][m]<6){ cctv[C++] = new int[] {room[n][m]-1, n, m}; }
            }
        }
        dfs(0);
        System.out.println(answer);
    }
}
