package a2412;

import java.io.*;
import java.util.*;

public class d15_bj_s1_1325_효율적인_해킹 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[N+1];

        for(int n=1; n<=N; n++){
            graph[n] = new ArrayList<Integer>();
        }

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[B].add(A);
        }

        int max_val = 0;
        ArrayList<Integer> max_list = new ArrayList<>();

        for(int n=1; n<=N; n++){
            boolean[] visit = new boolean[N+1];
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.offerLast(n);
            visit[n] = true;
            int cnt = 1;

            while(!queue.isEmpty()){
                int now = queue.pollFirst();
                for(int nxt: graph[now]){
                    if(visit[nxt]){ continue; }
                    visit[nxt] = true;
                    queue.offerLast(nxt);
                    cnt++;
                }
            }
            if(max_val < cnt){
                max_val = cnt;
                max_list.clear();
                max_list.add(n);
            }
            else if(max_val == cnt){
                max_list.add(n);
            }
        }
        max_list.sort(((o1, o2) -> o1-o2));
        StringBuilder sb = new StringBuilder();
        for(int computer: max_list){
            sb.append(computer).append(" ");
        }
        System.out.println(sb);
    }
}
