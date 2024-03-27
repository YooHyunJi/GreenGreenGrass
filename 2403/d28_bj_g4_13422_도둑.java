package a2403;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d28_bj_g4_13422_도둑 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] houses = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<N; n++){ houses[n] = Integer.parseInt(st.nextToken()); }
            sb.append(stealMax(houses, N, M, K)).append("\n");
        }
        System.out.println(sb);
    }
    static int stealMax(int[] houses, int N, int M, int K){
        int sum = 0;
        int cnt = 0;
        for(int i=0; i<M; i++){ sum += houses[i]; }
        if (sum < K) { cnt++; }
        if(N == M){ return cnt; }


        for(int i=1; i<N; i++) {
            sum -= houses[i - 1];
            sum += houses[(i + M - 1) % N];
            if (sum >= K) { continue; }
            cnt++;
        }
        return cnt;
    }
}
