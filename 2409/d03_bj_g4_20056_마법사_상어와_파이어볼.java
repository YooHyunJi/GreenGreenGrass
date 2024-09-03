package a2409;

import java.io.*;
import java.util.*;

public class d03_bj_g4_20056_마법사_상어와_파이어볼 {

    static class Block{
        int count;
        int mass;
        int speed;
        int direction;
        boolean isOdd;
        boolean isEven;

        public Block() {
            this.count = 0;
            this.mass = 0;
            this.speed = 0;
            this.direction = 0;
            this.isOdd = true;
            this.isEven = true;
        }
    }

    static class FireBall{
        int r;
        int c;
        int mass;
        int speed;
        int d;

        public FireBall(int r, int c, int mass, int speed, int d) {
            this.r = r;
            this.c = c;
            this.mass = mass;
            this.speed = speed;
            this.d = d;
        }
    }

    static int N, M, K;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}, dc = {0, 1, 1, 1, 0, -1, -1, -1}, sd = {0, 2, 4, 6}, dd = {1, 3, 5, 7};
    static Block[][] map;
    static List<FireBall> fireBalls = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new Block[N][N];
        clear();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[r][c].mass += m;
            map[r][c].speed += s;
            map[r][c].count++;
            map[r][c].direction = d;
            fireBalls.add(new FireBall(r, c, m, s, d));
        }
        for(int k=0; k<K; k++){
            play();
        }
        int answer = 0;
        for(FireBall fireBall: fireBalls){
            answer += fireBall.mass;
        }
        System.out.println(answer);
    }

    private static void play() {
        clear();
        move();
        divide();
    }

    private static void clear() {
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                map[r][c] = new Block();
            }
        }
    }

    private static void move() {
        for(FireBall fireBall: fireBalls){
            int r = fireBall.r;
            int c = fireBall.c;
            int mass = fireBall.mass;
            int speed = fireBall.speed;
            int d = fireBall.d;

            int nr = (N + r + (dr[d] * speed) % N) % N;
            int nc = (N + c + (dc[d] * speed) % N) % N;

            map[nr][nc].count++;
            map[nr][nc].mass += mass;
            map[nr][nc].speed += speed;
            map[nr][nc].direction = d;
            if(d % 2 == 0){
                map[nr][nc].isOdd = false;
            }
            else{
                map[nr][nc].isEven = false;
            }
        }
    }

    private static void remove(int r, int c){
        int S = fireBalls.size();
        for(int s=S-1; 0<=s; s--){
            if(fireBalls.get(s).r == r && fireBalls.get(s).c == c){
                fireBalls.remove(s);
            }
        }
    }

    private static void divide() {
        fireBalls.clear();
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(map[r][c].count < 2){
                    if(map[r][c].count == 1){
                        fireBalls.add(new FireBall(r, c, map[r][c].mass, map[r][c].speed, map[r][c].direction));
                    }
                    continue;
                }
                remove(r, c);
                int nm = map[r][c].mass / 5;
                int ns = map[r][c].speed / map[r][c].count;
                if(nm == 0){
                    continue;
                }
                if(map[r][c].isEven || map[r][c].isOdd){
                    for(int d=0; d<4; d++){
                        fireBalls.add(new FireBall(r, c, nm, ns, sd[d]));
                    }
                }
                else{
                    for(int d=0; d<4; d++){
                        fireBalls.add(new FireBall(r, c, nm, ns, dd[d]));
                    }
                }
            }
        }
    }
}
