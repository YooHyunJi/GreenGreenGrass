package a2312;

import java.io.*;
import java.util.*;

public class d19_bj_g4_4485_녹색옷입은애가젤다지 {
    static class Node implements Comparable<Node>{
        int r;
        int c;
        int rupee;

        public Node(int r, int c, int rupee) {
            this.r = r;
            this.c = c;
            this.rupee = rupee;
        }

        @Override
        public int compareTo(Node o) {
            return this.rupee-o.rupee;
        }
    }

    static int N;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int step = 0;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N==0) break;
            map = new int[N][N];
            for(int r=0; r<N; r++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int c=0; c<N; c++) map[r][c] = Integer.parseInt(st.nextToken());
            }

            sb.append("Problem ").append(++step).append(": ").append(Dijkstra()).append("\n");
        }
        System.out.println(sb);
    }
    static int Dijkstra(){
        int[][] move = new int[N][N];
        for(int[] n:move) Arrays.fill(n, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, map[0][0]));
        move[0][0] = map[0][0];
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int r = now.r, c = now.c, rupee = now.rupee;
            if(r==N-1 &&c==N-1) return now.rupee;
            for (int d=0; d<4; d++){
                int nr = r+dr[d],
                    nc = c+dc[d];
                if(nr<0 || nr>N-1 ||nc<0 || nc>N-1) continue;
                if(move[nr][nc] > map[nr][nc]+rupee){
                    move[nr][nc] = map[nr][nc]+rupee;
                    pq.add(new Node(nr, nc, move[nr][nc]));
                }
            }
        }
        return 0;
    }
}