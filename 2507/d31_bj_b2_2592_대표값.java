package a2507;

import java.io.*;
import java.util.*;

public class d31_bj_b2_2592_대표값 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<10; i++){
            int num = Integer.parseInt(br.readLine());
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {return o2[1] - o1[1];});
        for(int key: map.keySet()){
            pq.offer(new int[] {key, map.get(key)});
        }
        System.out.println(sum / 10);
        System.out.println(pq.poll()[0]);
    }
}

