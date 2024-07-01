package a2407;

import java.io.*;
import java.util.*;

public class d01_bj_s2_18111_마인크래프트 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                map[n][m]= Integer.parseInt(st.nextToken());
            }
        }
        int T = Integer.MAX_VALUE;
        int L = 0;
        for(int l=256; 0<=l; l--){
            int cntOff = 0;
            int cntOn = 0;
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(map[n][m] < l){
                        cntOn += l - map[n][m];
                    }
                    else{
                        cntOff += map[n][m] - l;
                    }
                }
            }
            if(cntOff + B < cntOn){ continue; }
            int newTime = 2 * cntOff + cntOn;
            if(newTime < T){
                T = newTime;
                L = l;
            }
        }
        System.out.println(T+" "+L);
    }
}
