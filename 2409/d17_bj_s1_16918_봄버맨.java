package a2409;

import java.io.*;
import java.util.*;

public class d17_bj_s1_16918_봄버맨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int R = Integer.parseInt(inputs[0]);
        int C = Integer.parseInt(inputs[1]);
        int N = Integer.parseInt(inputs[2]);

        char[][] map = new char[R][C];
        int[][] bombtime = new int[R][C];

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
                if(map[i][j]=='O'){
                    bombtime[i][j] = 3; // 폭탄이 터질 시간 (놓인 시간 + 3)
                }
            }
        }

        int time = 0;
        int[] mi = {1, -1, 0, 0};
        int[] mj = {0, 0, 1, -1};

        while(time++ < N) {

            if(time%2==0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bombtime[i][j] = time+3;
                        }
                    }
                }
            }else if(time%2==1) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (bombtime[i][j] == time) {
                            map[i][j] = '.';
                            for (int d = 0; d < 4; d++) {
                                int ni = i + mi[d];
                                int nj = j + mj[d];

                                if (ni < 0 || nj < 0 || ni >= R || nj >= C) continue;

                                if(map[ni][nj]=='O' && bombtime[ni][nj] != time) {
                                    map[ni][nj] = '.';
                                    bombtime[ni][nj] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }


        for (int i = 0; i < R; i++) {
            System.out.println(map[i]);
        }

    }
//
//    static int R, C, N;
//    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
//    static char[][] map;
////    static ArrayList<int[]>[] bombs;
//
//    public static void main(String[] args) throws Exception{
//        StringBuilder sb = new StringBuilder();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        R = Integer.parseInt(st.nextToken());
//        C = Integer.parseInt(st.nextToken());
//        N = Integer.parseInt(st.nextToken()) - 1;
//        map = new char[R][C];
////        bombs = new ArrayList[2];
////        for(int b=0; b<2; b++){
////            bombs[b] = new ArrayList<>();
////        }
//        for(int r=0; r<R; r++){
//            map[r] = br.readLine().toCharArray();
////            for(int c=0; c<C; c++){
////                if(map[r][c] == 'O'){
////                    bombs[0].add(new int[] {r, c});
////                }
////            }
//        }
//        for(int n=0; n<N; n++){
//            int turn = 1 - (n % 2);
//            if(turn == 1){
//                for(int r=0; r<R; r++){
//                    for(int c=0; c<C; c++){
//                        if(map[r][c] == '.'){
//                            map[r][c] = 'O';
////                            bombs[turn].add(new int[] {r, c});
//                        }
//                    }
//                }
//            }
//            else{
//                for(int r=0; r<R; r++){
//                    for(int c=0; c<C; c++){
//                        if(map[r][c] == '.'){
//                            continue;
//                        }
//                        map[r][c] = '.';
//                        for(int d=0; d<4; d++){
//                            int nr = r + dr[d];
//                            int nc = c + dc[d];
//                            if(nr < 0 || R <= nr || nc < 0 || C <= nc){
//                                continue;
//                            }
//                            map[nr][nc] = '.';
//                        }
//                    }
//                }
//
////                for(int[] bomb: bombs[turn]){
////                    int r = bomb[0];
////                    int c = bomb[1];
////
////                }
//            }
//        }
//        for(int r=0; r<R; r++){
//            for(int c=0; c<C; c++){
//                sb.append(map[r][c]);
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);
//    }
}
