package a2405;

import java.io.*;
import java.util.*;

public class d20_bj_g5_7983_내일_할거야 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o2[1]-o1[1]);
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            pq.offer(new int[] {D, T});
        }
        int idx = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int start = now[0];
            int end = now[1];
            if(end <= idx){
                idx = end-start;
            }
            else{
                idx = end - start - (end - idx);
            }
        }
        System.out.println(idx);
    }
}
