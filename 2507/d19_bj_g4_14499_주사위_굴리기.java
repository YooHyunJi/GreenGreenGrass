package a2507;

import java.io.*;
import java.util.*;

public class d19_bj_g4_14499_주사위_굴리기 {

    static int N, M, x, y, K;
    static int[] dr = {0, 0, -1, 1}, dc = {1, -1, 0, 0}, dice = new int[6];
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int k=0; k<K; k++){
            int d = Integer.parseInt(st.nextToken()) - 1;
            int nx = x + dr[d];
            int ny = y + dc[d];
            if(isOut(nx, ny)){ continue; }
            x = nx;
            y = ny;
            rollDice(d);
            stamp();
            sb.append(dice[0]).append("\n");
        }
        System.out.println(sb);
    }

    static boolean isOut(int x, int y){
        return x < 0 || N <= x || y < 0 || M <= y;
    }

    static void rollDice(int d){
        int[] tempDice = new int[6];
        for(int i=0; i<6; i++){
            tempDice[i] = dice[i];
        }
        switch (d){
            case 0:
                dice[0] = tempDice[3];
                dice[2] = tempDice[0];
                dice[5] = tempDice[2];
                dice[3] = tempDice[5];
                break;
            case 1:
                dice[0] = tempDice[2];
                dice[3] = tempDice[0];
                dice[5] = tempDice[3];
                dice[2] = tempDice[5];
                break;
            case 2:
                dice[1] = tempDice[0];
                dice[0] = tempDice[4];
                dice[4] = tempDice[5];
                dice[5] = tempDice[1];
                break;
            case 3:
                dice[5] = tempDice[4];
                dice[4] = tempDice[0];
                dice[0] = tempDice[1];
                dice[1] = tempDice[5];
                break;
        }
    }

    static void stamp(){
        if(map[x][y] == 0){
            map[x][y] = dice[5];
        }
        else{
            dice[5] = map[x][y];
            map[x][y] = 0;
        }
    }
}
