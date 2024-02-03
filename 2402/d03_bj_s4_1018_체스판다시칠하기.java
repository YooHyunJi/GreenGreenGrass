package a2402;

import java.io.*;
import java.util.*;

public class d03_bj_s4_1018_체스판다시칠하기 {
    static int answer = 64;
    static boolean[][] board;

    static void checkBoard(int R, int C){
        int sumW = 0;
        int sumB = 0;
        boolean nowW = true;
        boolean nowB = false;

        for(int r=R; r<R+8; r++){
            for(int c=C; c<C+8; c++){
                if(nowW==board[r][c]){ sumW++; }
                else { sumB++; }
                nowW = !nowW;
                nowB = !nowB;
            }
            nowW = !nowW;
            nowB = !nowB;
        }
        answer = Math.min(answer, Math.min(sumW, sumB));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new boolean[N][M];
        for(int n=0; n<N; n++){
            char[] line = br.readLine().toCharArray();
            for(int m=0; m<M; m++){ board[n][m] = line[m]=='B'; }
        }
        for(int n=0; n<N-7; n++){ for(int m=0; m<M-7; m++){ checkBoard(n, m); } }
        System.out.println(answer);
    }
}
