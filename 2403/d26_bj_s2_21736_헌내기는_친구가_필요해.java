package a2403;

import java.io.*;
import java.util.*;

public class d26_bj_s2_21736_헌내기는_친구가_필요해 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] school = new char[N][M];
        int[] doyeon = new int[2];
        for(int n=0; n<N; n++){
            school[n] = br.readLine().toCharArray();
            for(int m=0; m<M; m++){ if(school[n][m] == 'I'){ doyeon = new int[] {n, m}; } }
        }
        int result = BFS(N, M, doyeon, school);
        System.out.println(result==0? "TT": result);
    }

    static int BFS(int N, int M, int[] doyeon, char[][] school){
        boolean[][] v = new boolean[N][M];
        int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
        int answer = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        v[doyeon[0]][doyeon[1]] = true;
        queue.offerLast(doyeon);
        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int r = now[0];
            int c = now[1];
            if(school[r][c]=='P'){ answer++; }
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr<0 || N<=nr || nc<0 || M<=nc || school[nr][nc]=='X' || v[nr][nc]){ continue; }
                v[nr][nc] = true;
                queue.offerLast(new int[] {nr, nc});
            }
        }
        return answer;
    }
}
