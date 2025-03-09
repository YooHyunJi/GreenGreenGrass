package a2503;

import java.io.*;
import java.util.*;

public class d09_bj_s1_1446_지름길 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] graph = new ArrayList[D+1];
        for(int d=0; d<=D; d++){
            graph[d] = new ArrayList<>();
            graph[d].add(new int[] {d+1, 1});
        }
        int[] len = new int[D+1];
        int MAX_VALUE = Integer.MAX_VALUE;
        Arrays.fill(len, MAX_VALUE);

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            if(D < end){
                continue;
            }
            graph[start].add(new int[] {end, time});
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        len[0] = 0;
        queue.offerLast(new int[] {0, 0});
        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int start = now[0];
            int time_start = now[1];

            for(int[] value: graph[start]){
                int end = value[0];
                if(D < end){
                    continue;
                }
                int time_end = value[1];
                int time_total = time_start + time_end;
                if(time_total < len[end]){
                    len[end] = time_total;
                    queue.offerLast(new int[] {end, time_total});
                }
            }
        }
        System.out.println(len[D]);
    }
}
