package a2403;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class d25_bj_g3_2151_거울_설치 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] house = new char[N][N];
        int startR = -1, startC = -1;
        for(int r=0; r<N; r++){
            house[r] = br.readLine().toCharArray();
            for(int c=0; c<N; c++){
                if(house[r][c] == '#' && startR == -1){
                    startR = r;
                    startC = c;
                }
            }
        }
        house[startR][startC] = '.';
        System.out.println(play(startR, startC, N, house));
    }

    static int play(int startR, int startC, int N, char[][] house){
        int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> { return o1[3] - o2[3]; });
        boolean[][][] v = new boolean[N][N][4];

        for(int d=0; d<4; d++){ pq.offer(new int[] {startR, startC, d, 0}); }
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int nowR = now[0];
            int nowC = now[1];
            int nowD = now[2];
            int nowM = now[3];
            v[nowR][nowC][nowD] = true;

            int nxtD, nxtR, nxtC;
            switch (house[nowR][nowC]){
                case '#':
                    return nowM;
                case '!':
                    nxtD = mirror1(nowD);
                    nxtR = nowR + dr[nxtD];
                    nxtC = nowC + dc[nxtD];
                    if(isIn(nxtR, nxtC, N) && house[nxtR][nxtC]!='*' && !v[nxtR][nxtC][nxtD]){
                        pq.offer(new int[] {nxtR, nxtC, nxtD, nowM+1});
                    }
                    nxtD = mirror2(nowD);
                    nxtR = nowR + dr[nxtD];
                    nxtC = nowC + dc[nxtD];
                    if(isIn(nxtR, nxtC, N) && house[nxtR][nxtC]!='*' && !v[nxtR][nxtC][nxtD]){
                        pq.offer(new int[] {nxtR, nxtC, nxtD, nowM+1});
                    }
                case '.':
                    nxtR = nowR + dr[nowD];
                    nxtC = nowC + dc[nowD];
                    if(isIn(nxtR, nxtC, N) && house[nxtR][nxtC]!='*' && !v[nxtR][nxtC][nowD]){
                        pq.offer(new int[] {nxtR, nxtC, nowD, nowM});
                    }
                    break;
            }
        }
        return -1;
    }

    static boolean isIn(int r, int c, int N){
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    static int mirror1(int d){
        return d % 2 == 0? d + 1: d - 1;
    }

    static int mirror2(int d){
        return 3 - d;
    }
}