package a2401;

import java.io.*;
import java.util.*;

public class d30_bj_s5_11650_좌표정렬하기 {
    static class dot implements Comparable{
        int x;
        int y;

        public dot(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            dot other = (dot)o;
            if(x < other.x){ return -1; }
            else if(x > other.x){ return 1; }
            else{
                if(y < other.y){ return -1; }
                else if(y > other.y){ return 1; }
            }
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<dot> pq = new PriorityQueue<>();
        for(int n=0; n<N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for(int n=0; n<N; n++){
            dot now = pq.poll();
            sb.append(now.x).append(" ").append(now.y).append("\n");
        }
        System.out.println(sb);
    }
}