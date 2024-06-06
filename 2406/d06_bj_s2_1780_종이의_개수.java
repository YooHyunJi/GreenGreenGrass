package a2406;

import java.io.*;
import java.util.*;

public class d06_bj_s2_1780_종이의_개수 {
    static int[] cnt = new int[3];
    static int[][] paper;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        judgePaper(0, 0, N);
        for(int i=0; i<3; i++){
            System.out.println(cnt[i]);
        }
    }

    static void judgePaper(int startR, int startC, int w){
        int firstNum = paper[startR][startC];
        for(int r=startR; r<startR+w; r++){
            for(int c=startC; c<startC+w; c++){
                if(paper[r][c] == firstNum){ continue; }
                int triple = w/3;
                for(int i=0; i<3; i++){
                    for(int j=0; j<3; j++){
                        judgePaper(startR+triple*i, startC+triple*j, triple);
                    }
                }
                return;
            }
        }
        cnt[firstNum+1] ++;
    }
}
