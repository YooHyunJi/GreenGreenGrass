package a2411;

import java.io.*;
import java.util.*;

public class d19_bj_s1_1303_전쟁_전투 {

    static int N, M;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M];

        for(int n=0; n<N; n++){
            map[n] = br.readLine().toCharArray();
        }

        HashMap<Character, Integer> sizeMap = new HashMap<>();
        sizeMap.put('W', 0);
        sizeMap.put('B', 0);

        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                if(visit[n][m]){ continue; }
                char color = map[n][m];
                int size = (int)Math.pow(BFS(n, m, color), 2);
                int beforeSize = sizeMap.get(color);
                sizeMap.put(color, beforeSize + size);
            }
        }

        System.out.println(sizeMap.get('W')+" "+sizeMap.get('B'));
    }

    private static boolean isOut(int r, int c){
        return r < 0 || N <= r || c < 0 || M <= c;
    }


    private static int BFS(int n, int m, char color) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[] {n, m});
        visit[n][m] = true;
        int size = 1;

        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int r = now[0];
            int c = now[1];
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isOut(nr, nc) || visit[nr][nc] || map[nr][nc] != color){ continue; }
                queue.offerLast(new int[] {nr, nc});
                visit[nr][nc] = true;
                size++;
            }
        }
        return size;
    }
}
