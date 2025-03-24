package a2503;

import java.io.*;
import java.util.*;

public class d24_bj_s4_18242_네모네모_시력검사 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N][M];
        for(int n=0; n<N; n++){
            String line = br.readLine();
            for(int m=0; m<M; m++){
                map[n][m] = line.charAt(m) == '#';
            }
        }
        int ltr = 0, ltc = 0, rbr = 0, rbc = 0;
        boolean isFind = false;
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                if(map[n][m]){
                    ltr = n;
                    ltc = m;
                    isFind = true;
                    break;
                }
            }
            if(isFind){
                break;
            }
        }
        isFind = false;
        for(int n=N-1; n>=0; n--){
            for(int m=M-1; m>=0; m--){
                if(map[n][m]){
                    rbr = n;
                    rbc = m;
                    isFind = true;
                    break;
                }
            }
            if(isFind){
                break;
            }
        }
        for(int c=ltc; c<=rbc; c++){
            if(!map[ltr][c]){
                System.out.println("UP");
            }
            else if(!map[rbr][c]){
                System.out.println("DOWN");
            }
        }
        for(int r=ltr; r<=rbr; r++){
            if(!map[r][ltc]){
                System.out.println("LEFT");
            }
            else if(!map[r][rbc]){
                System.out.println("RIGHT");
            }
        }
    }
}
