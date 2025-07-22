package a2507;

import java.io.*;
import java.util.*;

public class d22_bj_s3_910_빈도_정렬 {

    static class Node implements Comparable<Node>{
        int num;
        int idx;
        int cnt;

        public Node(int num, int idx, int cnt){
            this.num = num;
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o){
            if(cnt == o.cnt){
                return idx - o.idx;
            }
            return o.cnt - cnt;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Node> map = new HashMap<>();
        for(int n=0; n<N; n++){
            int key = Integer.parseInt(st.nextToken());
            if(!map.containsKey(key)){
                map.put(key, new Node(key, n, 0));
            }
            map.get(key).cnt++;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int key: map.keySet()){
            pq.offer(map.get(key));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Node now = pq.poll();
            for(int i=0; i<now.cnt; i++){
                sb.append(now.num).append(" ");
            }
        }
        System.out.println(sb);
    }
}
