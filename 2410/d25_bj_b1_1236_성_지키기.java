package a2410;

import java.io.*;
import java.util.*;

public class d25_bj_b1_1236_성_지키기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N][M];
        for(int n=0; n<N; n++){
            char[] line = br.readLine().toCharArray();
            for(int m=-0; m<M; m++){
                map[n][m] = line[m] == 'X';
            }
        }
        int cntRow = 0;
        int cntCol = 0;
        for(int n=0; n<N; n++){
            boolean isImpossible = false;
            for(int m=0; m<M; m++){
                if(map[n][m]){
                    isImpossible = true;
                    break;
                }
            }
            if(!isImpossible){
                cntRow++;
            }

        }
        for(int m=0; m<M; m++){
            boolean isImpossible = false;
            for(int n=0; n<N; n++){
                if(map[n][m]){
                    isImpossible = true;
                    break;
                }
            }
            if(!isImpossible){
                cntCol++;
            }
        }
        System.out.println(Math.max(cntRow, cntCol));
    }
}
