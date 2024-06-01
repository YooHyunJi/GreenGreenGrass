package a2406;

import java.io.*;
import java.util.*;

public class d01_bj_s5_11931_수_정렬하기_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->o2-o1);
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){ pq.offer(Integer.parseInt(br.readLine())); }
        while(!pq.isEmpty()){ sb.append(pq.poll()).append("\n"); }
        System.out.println(sb);
    }
}