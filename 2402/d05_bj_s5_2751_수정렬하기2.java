package a2402;

import java.io.*;
import java.util.*;

public class d05_bj_s5_2751_수정렬하기2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){ pq.offer(Integer.parseInt(br.readLine())); }
        for(int n=0; n<N; n++){ sb.append(pq.poll()).append("\n"); }
        System.out.println(sb);
    }
}