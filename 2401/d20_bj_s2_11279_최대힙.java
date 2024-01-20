package a2401;

import java.io.*;
import java.util.*;

public class d20_bj_s2_11279_최대힙 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++) {
            int num = Integer.parseInt(br.readLine());
            if(num==0) {
                if(pq.isEmpty()) { sb.append("0\n"); }
                else { sb.append(pq.poll()).append("\n"); }
            }
            else {
                pq.offer(num);
            }
        }
        System.out.println(sb);
    }
}
