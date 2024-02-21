package a2402;

import java.io.*;
import java.util.*;

public class d22_bj_g5_14719_빗물 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        boolean[][] world = new boolean[H][W];
        st = new StringTokenizer(br.readLine());
        for(int c=0; c<W; c++){
            int block = Integer.parseInt(st.nextToken());
            for(int d=0; d<block; d++){ world[d][c] = true; }
        }
        for(int r=0; r<H; r++){
            boolean start = false;
            int rain = 0;
            for(int c=0; c<W; c++){
                if(world[r][c]){
                    if(!start){
                        start = true;
                        continue;
                    }
                    answer += rain;
                    rain = 0;
                    continue;
                }
                if(start){ rain++; }
            }
        }
        System.out.println(answer);
    }
}