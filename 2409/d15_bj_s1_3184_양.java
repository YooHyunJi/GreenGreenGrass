package a2409;

import java.io.*;
import java.util.*;

public class d15_bj_s1_3184_양 {

    static int R, C, sheep = 0, wolf = 0;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static char[][] yard;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        yard = new char[R][C];
        visit = new boolean[R][C];
        for(int r=0; r<R; r++){
            yard[r] = br.readLine().toCharArray();
            for(int c=0; c<C; c++){
                if(yard[r][c] == 'o'){
                    sheep++;
                }
                else if(yard[r][c] == 'v'){
                    wolf++;
                }
            }
        }
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(visit[r][c] || yard[r][c] == '#'){
                    continue;
                }
                BFS(r, c);
            }
        }
        System.out.println(sheep + " " + wolf);
    }

    static boolean isOut(int r, int c){
        return r < 0 || R <= r || c < 0 || C <= c;
    }

    static void BFS(int R, int C){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[] {R, C});
        visit[R][C] = true;

        int cntSheep = 0;
        int cntWolf = 0;


        if(yard[R][C] == 'o'){
            cntSheep++;
        }
        else if(yard[R][C] == 'v'){
            cntWolf++;
        }

        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int r = now[0];
            int c = now[1];
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isOut(nr, nc) || visit[nr][nc] || yard[nr][nc] == '#'){
                    continue;
                }
                queue.offerLast(new int[] {nr, nc});
                visit[nr][nc] = true;
                if(yard[nr][nc] == 'o'){
                    cntSheep++;
                }
                else if(yard[nr][nc] == 'v'){
                    cntWolf++;
                }
            }
        }
        if(cntWolf < cntSheep){
            wolf -= cntWolf;
        }
        else{
            sheep -= cntSheep;
        }
    }
}
