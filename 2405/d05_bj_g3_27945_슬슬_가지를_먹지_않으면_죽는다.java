package a2405;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class d05_bj_g3_27945_슬슬_가지를_먹지_않으면_죽는다 {
    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o1[2]-o2[2]);;
        parent = new int[N+1];
        for(int n=1; n<=N; n++){ parent[n] = n; }
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{x, y, z});
        }
        int cnt = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int x = now[0];
            int y = now[1];
            int z = now[2];
            if(union(x, y)){
                if(z != ++cnt){
                    System.out.println(cnt);
                    return;
                }
            }
        }
        System.out.println(cnt+1);
    }

    static int find(int x){
        if(parent[x] == x){ return x; }
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y){
        int px = find(x), py = find(y);
        if(px == py){ return false; }
        parent[px] = py;
        return true;
    }
}
