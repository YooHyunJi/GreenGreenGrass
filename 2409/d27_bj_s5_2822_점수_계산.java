package a2409;

import java.io.*;
import java.util.*;

public class d27_bj_s5_2822_점수_계산 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        boolean[] visit = new boolean[9];
        for(int i=1; i<=8; i++){
            pq.offer(new int[] {i, Integer.parseInt(br.readLine())});
        }
        for(int i=0; i<3; i++){
            visit[pq.poll()[0]] = true;
        }
        int sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll()[1];
        }
        sb.append(sum).append("\n");
        for(int i=1; i<=8; i++){
            if(visit[i]){
                continue;
            }
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
