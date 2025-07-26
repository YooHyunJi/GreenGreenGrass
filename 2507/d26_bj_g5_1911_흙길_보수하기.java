package a2507;

import java.io.*;
import java.util.*;

public class d26_bj_g5_1911_흙길_보수하기 {

    static class Pool implements Comparable<Pool>{
        int start;
        int end;

        public Pool(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pool o){
            return start - o.start;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int answer = 0;
        PriorityQueue<Pool> pq = new PriorityQueue<>();
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Pool(start, end));
        }
        int start = 0;
        while(!pq.isEmpty()){
            Pool now = pq.poll();
            int n_start = now.start;
            int n_end = now.end;
            if(start < n_start){
                start = n_start;
            }
            int length = n_end - start;
            int quantity = (int)Math.ceil((double) length / L);
            answer += quantity;
            start += quantity * L;
        }
        System.out.println(answer);
    }
}
