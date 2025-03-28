package a2503;

import java.io.*;
import java.util.*;

public class d28_bj_s4_31797_아_파트_아파트 {

    static class Hand implements Comparable<Hand>{
        int person;
        int height;

        public Hand(int person, int height){
            this.person = person;
            this.height = height;
        }

        @Override
        public int compareTo(Hand o){
            return height - o.height;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Hand> pq = new PriorityQueue<>();
        for(int m=1; m<=M; m++){
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            pq.offer(new Hand(m, h1));
            pq.offer(new Hand(m, h2));
        }
        N = N % (2 * M) == 0? N: N % (2 * M);
        N = M == 1? 1: N;
        for(int n=0; n<N-1; n++){
            pq.poll();
        }
        System.out.println(pq.poll().person);
    }
}
