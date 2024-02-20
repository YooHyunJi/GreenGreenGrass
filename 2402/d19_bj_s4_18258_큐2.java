package a2402;

import java.io.*;
import java.util.*;

public class d19_bj_s4_18258_큐2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> queue = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push":
                    queue.offerLast(st.nextToken());
                    break;
                case "pop":
                    if(queue.isEmpty()){ sb.append("-1\n"); }
                    else{ sb.append(queue.pollFirst()).append("\n"); }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()){ sb.append("1\n"); }
                    else{ sb.append("0\n"); }
                    break;
                case "front":
                    if(queue.isEmpty()){ sb.append("-1\n"); }
                    else{ sb.append(queue.peekFirst()).append("\n"); }
                    break;
                case "back":
                    if(queue.isEmpty()){ sb.append("-1\n"); }
                    else{ sb.append(queue.peekLast()).append("\n"); }
                    break;
            }
        }
        System.out.println(sb);
    }
}
