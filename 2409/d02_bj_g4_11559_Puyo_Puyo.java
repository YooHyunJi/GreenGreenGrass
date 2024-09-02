package a2409;

import java.io.*;
import java.util.*;

public class d02_bj_g4_11559_Puyo_Puyo {

    static int R = 12, C = 6, answer = 0;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static char[][] field;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        field = new char[R][C];
        for (int r = 0; r < R; r++) {
            field[r] = br.readLine().toCharArray();
        }
        print();
        System.out.println(playPuyo());
    }

    private static boolean isOut(int r, int c) {
        return r < 0 || R <= r || c < 0 || C <= c;
    }

    private static int playPuyo(){
        int count = 0;
        while(findPuyo()){
            gravity();
            print();
            count++;
        }
        return count;
    }

    private static boolean findPuyo() {
        visit = new boolean[R][C];
        boolean isProceeding = false;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (field[r][c] == '.') {
                    continue;
                }
                if (popPuyo(r, c)) {
                    isProceeding = true;
                }
            }
        }
        return isProceeding;
    }

    private static boolean popPuyo(int R, int C) {
        char color = field[R][C];
        List<int[]> puyos = new ArrayList<>();
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        puyos.add(new int[] {R, C});
        queue.offerLast(new int[] {R, C});
        visit[R][C] = true;

        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int r = now[0];
            int c = now[1];
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isOut(nr, nc) || field[nr][nc] != color || visit[nr][nc]){
                    continue;
                }
                puyos.add(new int[] {nr, nc});
                queue.offerLast(new int[] {nr, nc});
                visit[nr][nc] = true;
            }
        }

        if(puyos.size() < 4){
            return false;
        }

        for(int[] puyo: puyos){
            int r = puyo[0];
            int c = puyo[1];
            field[r][c] = '.';
        }

        return true;
    }

    private static void gravity() {
        for (int c = 0; c < C; c++) {
            StringBuilder line = new StringBuilder();

            for (int r = R-1; 0 <= r; r--) {
                if(field[r][c] == '.'){
                    continue;
                }
                line.append(field[r][c]);
                field[r][c] = '.';
            }

            for (int i=0; i<line.length(); i++) {
                field[R-1-i][c] = line.charAt(i);
            }
        }
    }

    private static void print(){
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                System.out.print(field[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }

}
