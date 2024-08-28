package a2408;

import java.io.*;
import java.util.*;

public class d29_bj_g3_2638_치즈 {

    private static int N, M;
    private static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    private static int[][] paper;
    private static List<int[]> cheese;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        cheese = new ArrayList<>();
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                paper[n][m] = Integer.parseInt(st.nextToken());
                if(paper[n][m] == 1){
                    cheese.add(new int[] {n, m});
                }
            }
        }

        int answer = 0;
        for(; !cheese.isEmpty(); answer++){
            checkOuter();
            meltCheese();
        }
        System.out.println(answer);
    }

    private static boolean isOut(int r, int c){
        return r<0 || N<=r || c<0 || M<=c;
    }

    private static void checkOuter(){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];
        queue.offerLast(new int[] {0, 0});
        visit[0][0] = true;
        paper[0][0] = 8;

        while (!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int r = now[0];
            int c = now[1];
            for(int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (isOut(nr, nc) || visit[nr][nc] || paper[nr][nc] == 1) {
                    continue;
                }
                queue.offerLast(new int[] {nr, nc});
                visit[nr][nc] = true;
                paper[nr][nc] = 8;
            }
        }
    }

    private static void meltCheese(){
        List<int[]> melted = new ArrayList<>();
        int size = cheese.size() - 1;
        for(int i=size; 0<=i; i--){
            int cnt = 0;
            int r = cheese.get(i)[0];
            int c = cheese.get(i)[1];
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(paper[nr][nc] == 8){
                    cnt++;
                }
            }
            if(2 <= cnt){
                melted.add(new int[] {r, c});
                cheese.remove(i);
            }
        }
        for(int[] m: melted){
            int r = m[0];
            int c = m[1];
            paper[r][c] = 8;
        }
    }
}