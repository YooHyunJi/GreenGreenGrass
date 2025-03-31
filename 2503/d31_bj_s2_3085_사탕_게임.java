package a2503;

import java.io.*;

public class d31_bj_s2_3085_사탕_게임 {

    static int N;
    static char[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        int answer = 0;
        for(int r=0; r<N; r++){
            char[] arr = br.readLine().toCharArray();
            for(int c=0; c<N; c++){
                map[r][c] = arr[c];
            }
        }
        // horizontal
        for(int r=0; r<N; r++){
            for(int c=0; c<N-1; c++){
                answer = Math.max(answer, getMaxCandies(r, c, true));
            }
        }

        // vertical
        for(int c=0; c<N; c++){
            for(int r=0; r<N-1; r++){
                answer = Math.max(answer, getMaxCandies(r, c, false));
            }
        }
        System.out.println(answer);
    }

    static int getMaxCandies(int r, int c, boolean isHorizontal) {
        char tmp = map[r][c];
        char[][] cpMap = new char[N][N];

        for(int rr=0; rr<N; rr++){
            for(int cc=0; cc<N; cc++){
                cpMap[rr][cc] = map[rr][cc];
            }
        }

        if(isHorizontal){
            if(cpMap[r][c] == cpMap[r][c+1]){
                return 0;
            }
            cpMap[r][c] = cpMap[r][c+1];
            cpMap[r][c+1] = tmp;
        }
        else{
            if(cpMap[r][c] == cpMap[r+1][c]){
                return 0;
            }
            cpMap[r][c] = cpMap[r+1][c];
            cpMap[r+1][c] = tmp;
        }

        int max = 1;
        for(int rr=0; rr<N; rr++){
            int cnt = 1;
            char nowColor = cpMap[rr][0];
            for(int cc=1; cc<N; cc++){
                if(nowColor == cpMap[rr][cc]){
                    cnt++;
                }
                else{
                    max = Math.max(max, cnt);
                    cnt = 1;
                    nowColor = cpMap[rr][cc];
                }
                if(cc == N-1){
                    max = Math.max(max, cnt);
                }
            }
        }
        for(int cc=0; cc<N; cc++){
            int cnt = 1;
            char nowColor = cpMap[0][cc];
            for(int rr=1; rr<N; rr++){
                if(nowColor == cpMap[rr][cc]){
                    cnt++;
                }
                else{
                    max = Math.max(max, cnt);
                    cnt = 1;
                    nowColor = cpMap[rr][cc];
                }
                if(rr == N-1){
                    max = Math.max(max, cnt);
                }
            }
        }
        return max;
    }
}
