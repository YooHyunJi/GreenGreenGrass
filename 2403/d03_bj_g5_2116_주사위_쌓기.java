package a2403;

import java.io.*;
import java.util.*;

public class d03_bj_g5_2116_주사위_쌓기 {
    static int N, answer = -1;
    static int[][] dices;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dices = new int[N][6];
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int d=0; d<6; d++){
                dices[n][d] = Integer.parseInt(st.nextToken());
            }
        }
        for(int d=1; d<=6; d++){ dice(0, d, 0); }
        System.out.println(answer);
    }

    static void dice(int now, int floorNum, int sum){
        if(now == N){
            answer = Math.max(answer, sum);
            return;
        }
        int floorIdx = findIdxByNum(now, floorNum);
        int ceilingIdx = findOppositeIdx(floorIdx);
        int ceilingNum = dices[now][ceilingIdx];
        int maxNum = 6;
        for(int d=6; d>0; d--){
            if(d == floorNum || d == ceilingNum){ continue; }
            maxNum = d;
            break;
        }
        dice(now+1, ceilingNum, sum+maxNum);
    }

    static int findIdxByNum(int now, int num){
        for(int d=0; d<6; d++){
            if(dices[now][d] == num){ return d; }
        }
        return -1;
    }

    static int findOppositeIdx(int idx){
        switch (idx){
            case 0: return 5;
            case 1: return 3;
            case 2: return 4;
            case 3: return 1;
            case 4: return 2;
            case 5: return 0;
        }
        return -1;
    }
}