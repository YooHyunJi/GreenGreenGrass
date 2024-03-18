package a2403;

import java.io.*;
import java.util.*;

public class d18_bj_s5_1531_투명 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] painting = new int[101][101];
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int rStart = Integer.parseInt(st.nextToken());
            int cStart = Integer.parseInt(st.nextToken());
            int rEnd = Integer.parseInt(st.nextToken());
            int cEnd = Integer.parseInt(st.nextToken());
            for(int r=rStart; r<=rEnd; r++){
                for(int c=cStart; c<=cEnd; c++){
                    if(painting[r][c] > M){ continue; }
                    if(++painting[r][c] > M){ answer++; }
                }
            }
        }
        System.out.println(answer);
    }
}
