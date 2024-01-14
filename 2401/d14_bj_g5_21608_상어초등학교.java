package a2401;

import java.io.*;
import java.util.*;

public class d14_bj_g5_21608_상어초등학교 {
    static class Info implements Comparable<Info>{
        int likes;
        int blank;
        int r;
        int c;

        public Info(int likes, int blank, int r, int c) {
            this.likes = likes;
            this.blank = blank;
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Info o) {
            if(this.likes > o.likes) { return -1; }
            else if(this.likes < o.likes) { return 1; }
            else {
                if(this.blank > o.blank) { return -1; }
                else if(this.blank < o.blank) { return 1;}
                else {
                    if(this.r < o.r) { return -1; }
                    else if(this.r > o.r) { return 1; }
                    else {
                        if(this.c < o.c) { return -1; }
                        else if(this.c > o.c) { return 1; }
                    }
                }
            }
            return 0;
        }
    }

    static int N, answer = 0;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static int[][] room;
    static Map<Integer, int[]> map = new LinkedHashMap<>();
    static PriorityQueue<Info> pq = new PriorityQueue<>();

    static void calculate(int S) {
        pq.clear();
        int[] like_list = map.get(S);
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                if(room[r][c]>0) { continue; }
                int likes = 0;
                int blank = 0;
                for(int d=0; d<4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr<0 || nr>=N || nc<0 || nc>=N) { continue; }
                    int now = room[nr][nc];
                    if(now==0) {
                        blank++;
                        continue;
                    }
                    for(int l=0; l<4; l++) {
                        if(now==like_list[l]) {
                            likes++;
                            break;
                        }
                    }
                }
                pq.offer(new Info(likes, blank, r, c));
            }
        }
        while(!pq.isEmpty()) {
            Info result = pq.poll();
            if(room[result.r][result.c]!=0) { continue; }
            room[result.r][result.c] = S;
            break;
        }
    }

    static void getScore() {
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                int[] like_list = map.get(room[r][c]);
                int likes = 0;
                for(int d=0; d<4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr<0 || nr>=N || nc<0 || nc>=N) { continue; }
                    int now = room[nr][nc];
                    for(int l=0; l<4; l++) {
                        if(now==like_list[l]) {
                            likes++;
                            break;
                        }
                    }
                }
                answer += convert(likes);
            }
        }
    }

    static int convert(int likes) {
        switch (likes) {
            case 0: return 0;
            case 1: return 1;
            case 2: return 10;
            case 3: return 100;
            case 4: return 1000;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        room = new int[N][N];
        for(int n=0; n<N*N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()),
            new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        for(int n: map.keySet()) { calculate(n); }
        getScore();
        System.out.println(answer);
    }
}