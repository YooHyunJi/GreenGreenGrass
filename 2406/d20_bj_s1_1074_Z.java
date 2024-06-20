package a2406;

import java.io.*;
import java.util.*;

public class d19_bj_s1_1074_Z {
    static int N, R, C, cnt = 0;
    static boolean isFinished = false;
    static int[] dr = {0, 0, 1, 1}, dc = {0, 1, 0, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int width = (int) Math.pow(2, N);

        travel(0, 0, width);
    }

    static void travel(int r, int c, int width){
        if(isFinished){ return; }
        if(width == 2){
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr == R && nc == C){
                    System.out.println(cnt);
                    isFinished = true;
                    return;
                }
                cnt++;
            }
            return;
        }
        int half = width / 2;
        if(r <= R && R < r+width && c <= C && C < c+width){
            travel(r, c, half);
            travel(r, c+half, half);
            travel(r+half, c, half);
            travel(r+half, c+half, half);
        }
        else{
            cnt += width * width;
        }
    }
}