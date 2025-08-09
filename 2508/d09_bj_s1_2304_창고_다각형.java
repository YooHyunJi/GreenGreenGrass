package a2508;

import java.io.*;
import java.util.*;

public class d09_bj_s1_2304_창고_다각형 {

    static class Stick implements Comparable<Stick>{
        int L;
        int H;

        public Stick(int L,int H){
            this.L = L;
            this.H = H;
        }

        @Override
        public int compareTo(Stick o){
            return this.L - o.L;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        Stick[] sticks = new Stick[N];
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            sticks[n] = new Stick(L, H);
        }

        Arrays.sort(sticks);

        int maxIdx = 0;
        for(int n=0; n<N; n++){
            if(sticks[maxIdx].H < sticks[n].H){
                maxIdx = n;
            }
        }

        int nowL = 0;
        for(int i=0; i<=maxIdx; i++){
            if(sticks[nowL].H <= sticks[i].H){
                answer += (sticks[i].L - sticks[nowL].L) * sticks[nowL].H;
                nowL = i;
            }
        }
        nowL = N - 1;
        for(int i=N-1; i>=maxIdx; i--){
            if(sticks[nowL].H <= sticks[i].H){
                answer += (sticks[nowL].L - sticks[i].L) * sticks[nowL].H;
                nowL = i;
            }
        }
        answer += sticks[maxIdx].H;

        System.out.println(answer);
    }
}
