package etc;

import java.io.*;
import java.util.*;

public class d17_bj_g4_14500_테트로미노 {
    private static int N, M;
    private static int[][] paper,
        dr =   {{0, 0},
                {1, 1},
                {-2, -1}, {-2, -1}, {2, 1}, {2, 1}, {1, 0}, {1, 0}, {-1, 0}, {-1, 0},
                {-1, 1}, {-1, 1}, {1, 1}, {1, 1},
                {0, 1}, {-1, 0}, {-1, 1}, {-1, 1}},
        dc =   {{2, 3},
                {0, 1},
                {0, 0}, {1, 1}, {0, 0}, {1, 1}, {-1, -1}, {2, 2}, {-1, -1}, {2, 2},
                {0, 1}, {1, 0}, {-1, 0}, {1, 2},
                {2, 1}, {1, 2}, {0, 0}, {1, 1},};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        int answer = 0;
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++) paper[n][m] = Integer.parseInt(st.nextToken());
        }
        for(int n=0; n<N; n++) for(int m=0; m<M-1; m++) answer = Math.max(answer, option(n, m));
        for(int n=0; n<N-3; n++) answer = Math.max(answer, stick(n, M-1));
        System.out.println(answer);
    }

    private static int option(int r, int c){
        int base = paper[r][c]+paper[r][c+1];
        int max = 0;
        for(int t=0; t<18; t++){
            int nr0 = r+dr[t][0], nc0 = c+dc[t][0], nr1 = r+dr[t][1], nc1 = c+dc[t][1];
            if(nr0<0 || nr0>=N || nc0<0 || nc0>=M || nr1<0 || nr1>=N || nc1<0 || nc1>=M)  continue;
            max = Math.max(max, paper[nr0][nc0]+paper[nr1][nc1]);
        }
        max = Math.max(base+max, stick(r, c));
        return max;
    }

    private static int stick(int r, int c){
        if(r+3>=N) return 0;
        int sum = paper[r][c];
        for(int d=1; d<4; d++) sum += paper[r+d][c];
        return sum;
    }
}
