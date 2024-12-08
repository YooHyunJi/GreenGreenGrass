package a2412;

import java.io.*;
import java.util.*;

public class d09_bj_s3_10451_순열_사이클 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            boolean[] visit = new boolean[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int n=1; n<=N; n++){
                arr[n] = Integer.parseInt(st.nextToken());
            }
            int answer = 0;
            for(int n=1; n<=N; n++){
                if(visit[n]){ continue; }
                answer++;
                ArrayDeque<Integer> queue = new ArrayDeque<>();
                queue.offerLast(n);
                visit[n] = true;
                while(!queue.isEmpty()){
                    int now = queue.pollFirst();
                    int nxt = arr[now];
                    if(visit[nxt]){ continue; }
                    queue.offerLast(nxt);
                    visit[nxt] = true;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
