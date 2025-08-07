package a2508;

import java.io.*;
import java.util.*;

public class d07_bj_s2_11501_주식 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            long profit = 0;
            boolean[] visit = new boolean[N];
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{return o2[1] - o1[1];});
            for(int n=0; n<N; n++){
                arr[n] = Integer.parseInt(st.nextToken());
                pq.offer(new int[] {n, arr[n]});
            }
            while(!pq.isEmpty()){
                int[] now = pq.poll();
                int idx = now[0];
                int num = now[1];
                for(int i=idx; i>=0; i--){
                    if(num < arr[i] || visit[i]){
                        break;
                    }
                    visit[i] = true;
                    profit += num - arr[i];
                }
            }
            sb.append(profit).append("\n");
        }
        System.out.println(sb);
    }
}
