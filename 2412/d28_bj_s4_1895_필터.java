package a2412;

import java.io.*;
import java.util.*;

public class d28_bj_s4_1895_필터 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1}, dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] original = new int[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                original[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        int T = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int r=1; r<R-1; r++){
            for(int c=1; c<C-1; c++){
                ArrayList<Integer> list = new ArrayList<>();
                for(int d=0; d<9; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    list.add(original[nr][nc]);
                }
                Collections.sort(list);
                int mid = list.get(4);
                if(T <= mid){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}