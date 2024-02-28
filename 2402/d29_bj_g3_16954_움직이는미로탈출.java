package a2402;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class d29_bj_g3_16954_움직이는미로탈출 {
    static int answer = 0;
    static int[] dr = {0, -1, -1, 0, 1, 1, 1, 0, -1}, dc = {0, 0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[8][8];
        ArrayDeque<int[]> walls = new ArrayDeque<>();
        for(int r=0; r<8; r++){
            board[r] = br.readLine().toCharArray();
            for(int c=0; c<8; c++){
                if(board[r][c]=='#'){
                    walls.offerFirst(new int[] {r, c});
                }
            }
        }
        moveOok(board, 7, 0, new boolean[8][8], walls);
        System.out.println();
        System.out.println(answer);
    }

    static boolean isInBoard(int r, int c){
        return 0<=r && r<8 && 0<=c && c<8;
    }

    static boolean downWalls(char[][] board, ArrayDeque<int[]> walls, int ookR, int ookC){
        if(walls.isEmpty()){
            return true;
        }
        int len = walls.size();
        for(int i=0; i<len; i++){
            for(int[] wall: walls){ System.out.print(Arrays.toString(wall)+" "); }
            System.out.println();
            printBoard(board, ookR, ookC);
            int[] wall = walls.pollFirst();
            int wr = wall[0];
            int wc = wall[1];
            if(wr+1==ookR && wc==ookC){
                return false;
            }
            board[wr][wc] = '.';
            if(wr==7){
                continue;
            }
            board[wr+1][wc] = '#';
            walls.offerLast(new int[] {wr+1, wc});
        }
        return true;
    }

    static void moveOok(char[][] board, int r, int c, boolean[][] v, ArrayDeque<int[]> walls){
        if(answer == 1){
            return;
        }
        if((r==0 && c==7) || walls.isEmpty()){
            answer = 1;
            System.out.println("yes!!");
            return;
        }
        System.out.println(r+" "+c);
        for(int d=0; d<9; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            System.out.println(">> "+nr+" "+nc);
            if(isInBoard(nr, nc) && board[nr][nc]=='.' && !v[nr][nc]){
                System.out.println("["+(d)+"] "+nr+" "+nc);
                printBoard(board, nr, nc);
                v[nr][nc] = true;

                char[][] tmpBoard = new char[8][8];
                for(int rr=0; rr<8; rr++){
                    for(int cc=0; cc<8; cc++){
                        tmpBoard[rr][cc] = board[rr][cc];
                    }
                }
                ArrayDeque<int[]> tmpWalls = new ArrayDeque<>(walls);
                if(downWalls(tmpBoard, tmpWalls, nr, nc)){
                    moveOok(tmpBoard, nr, nc, new boolean[8][8], tmpWalls);
                }
                else {
                    System.out.println(">>>>>>>>>> crash");
                }
            }
        }
    }

    static void printBoard(char[][] board, int R, int C){
        for(int r=0; r<8; r++){
            for(int c=0; c<8; c++){
                if(r==R && c==C){
                    System.out.print('*');
                    continue;
                }
                System.out.print(board[r][c]);
            }
            System.out.println();
        }
    }
}
