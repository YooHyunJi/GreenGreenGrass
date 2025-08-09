package a2508;

import java.io.*;
import java.util.*;

public class d09_bj_g4_17144_미세먼지_안녕 {

    static int R, C, T;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1}, air_conditioner;
    static int[][] room;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        air_conditioner = new int[] {-1, -1};
        room = new int[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                room[r][c] = Integer.parseInt(st.nextToken());
                if(room[r][c] == -1 && air_conditioner[0] == -1){
                    air_conditioner = new int[]{r, r+1};
                }
            }
        }
        for(int t=0; t<T; t++){
            expand();
            clean();
        }
        System.out.println(countDust());
    }

    static int[][] copyRoom(int[][] origin_room){
        int[][] tmp_room = new int[R][C];
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                tmp_room[r][c] = origin_room[r][c];
            }
        }
        return tmp_room;
    }
    
    static int countDust(){
        int cnt = 0;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                cnt += room[r][c];
            }
        }
        return cnt;
    }

    static boolean isOut(int r, int c){
        return r < 0 || R <= r || c < 0 || C <= c;
    }

    static boolean isAirConditioner(int r, int c){
        return (air_conditioner[0] == r && c == 0) || (air_conditioner[1] == r && c == 0);
    }

    static void expand(){
        int[][] tmp_room = new int[R][C];

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(room[r][c] < 1){
                    continue;
                }
                int amount = room[r][c];
                int nxt_amount = amount / 5;
                int nxt_cnt = 0;

                if(nxt_amount == 0){
                    tmp_room[r][c] += amount;
                    continue;
                }

                for(int d=0; d<4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(isOut(nr, nc) || isAirConditioner(nr, nc)){
                        continue;
                    }
                    nxt_cnt++;
                    tmp_room[nr][nc] += nxt_amount;
                }
                int left_amount = amount - nxt_amount * nxt_cnt;
                tmp_room[r][c] += left_amount;
            }
        }
        room = copyRoom(tmp_room);
    }

    static void clean(){
        int up_r = air_conditioner[0];
        int down_r = air_conditioner[1];

        for(int r=up_r-1; r>=0; r--){
            room[r+1][0] = room[r][0];
        }
        for(int c=1; c<C; c++){
            room[0][c-1] = room[0][c];
        }
        for(int r=1; r<=up_r; r++){
            room[r-1][C-1] = room[r][C-1];
        }
        for(int c=C-2; c>=0; c--){
            room[up_r][c+1] = room[up_r][c];
        }

        for(int r=down_r+1; r<R; r++){
            room[r-1][0] = room[r][0];
        }
        for(int c=1; c<C; c++){
            room[R-1][c-1] = room[R-1][c];
        }
        for(int r=R-2; r>=down_r; r--){
            room[r+1][C-1] = room[r][C-1];
        }
        for(int c=C-2; c>=0; c--){
            room[down_r][c+1] = room[down_r][c];
        }

        room[up_r][0] = 0;
        room[up_r][1] = 0;
        room[down_r][0] = 0;
        room[down_r][1] = 0;
    }
}
