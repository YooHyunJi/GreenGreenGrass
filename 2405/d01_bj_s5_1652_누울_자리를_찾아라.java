package a2405;

import java.io.*;
import java.util.*;

public class d01_bj_s5_1652_누울_자리를_찾아라 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] room = new char[N][N];
        int[] answer = new int[2];
        for(int r=0; r<N; r++){
            room[r] = br.readLine().toCharArray();
        }
        for(int d=0; d<N; d++){
            int[] cnt = new int[2];
            for(int dd=0; dd<N; dd++){
                if(room[d][dd] == '.'){ cnt[0]++; }
                else if(room[d][dd] == 'X'){
                    if(2 <= cnt[0]){ answer[0]++; }
                    cnt[0] = 0;
                }
                if(room[dd][d] == '.'){ cnt[1]++; }
                else if(room[dd][d] == 'X'){
                    if(2 <= cnt[1]){ answer[1]++; }
                    cnt[1] = 0;
                }
            }
            if(2 <= cnt[0]){ answer[0]++; }
            if(2 <= cnt[1]){ answer[1]++; }
        }
        System.out.println(answer[0]+" "+answer[1]);
    }
}
