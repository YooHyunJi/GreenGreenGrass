package a2402;

import java.io.*;
import java.util.*;

public class d17_bj_s5_1427_소트인사이드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] arr = br.readLine().toCharArray();
        int L = arr.length;
        PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int i=0; i<L; i++){ pq.offer(arr[i]); }
        for(int i=0; i<L; i++){ sb.append(pq.poll()); }
        System.out.println(sb);
    }
}
