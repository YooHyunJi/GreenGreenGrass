package a2407;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class d26_bj_g3_2234_성곽 {
    static int N, M, MAX = 0, CNT = 0, WALL_MAX = 0;
    static int[] dr = {0, -1, 0, 1}, dc = {-1, 0, 1, 0}, db = {1, 2, 4, 8};
    static int[][] castle;
    static boolean[][] visit;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        castle = new int[N][M];
        visit = new boolean[N][M];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++){
                castle[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(!visit[r][c]){ BFS(r, c); }
            }
        }
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                NoWall(r, c);
            }
        }
        System.out.println(CNT);
        System.out.println(MAX);
        System.out.println(WALL_MAX);
    }

    static boolean isOut(int R, int C){
        return R<0 || N<=R || C<0 || M<=C;
    }

    static int BFS(int R, int C){
        int cnt = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visit[R][C] = true;
        queue.offerLast(new int[] {R, C});
        while(!queue.isEmpty()){
            cnt++;
            int[] now = queue.pollFirst();
            int r = now[0];
            int c = now[1];
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isOut(nr, nc) || visit[nr][nc]){ continue; }
                int bear = castle[r][c] & db[d];
                if(bear == 0){
                    visit[nr][nc] = true;
                    queue.offerLast(new int[] {nr, nc});
                }
            }
            castle[r][c] = CNT;
        }
        MAX = Math.max(MAX, cnt);
        map.put(CNT++, cnt);
        return cnt;
    }

    static void NoWall(int R, int C){
        int num1 = castle[R][C];
        int room = map.get(num1);
        for(int d=0; d<4; d++){
            int nr = R + dr[d];
            int nc = C + dc[d];
            if(isOut(nr, nc) || num1 == castle[nr][nc]){ continue; }
            int num2 = castle[nr][nc];
            WALL_MAX = Math.max(WALL_MAX, room + map.get(num2));
        }
    }
}
