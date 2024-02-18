package a2402;

import java.io.*;
import java.util.*;

public class d18_bj_s5_15235_OlympiadPizza{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] answer = new int[N];
        ArrayDeque<Integer> queue = new ArrayDeque();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            queue.offer(n);
            arr[n] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        while(!queue.isEmpty()){
            int now = queue.poll();
            arr[now]--;
            cnt++;
            if(arr[now]==0){
                answer[now] = cnt;
                continue;
            }
            queue.offer(now);
        }
        for(int n=0; n<N; n++){ System.out.print(answer[n]+" "); }
    }
}
