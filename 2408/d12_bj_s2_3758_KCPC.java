package a2408;

import java.io.*;
import java.util.*;

public class d12_bj_s2_3758_KCPC {
    static class Team implements Comparable<Team>{
        int id;
        int[] score;
        int total;
        int count;
        int last;

        public Team(int id, int size){
            this.id = id;
            this.score = new int[size];
            this.total = 0;
            this.count = 0;
            this.last = 0;
        }

        @Override
        public int compareTo(Team o){
            if(o.total < total){ return -1; }
            if(o.total > total){ return 1; }
            if(count < o.count){ return -1; }
            if(count > o.count){ return 1; }
            return Integer.compare(last, o.last);
        }
    }

    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int tc=0; tc<TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Team[] teams = new Team[N+1];
            for(int n=0; n<=N; n++){ teams[n] = new Team(n, K+1); }
            for(int m=0; m<M; m++){
                st = new StringTokenizer(br.readLine());
                int I = Integer.parseInt(st.nextToken());
                int J = Integer.parseInt(st.nextToken());
                int S = Integer.parseInt(st.nextToken());
                if(teams[I].score[J] < S){
                    teams[I].total = teams[I].total - teams[I].score[J] + S;
                    teams[I].score[J] = S;
                }
                teams[I].last = m;
                teams[I].count++;
            }
            Arrays.sort(teams);
            for(int n=0; n<=N; n++){
                if(teams[n].id == T){
                    sb.append(n+1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
