package a2507;

import java.io.*;
import java.util.*;

public class d27_bj_g4_14226_이모티콘 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        boolean[][] visit = new boolean[1001][1001];
        PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2) -> {return o1[2] - o2[2];});
        pq.offer(new int[] {1, 0, 0});
        visit[1][0] = true;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int total = now[0];
            int board = now[1];
            int cnt = now[2];
            if(total == S){
                System.out.println(cnt);
                return;
            }
            pq.offer(new int[] {total, total, cnt + 1});
            int sum = total + board;
            if(0 < board && sum <= 1000 && !visit[sum][board]){
                pq.offer(new int[] {sum, board, cnt + 1});
                visit[sum][board] = true;
            }
            int minus = total - 1;
            if(1 < minus && !visit[minus][board]){
                pq.offer(new int[] {minus, board, cnt + 1});
                visit[minus][board] = true;
            }
        }
    }
}
