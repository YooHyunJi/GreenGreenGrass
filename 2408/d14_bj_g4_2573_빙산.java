package a2408;

import java.io.*;
import java.util.*;

public class d14_bj_g4_2573_빙산 {
    static boolean isOut(int n, int m, int N, int M){
        return n < 0 || N <= n || m < 0 || M <= m;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
        int left = 0;
        int[][][] arr = new int[2][N][M];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                arr[0][n][m] = Integer.parseInt(st.nextToken());
                if(arr[0][n][m] != 0){ left++; }
            }
        }
        if(left == N*M){
            System.out.println(0);
            return;
        }

        for(int year=1; ; year++){
            int now = year % 2;
            int prev = (year + 1) % 2;
            left = 0;
            int one = 0;
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    arr[now][n][m] = 0;
                }
            }
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(arr[prev][n][m] == 0){ continue; }
                    int cnt = 0;
                    for(int d=0; d<4; d++){
                        int nn = n + dr[d];
                        int nm = m + dc[d];
                        if(isOut(nn, nm, N, M)){ continue; }
                        if(arr[prev][nn][nm] == 0){ cnt++; }
                    }
                    if(arr[prev][n][m] <= cnt){
                        arr[now][n][m] = 0;
                    }
                    else{
                        arr[now][n][m] = arr[prev][n][m] - cnt;
                        left++;
                    }
                }
            }

            if(left == 0){
                System.out.println(0);
                return;
            }

            ArrayDeque<int[]> queue = new ArrayDeque<>();
            boolean[][] visit = new boolean[N][M];
            boolean isFound = false;
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(arr[now][n][m] == 0){ continue; }
                    isFound = true;
                    queue.offerLast(new int[] {n, m});
                    visit[n][m] = true;
                    int size = 0;
                    while(!queue.isEmpty()){
                        size++;
                        int[] iceberg = queue.pollFirst();
                        int r = iceberg[0];
                        int c = iceberg[1];
                        for(int d=0; d<4; d++){
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if(isOut(nr, nc, N, M) || visit[nr][nc] || arr[now][nr][nc] == 0){ continue; }
                            queue.offerLast(new int[] {nr, nc});
                            visit[nr][nc] = true;
                        }
                    }
                    if(size != left){
                        System.out.println(year);
                        return;
                    }
                    break;
                }
                if(isFound){ break; }
            }
        }
    }
}
