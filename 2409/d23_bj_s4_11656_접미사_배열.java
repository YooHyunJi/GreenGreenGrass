package a2409;

import java.io.*;
import java.util.*;

public class d23_bj_s4_11656_접미사_배열 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<String> pq = new PriorityQueue<>();
        String S = br.readLine();
        while(!S.isEmpty()){
            pq.offer(S);
            S = S.substring(1);
        }
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }
}
