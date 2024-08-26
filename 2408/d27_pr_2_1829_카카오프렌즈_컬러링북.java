package a2408;

import java.util.ArrayDeque;

public class d27_pr_2_1829_카카오프렌즈_컬러링북 {
    static int R, C;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static boolean[][] visit;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        R = m;
        C = n;
        visit = new boolean[R][C];

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(picture[r][c]==0 || visit[r][c]){ continue; }
                numberOfArea++;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, BFS(picture, r, c));
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static boolean isOut(int r, int c){
        return r<0 || R<=r || c<0 || C<=c;
    }

    static int BFS(int[][] picture, int rr, int cc){
        int size = 1;
        int n = picture[rr][cc];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[] {rr, cc});
        visit[rr][cc] = true;

        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int r = now[0];
            int c = now[1];
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isOut(nr, nc) || visit[nr][nc] || picture[nr][nc]!=n){ continue; }
                queue.offerLast(new int[] {nr, nc});
                visit[nr][nc] = true;
                size++;
            }
        }
        return size;
    }
}
