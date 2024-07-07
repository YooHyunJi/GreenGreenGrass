package a2407;

import java.io.*;
import java.util.*;

public class d07_bj_s1_11286_절댓값_힙 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (o1, o2)->{
                    if(Math.abs(o1) == Math.abs(o2)){ return Integer.compare(o1, o2); }
                    return Math.abs(o1) - Math.abs(o2);
                }
        );
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){
            int X = Integer.parseInt(br.readLine());
            if(X==0){
                sb.append(pq.isEmpty()? 0: pq.poll()).append("\n");
            }else{
                pq.offer(X);
            }
        }
        System.out.println(sb);
    }
}
