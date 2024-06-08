package a2406;

import java.io.*;
import java.util.*;

public class d08_bj_g3_18234_당근_훔쳐_먹기 {
    static class Carrot implements Comparable<Carrot>{
        int flavor;
        int potion;

        public Carrot(int flavor, int potion){
            this.flavor = flavor;
            this.potion = potion;
        }

        @Override
        public int compareTo(Carrot o){
            return Integer.compare(potion, o.potion);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        PriorityQueue<Carrot> carrots = new PriorityQueue<>();
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            carrots.offer(new Carrot(w, p));
        }
        long answer = 0;
        int n = 0;
        while(!carrots.isEmpty()){
            Carrot c = carrots.poll();
            int f = c.flavor;
            int p = c.potion;
            answer += f + (long) (T - N + n++) * p;
        }
        System.out.println(answer);
    }
}