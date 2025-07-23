package a2507;

import java.io.*;
import java.util.*;

public class d23_bj_g4_12886_돌_그룹 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int sum = A + B + C;
        if(sum % 3 != 0){
            System.out.println(0);
            return;
        }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[1501][1501];
        visit[A][B] = true;
        visit[A][C] = true;
        visit[B][A] = true;
        visit[B][C] = true;
        visit[C][A] = true;
        visit[C][B] = true;
        queue.offerLast(new int[] {A, B, C});
        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int a = now[0];
            int b = now[1];
            int c = now[2];
            if(a == b && b == c){
                System.out.println(1);
                return;
            }
            if(a != b) {
                int na = a < b ? 2 * a : a - b;
                int nb = a < b ? b - a : 2 * b;
                if (!visit[na][nb]) {
                    queue.offerLast(new int[]{na, nb, c});
                    visit[na][nb] = true;
                    visit[nb][na] = true;
                }
            }
            if(b != c){
                int nb = b < c? 2 * b: b - c;
                int nc = b < c? c - b: 2 * c;
                if(!visit[nb][nc]){
                    queue.offerLast(new int[] {a, nb, nc});
                    visit[nb][nc] = true;
                    visit[nc][nb] = true;
                }
            }
            if(c != a){
                int na = a < c? 2 * a: a - c;
                int nc = a < c? c - a: 2 * c;
                if(!visit[na][nc]){
                    queue.offerLast(new int[] {na, b, nc});
                    visit[na][nc] = true;
                    visit[nc][na] = true;
                }
            }
        }
        System.out.println(0);
    }
}
