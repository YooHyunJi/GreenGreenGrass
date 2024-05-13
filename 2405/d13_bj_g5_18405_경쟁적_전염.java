package a2405;

import java.io.*;
import java.util.*;

public class d13_bj_g5_18405_경쟁적_전염 {
    static class Virus implements Comparable<Virus>{
        int step;
        int num;
        int row;
        int col;

        public Virus(int step, int num, int row, int col){
            this.step = step;
            this.num = num;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Virus o){
            if(step < o.step){ return -1; }
            else if(o.step < step){ return 1; }
            else { return Integer.compare(num, o.num); }
        }
    }

    static int N, K, S, X, Y;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static int[][] board;
    static PriorityQueue<Virus> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                board[r][c] = Integer.parseInt(st.nextToken());
                if(board[r][c] == 0){ continue; }
                pq.offer(new Virus(0, board[r][c], r, c));
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        BFS();
        System.out.println(board[X-1][Y-1]);
    }

    static void BFS(){
        for(int s=0; s<S; s++){
            int size = pq.size();
            for(int i=0; i<size; i++){
                Virus now = pq.poll();
                int nowStep = now.step;
                int nowNum = now.num;
                int nowRow = now.row;
                int nowCol = now.col;
                for(int d=0; d<4; d++){
                    int nr = nowRow + dr[d];
                    int nc = nowCol + dc[d];
                    if(isOut(nr, nc) || board[nr][nc]!=0){ continue; }
                    board[nr][nc] = nowNum;
                    pq.offer(new Virus(nowStep+1, nowNum, nr, nc));
                }
            }
        }
    }

    static boolean isOut(int r, int c){
        return r<0 || N<=r || c<0 || N<=c;
    }
}
