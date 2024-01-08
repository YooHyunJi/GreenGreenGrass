package a2401;

import java.io.*;
import java.util.*;

public class d09_bj_s3_16967_배열복원하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int[][] B = new int[H+X][W+Y];
        for(int r=0; r<H+X; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<W+Y; c++) { B[r][c] = Integer.parseInt(st.nextToken()); }
        }
        for(int r=0; r<X; r++) {
            for(int c=0; c<W; c++) { sb.append(B[r][c]).append(" "); }
            sb.append("\n");
        }
        for(int r=X; r<H; r++) {
            for(int c=Y; c<W; c++) { B[r][c]-=B[r-X][c-Y]; }
            for(int c=0; c<W; c++) { sb.append(B[r][c]).append(" "); }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
