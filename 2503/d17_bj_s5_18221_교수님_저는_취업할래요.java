package a2503;

import java.io.*;
import java.util.*;

public class d17_bj_s5_18221_교수님_저는_취업할래요 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] prof = new int[2];
        int[] sk = new int[2];
        int[][] map = new int[N][N];
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == 2){
                    sk = new int[] {r, c};
                }
                else if(map[r][c] == 5){
                    prof = new int[] {r, c};
                }
            }
        }
        double dist = getDist(sk, prof);
        int answer = 0;
        if(25 <= dist){
            if(countSquare(map, sk, prof)){
                answer = 1;
            }
            else if((sk[0] == prof[0] && countLine(map, sk, prof, true)) || (sk[1] == prof[1] && countLine(map, sk, prof, false))){
                answer = 1;
            }
        }
        System.out.println(answer);
    }

    static double getDist(int[] a, int[] b){
        return Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2);
    }

    static boolean countSquare(int[][] map, int[] sk, int[] prof){
        int cnt = 0;
        int r1 = Math.min(sk[0], prof[0]);
        int r2 = Math.max(sk[0], prof[0]);
        int c1 = Math.min(sk[1], prof[1]);
        int c2 = Math.max(sk[1], prof[1]);
        for(int r=r1; r<=r2; r++){
            for(int c=c1; c<=c2; c++){
                if(map[r][c] == 1){
                    cnt++;
                }
            }
        }
        return 3 <= cnt;
    }

    static boolean countLine(int[][] map, int[] sk, int[] prof, boolean isRowSame){
        int cnt = 0;
        if(isRowSame){
            int r = sk[0];
            int c1 = Math.min(sk[1], prof[1]);
            int c2 = Math.max(sk[1], prof[1]);
            for(int c=c1; c<=c2; c++){
                if(map[r][c] == 1){
                    cnt++;
                }
            }
        }
        else{
            int r1 = Math.min(sk[0], prof[0]);
            int r2 = Math.max(sk[0], prof[0]);
            int c = sk[1];
            for(int r=r1; r<=r2; r++){
                if(map[r][c] == 1){
                    cnt++;
                }
            }
        }
        return 3 <= cnt;
    }
}
