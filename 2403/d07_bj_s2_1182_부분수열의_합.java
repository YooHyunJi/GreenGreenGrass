package a2403;

import java.io.*;
import java.util.*;

public class d07_bj_s2_1182_부분수열의_합 {
    static int answer = 0;
    static int[] nums;

    static void subset(int N, int S, int step, int cnt, int sum){
        if(step == N){
            if(cnt == 0 || sum != S){ return; }
            answer++;
            return;
        }
        subset(N, S, step+1, cnt, sum);
        subset(N, S, step+1, cnt+1, sum+nums[step]);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){ nums[n] = Integer.parseInt(st.nextToken()); }
        subset(N, S, 0, 0, 0);
        System.out.println(answer);
    }
}
