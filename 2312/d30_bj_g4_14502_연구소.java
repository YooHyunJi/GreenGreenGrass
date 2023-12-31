package a2312;

import java.io.*;
import java.util.*;

public class d30_bj_g4_14502_연구소 {
    static int N, M, C, answer = -1;
    static int[] columns, dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static int[][] map, copy;
    static ArrayList<int[]> virus = new ArrayList<>();

    static void setColumn(int idx, int start){
        if(idx==3){
            answer = Math.max(answer, C-getSafeArea());
            return;
        }
        for(int i=start; i<N*M; i++){
            if(map[i/M][i%M]!=0){ continue; }
            columns[idx] = i;
            map[i/M][i%M] = 1;
            setColumn(idx+1, i+1);
            map[i/M][i%M] = 0;
        }
    }

    static int getSafeArea(){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int cnt = 0;
        for(int n=0; n<N; n++){ for(int m=0; m<M; m++){ copy[n][m] = map[n][m]; } }
        for(int[] now: virus){ queue.offerLast(now); }
        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            for(int d=0; d<4; d++){
                int nr = now[0]+dr[d];
                int nc = now[1]+dc[d];
                if(nr<0 || nr>=N || nc<0 || nc>=M || copy[nr][nc]!=0){ continue; }
                copy[nr][nc] = 2;
                queue.offerLast(new int[] {nr, nc});
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = -3;
        map = new int[N][M];
        copy = new int[N][M];
        columns = new int[3];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
                if(map[n][m]==0){ C++; }
                else if(map[n][m]==2){ virus.add(new int[] {n, m}); }
            }
        }
        setColumn(0, 0);
        System.out.println(answer);
    }
}