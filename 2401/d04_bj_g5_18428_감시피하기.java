package a2401;

import java.io.*;
import java.util.*;

public class d04_bj_g5_18428_감시피하기 {
    static boolean answer;
    static int N, T=0;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static int[][] teachers = new int[36][2];
    static String[][] corridor;

    static void makeComb(int idx, int start) {
        if(answer) { return; }
        if(idx==3) {
            if(monitor()) { answer = true; }
            return;
        }
        for(int n=start; n<N*N; n++) {
            if(!corridor[n/N][n%N].equals("X")) { continue; }
            corridor[n/N][n%N] = "O";
            makeComb(idx+1, n+1);
            corridor[n/N][n%N] = "X";
        }
    }

    static boolean monitor() {
        for(int t=0; t<T; t++){
            for(int d=0; d<4; d++) {
                int nr = teachers[t][0]+dr[d];
                int nc = teachers[t][1]+dc[d];
                while(inBoundary(nr, nc)) {
                    if(corridor[nr][nc].equals("O")) { break; }
                    if(corridor[nr][nc].equals("S")) { return false; }
                    nr += dr[d];
                    nc += dc[d];
                }
            }
        }
        return true;
    }

    static boolean inBoundary(int r, int c) {
        if(r<0 || r>=N || c<0 || c>=N) return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        corridor = new String[N][N];
        for(int n=0; n<N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int nn=0; nn<N; nn++) {
                corridor[n][nn] = st.nextToken();
                if(corridor[n][nn].equals("T")) { teachers[T++] = new int[] {n, nn}; }
            }
        }
        makeComb(0, 0);
        if(answer) { System.out.println("YES"); }
        else { System.out.println("NO"); }
    }
}