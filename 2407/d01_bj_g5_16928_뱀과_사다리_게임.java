package a2407;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class d01_bj_g5_16928_뱀과_사다리_게임 {
    public static void main(String[] args) throws Exception{
        int[] board = new int[101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            board[u] = v;
        }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[] {1, 0});
        board[0] = board[1] = -1;
        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            if(now[0] == 100){
                System.out.println(now[1]);
                return;
            }
            for(int d=1; d<=6; d++){
                int nd = now[0] + d;
                if(100 < nd){ break; }
                if(0 < board[nd]){ nd = board[nd]; }
                if(board[nd] == -1){ continue; }
                queue.offerLast(new int[] {nd, now[1]+1});
                board[nd] = -1;
            }
        }
    }
}
