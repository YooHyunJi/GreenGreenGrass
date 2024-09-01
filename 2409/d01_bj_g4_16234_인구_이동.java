package a2409;

import java.io.*;
import java.util.*;

public class d01_bj_g4_16234_인구_이동 {

    static int N, L, R, answer = 0;
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
    static int[][] land;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        land = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                land[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        print();
        int cnt = 0;
        int totalLand = N * N;

        for(int i=0; ; i++){
            cnt = 0;
            visit = new boolean[N][N];
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(visit[r][c]){
                        continue;
                    }
                    cnt += move(r, c);
                }
            }
            print();
            if(cnt == totalLand){
                System.out.println(answer);
                return;
            }
            answer++;
        }
    }

    private static void print(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                System.out.print(land[r][c]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isOut(int r, int c){
        return r < 0 || N <= r || c < 0 || N <= c;
    }

    private static boolean isOutOfRange(int popularity1, int popularity2){
        int diff = Math.max(popularity1, popularity2) - Math.min(popularity1, popularity2);
        return diff < L || R < diff;
    }

    private static int move(int R, int C) {

        List<int[]> countries = new ArrayList<>();
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int total = land[R][C];
        countries.add(new int[] {R, C});
        queue.offerLast(new int[] {R, C});
        visit[R][C] = true;

        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int r = now[0];
            int c = now[1];
            int p = land[r][c];
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isOut(nr, nc) || visit[nr][nc] || isOutOfRange(p, land[nr][nc])){
                    continue;
                }
                total += land[nr][nc];
                countries.add(new int[] {nr, nc});
                queue.offerLast(new int[] {nr, nc});
                visit[nr][nc] = true;
            }
        }

        int result = total / countries.size();
        for(int[] c: countries){
            land[c[0]][c[1]] = result;
        }
        return 1;
    }

}
