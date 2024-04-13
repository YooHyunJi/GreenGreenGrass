package a2404;

import java.io.*;

public class d13_bj_g4_9207_페그_솔리테어 {
    static int H = 5, W = 9, minPin, minMove;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            minPin = Integer.MAX_VALUE;
            minMove = Integer.MAX_VALUE;
            char[][] board = new char[H][W];
            int totalPin = 0;
            for(int r=0; r<H; r++){
                board[r] = br.readLine().toCharArray();
                for(int c=0; c<W; c++){
                    if(board[r][c] == 'o'){ totalPin++; }
                }
            }
            DFS(board, totalPin, 0);
            sb.append(minPin).append(" ").append(minMove).append("\n");
            br.readLine();
        }
        System.out.println(sb);
    }

    static void DFS(char[][] board, int totalPin, int totalMove){
        boolean isProceeding = false;
        for(int r=0; r<H; r++){
            for(int c=0; c<W; c++){
                if(board[r][c] == 'o'){
                    for(int d=0; d<4; d++){
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if(outBoundary(nr, nc) || board[nr][nc]!='o'){ continue; }
                        int nnr = nr + dr[d];
                        int nnc = nc + dc[d];
                        if(outBoundary(nnr, nnc) || board[nnr][nnc]!='.'){ continue; }
                        board[r][c] = '.';
                        board[nr][nc] = '.';
                        board[nnr][nnc] = 'o';
                        DFS(board, totalPin-1, totalMove+1);
                        board[r][c] = 'o';
                        board[nr][nc] = 'o';
                        board[nnr][nnc] = '.';
                        isProceeding = true;
                    }
                }
            }
        }
        if(!isProceeding){
            if(totalPin < minPin){
                minPin = totalPin;
                minMove = totalMove;
            }
        }
    }

    static boolean outBoundary(int r, int c){
        return r<0 || H<=r || c<0 || W<=c;
    }
}
