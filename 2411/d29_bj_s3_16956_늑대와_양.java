package a2411;

import java.io.*;
import java.util.*;

public class d29_bj_s3_16956_늑대와_양 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
        char[][] map = new char[R][C];
        int status = 1;

        for(int r=0; r<R; r++){
            map[r] = br.readLine().toCharArray();
        }

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                char now = map[r][c];
                if(now == '.'){
                    map[r][c] = 'D';
                }
                else if(now == 'S'){
                    for(int d=0; d<4; d++){
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if(nr < 0 || R <= nr || nc < 0 || C <= nc){ continue; }
                        if(map[nr][nc] == 'W'){
                            status = 0;
                            break;
                        }
                    }
                }
                else if(now == 'W'){
                    for(int d=0; d<4; d++){
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if(nr < 0 || R <= nr || nc < 0 || C <= nc){ continue; }
                        if(map[nr][nc] == 'S'){
                            status = 0;
                            break;
                        }
                    }
                }
                if(status == 0){ break; }
            }
            if(status == 0){ break; }
        }

        if(status == 0){
            System.out.println(0);
            return;
        }

        sb.append("1\n");
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
