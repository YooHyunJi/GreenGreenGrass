package a2312;

import java.io.*;
import java.util.*;

public class d23_bj_s5_14889_스타트와링크 {
    static int N, R, answer=Integer.MAX_VALUE;
    static int[] teamStart, teamLink;
    static int[][] power;
    static boolean[] v;

    static void comb(int cnt, int start){
        if(cnt==R){
            int idx = 0;
            for(int n=0; n<N; n++) { if(!v[n]) { teamLink[idx++] = n; } }
            answer = Math.min(answer, Math.abs(getPower(teamStart)-getPower(teamLink)));
            return;
        }
        for(int i=start; i<N; i++){
            if(cnt==0 && i!=0) { break; }
            teamStart[cnt] = i;
            v[i] = true;
            comb(cnt+1, i+1);
            v[i] = false;
        }
    }

    static int getPower(int[] team){
        int total = 0;
        for(int i=0; i<R-1; i++) { for(int j=i+1; j<R; j++) { total += power[team[i]][team[j]]+power[team[j]][team[i]]; } }
        return total;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = N/2;
        power = new int[N][N];
        teamStart = new int[N/2];
        teamLink = new int[N/2];
        v = new boolean[N];
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int nn=0; nn< N; nn++) { power[n][nn] = Integer.parseInt(st.nextToken()); }
        }
        comb(0, 0);
        System.out.println(answer);
    }
}