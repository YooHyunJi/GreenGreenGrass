package a2403;

import java.io.*;
import java.util.*;

public class d27_bj_s3_2346_풍선_터뜨리기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] balloons = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){ balloons[n] = Integer.parseInt(st.nextToken()); }
        popBalloon(sb, balloons, 0, 0, 0, N);
        System.out.println(sb);
    }

    static void popBalloon (StringBuilder sb, int[] balloons, int round, int step, int idxInit, int N){
        if(round == N){ return; }
        int cnt = 0;
        int idx = idxInit;
        int d = step >= 0? 1: -1;
        while(cnt < Math.abs(step)){
            idx = (N + idx + d) % N;
            if(balloons[idx] != 0){ cnt++; }
        }
        int stepNxt = balloons[idx];
        balloons[idx] = 0;
        sb.append(idx+1).append(" ");
        popBalloon(sb, balloons, round+1, stepNxt, idx, N);
    }
}
