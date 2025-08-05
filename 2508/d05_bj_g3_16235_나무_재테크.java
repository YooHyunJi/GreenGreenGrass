package a2508;

import java.io.*;
import java.util.*;

public class d05_bj_g3_16235_나무_재테크 {

    static class Tree implements Comparable<Tree>{
        int r;
        int c;
        int age;

        public Tree(int r, int c, int age){
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o){
            return age - o.age;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0}, dc = {-1, 0, 1, 1, 1, 0, -1, -1};
        PriorityQueue<Tree> pq = new PriorityQueue<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][N];
        int [][] farm = new int[N][N];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                A[r][c] = Integer.parseInt(st.nextToken());
                farm[r][c] = 5;
            }
        }
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            pq.offer(new Tree(r, c, age));
        }
        for(int k=0; k<K; k++){
            // spring
            int size = pq.size();
            ArrayDeque<Tree> alive = new ArrayDeque<>();
            ArrayDeque<Tree> dead = new ArrayDeque<>();
            for(int i=0; i<size; i++){
                Tree now = pq.poll();
                int nr = now.r;
                int nc = now.c;
                int nage = now.age;
                if(nage <= farm[nr][nc]){
                    farm[nr][nc] -= nage;
                    alive.offer(new Tree(nr, nc, nage + 1));
                }
                else{
                    dead.offer(new Tree(nr, nc, nage));
                }
            }

            // summer
            for(Tree now: dead){
                int nr = now.r;
                int nc = now.c;
                int nage = now.age;
                farm[nr][nc] += nage / 2;
            }

            // autumn
            for(Tree now: alive){
                int nr = now.r;
                int nc = now.c;
                int nage = now.age;
                pq.offer(new Tree(nr, nc, nage));
                if(nage % 5 != 0){
                    continue;
                }
                for(int d=0; d<8; d++){
                    int nxtr = nr + dr[d];
                    int nxtc = nc + dc[d];
                    if(nxtr < 0 || N <= nxtr || nxtc < 0 || N <= nxtc){
                        continue;
                    }
                    pq.offer(new Tree(nxtr, nxtc, 1));
                }
            }

            // winter
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    farm[r][c] += A[r][c];
                }
            }
        }
        System.out.println(pq.size());
    }
}
