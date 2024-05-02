package a2405;

import java.util.*;
import java.io.*;

public class d02_bj_s2_2075_N번째_큰_수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=0;i<N-1;i++) {
            pq.remove();
        }
        System.out.println(pq.poll());
    }
}
