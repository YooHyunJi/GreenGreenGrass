package a2504;

import java.io.*;
import java.util.*;

public class d05_bj_s5_1996_지뢰_찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        int[][] result = new int[N][N];
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
        for(int n=0; n<N; n++){
            map[n] = br.readLine().toCharArray();
        }
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(map[r][c] == '.'){
                    continue;
                }
                int num = map[r][c] - '0';
                for(int d=0; d<8; d++){
                    int nr = r + dr[d];
                    int nc = c+ dc[d];
                    if(nr < 0 || N <= nr || nc < 0 || N <= nc){
                        continue;
                    }
                    result[nr][nc] += num;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(map[r][c] != '.'){
                    sb.append('*');
                    continue;
                }
                sb.append(10 <= result[r][c]? "M": result[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
