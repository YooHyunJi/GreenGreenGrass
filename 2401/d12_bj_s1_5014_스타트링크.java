package a2401;

import java.io.*;
import java.util.*;

public class d12_bj_s1_5014_스타트링크 {
    static int F, S, G;
    static int[] diff = new int[2];

    static void BFS(){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[] v = new boolean[F+1];

        queue.offerLast(new int[]{S, 0});
        v[S] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.pollFirst();
            if(now[0]==G) {
                System.out.println(now[1]);
                return;
            }
            for(int d=0; d<2; d++) {
                int next = now[0]+diff[d];
                if(next<1 || next>F || v[next]) { continue; }
                queue.offerLast(new int[]{next, now[1]+1});
                v[next] = true;
            }
        }
        System.out.println("use the stairs");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        diff[0] = Integer.parseInt(st.nextToken());
        diff[1] = -Integer.parseInt(st.nextToken());
        BFS();
    }
}