package a2507;

import java.io.*;
import java.util.*;

public class d17_bj_g4_71740_이차원_배열과_연산 {
    static int R, C, K, ar = 3, ac = 3;
    static int[][] A;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;
        K = Integer.parseInt(st.nextToken());
        A = new int[100][100];
        for(int r=0; r<3; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<3; c++){
                A[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        if(A[R][C] == K){
            System.out.println(0);
            return;
        }
        for(int i=1; i<=100; i++){
            if(ac <= ar){
                int maxC = 0;
                for(int r=0; r<ar; r++){
                    HashMap<Integer, Integer> map = new HashMap<>();
                    for(int c=0; c<ac; c++){
                        int num = A[r][c];
                        if(num == 0){ continue; }
                        map.put(num, map.getOrDefault(num, 0) + 1);
                    }
                    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{if(o1[1] == o2[1]){return o1[0] - o2[0];} return o1[1] - o2[1];});
                    for(int key: map.keySet()){
                        pq.offer(new int[] {key, map.get(key)});
                    }
                    int c=0;
                    while(!pq.isEmpty()){
                        int[] now = pq.poll();
                        A[r][c++] = now[0];
                        A[r][c++] = now[1];
                        if(c == 100){ break; }
                    }
                    maxC = Math.max(maxC, c);
                    for(; c<100; c++){
                        A[r][c] = 0;
                    }
                }
                ac = maxC;
            }
            else{
                int maxR = 0;
                for(int c=0; c<ac; c++){
                    HashMap<Integer, Integer> map = new HashMap<>();
                    for(int r=0; r<ar; r++){
                        int num = A[r][c];
                        if(num == 0){ continue; }
                        map.put(num, map.getOrDefault(num, 0) + 1);
                    }
                    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{if(o1[1] == o2[1]){return o1[0] - o2[0];} return o1[1] - o2[1];});
                    for(int key: map.keySet()){
                        pq.offer(new int[] {key, map.get(key)});
                    }
                    int r=0;
                    while(!pq.isEmpty()){
                        int[] now = pq.poll();
                        A[r++][c] = now[0];
                        A[r++][c] = now[1];
                        if(r == 100){ break; }
                    }
                    maxR = Math.max(maxR, r);
                    for(; r<100; r++){
                        A[r][c] = 0;
                    }
                }
                ar = maxR;
            }
            if(A[R][C] == K){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
