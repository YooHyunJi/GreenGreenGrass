package a2402;

import java.io.*;
import java.util.*;

public class d06_bj_s4_18110_solvedac {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cut = (int) Math.round((N*15.0)/100);
        int real = N-2*cut;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n=0; n<N; n++) { pq.offer(Integer.parseInt(br.readLine())); }
        for(int c=0; c<cut; c++) { pq.poll(); }
        for(int n=0; n<real; n++) { sum += pq.poll(); }
        System.out.println(Math.round((sum*1.0)/real));
    }
}
