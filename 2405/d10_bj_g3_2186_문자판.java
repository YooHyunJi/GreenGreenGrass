package a2405;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d10_bj_g3_2186_문자판 {
    static int N, M, K, C, answer = 0;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static int[][][] dp;
    static char[][] board;
    static String word;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N][M][K];
        board = new char[N][M];
        for(int n=0; n<N; n++){
            board[n] = br.readLine().toCharArray();
            for(int m=0; m<M; m++){ Arrays.fill(dp[n][m], -1); }
        }
        word = br.readLine();
        C = word.length();

        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                if(board[n][m] == word.charAt(0)){
                    dp[n][m][0] = 0;
                    DFS(n, m, 1);
                }
            }
        }
        System.out.println(answer);
    }

    static void DFS(int n, int m, int cnt){
        if(dp[n][m][cnt] != -1){ return; }
        if(cnt == C){
            answer++;
            return;
        }
        char next = word.charAt(cnt);
        for(int d=0; d<4; d++){
            int nr = n;
            int nc = m;
            for(int k=1; k<=K; k++){
                nr += dr[d];
                nc += dc[d];
                if(isOut(nr, nc)){ break; }
                if(board[nr][nc] == next){
                    dp[nr][nc][cnt] = cnt+1;
                    DFS(nr, nc, cnt+1);
                }
            }
        }
    }

    static boolean isOut(int r, int c){
        return r<0 || N<=r || c<0 || M<=c;
    }

}