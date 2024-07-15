package a2407;

import java.io.*;
import java.util.*;

public class d15_bj_g4_9019_DSLR {
    static class Node{
        int num;
        String ops;

        public Node(int num, String ops){
            this.num = num;
            this.ops = ops;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean[] visit = new boolean[10000];
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            ArrayDeque<Node> queue = new ArrayDeque<>();
            queue.offerLast(new Node(A, ""));
            visit[A] = true;
            while(!queue.isEmpty()){
                Node now = queue.pollFirst();
                if(now.num == B){
                    sb.append(now.ops).append("\n");
                    break;
                }

                int num = (now.num*2)%10000;
                if(!visit[num]){
                    queue.offerLast(new Node(num, now.ops+"D"));
                    visit[num] = true;
                }

                num = now.num==0? 9999: now.num-1;
                if(!visit[num]){
                    queue.offerLast(new Node(num, now.ops+"S"));
                    visit[num] = true;
                }

                int a = now.num/1000;
                num = (now.num - 1000*a)*10 + a;
                if(!visit[num]){
                    queue.offerLast(new Node(num, now.ops+"L"));
                    visit[num] = true;
                }

                a = now.num%10;
                num = 1000*a + now.num/10;
                if(!visit[num]){
                    queue.offerLast(new Node(num, now.ops+"R"));
                    visit[num] = true;
                }
            }
        }
        System.out.println(sb);
    }
}
