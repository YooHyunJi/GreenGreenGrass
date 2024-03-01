package a2403;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class d01_bj_g2_1766_문제집 {
    static class Node{
        int num;
        int indegree;
        ArrayList<Integer> next;

        public Node(int num){
            this.num = num;
            this.indegree = 0;
            this.next = new ArrayList<>();
        }

        @Override
        public String toString(){
            return "num: "+num+", indegree: "+indegree+", next: "+next.toString();
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node[] problems = new Node[N+1];
        for(int i=0; i<=N; i++){ problems[i] = new Node(i); }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            problems[B].indegree++;
            problems[A].next.add(B);
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.num - o2.num);
        for(Node problem: problems){
            if(problem.indegree==0){ pq.offer(problem); }
        }
        pq.poll();
        while(!pq.isEmpty()){
            Node now = pq.poll();
            sb.append(now.num).append(" ");
            for(int node: now.next){
                if(problems[node].indegree == 0){ continue; }
                if(--problems[node].indegree == 0){ pq.offer(problems[node]); }
            }
        }
        System.out.println(sb);
    }
}
