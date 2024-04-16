package a2404;

import java.io.*;
import java.util.*;

public class d16_bj_s4_11256_사탕 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> boxes = new PriorityQueue<>((o1, o2) -> {return o2 - o1;});
            for(int n=0; n<N; n++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                boxes.offer(a*b);
            }
            int cnt = 0;
            while(J>0){
                J -= boxes.poll();
                cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
