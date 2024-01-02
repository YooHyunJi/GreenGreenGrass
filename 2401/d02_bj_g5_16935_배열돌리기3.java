package a2401;

import java.io.*;
import java.util.*;

public class d02_bj_g5_16935_배열돌리기3 {
    static int N, M;
    static int[][][] arr;

    static void swap(){
        int tmp = N;
        N = M;
        M = tmp;
    }
    static void op1(int[][] from, int[][] to){
        for(int n=0; n<N; n++){ for(int m=0; m<M; m++){ to[n][m] = from[N-1-n][m]; } }
    }
    static void op2(int[][] from, int[][] to) {
        for (int n=0; n<N; n++) { for (int m=0; m<M; m++) { to[n][m] = from[n][M-1-m]; }}
    }
    static void op3(int[][] from, int[][] to) {
        swap();
        for (int n=0; n<N; n++) { for (int m=0; m<M; m++) { to[n][m] = from[M-1-m][n]; } }
    }
    static void op4(int[][] from, int[][] to) {
        swap();
        for (int n=0; n<N; n++) { for (int m=0; m<M; m++) { to[n][m] = from[m][N-1-n]; } }
    }
    static void op5(int[][] from, int[][] to) {
        for(int n=0; n<N/2; n++){
            for(int m=0; m<M/2; m++){
                to[n][m] = from[N/2+n][m];
                to[n][M/2+m] = from[n][m];
                to[N/2+n][m] = from[N/2+n][M/2+m];
                to[N/2+n][M/2+m] = from[n][M/2+m];
            }
        }
    }
    static void op6(int[][] from, int[][] to) {
        for(int n=0; n<N/2; n++){
            for(int m=0; m<M/2; m++){
                to[n][m] = from[n][M/2+m];
                to[n][M/2+m] = from[N/2+n][M/2+m];
                to[N/2+n][m] = from[n][m];
                to[N/2+n][M/2+m] = from[N/2+n][m];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        arr = new int[2][Math.max(N, M)][Math.max(N, M)];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){ arr[0][n][m] = Integer.parseInt(st.nextToken()); }
        }
        st = new StringTokenizer(br.readLine());
        for(int r=0; r<R; r++){
            switch (st.nextToken()){
                case "1":
                    op1(arr[r%2], arr[(r+1)%2]);
                    break;
                case "2":
                    op2(arr[r%2], arr[(r+1)%2]);
                    break;
                case "3":
                    op3(arr[r%2], arr[(r+1)%2]);
                    break;
                case "4":
                    op4(arr[r%2], arr[(r+1)%2]);
                    break;
                case "5":
                    op5(arr[r%2], arr[(r+1)%2]);
                    break;
                case "6":
                    op6(arr[r%2], arr[(r+1)%2]);
                    break;
            }
        }
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){sb.append(arr[R%2][n][m]).append(" "); }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}