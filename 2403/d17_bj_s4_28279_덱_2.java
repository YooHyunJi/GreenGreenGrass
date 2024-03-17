package a2403;

import java.io.*;
import java.util.*;

public class d17_bj_s4_28279_덱_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for(int n=0;n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "1":
                    deque.offerFirst(st.nextToken());
                    break;
                case "2":
                    deque.offerLast(st.nextToken());
                    break;
                case "3":
                    if(deque.isEmpty()){ sb.append("-1\n"); }
                    else{ sb.append(deque.pollFirst()).append("\n"); }
                    break;
                case "4":
                    if(deque.isEmpty()){ sb.append("-1\n"); }
                    else{ sb.append(deque.pollLast()).append("\n"); }
                    break;
                case "5":
                    sb.append(deque.size()).append("\n");
                    break;
                case "6":
                    if(deque.isEmpty()){ sb.append("1\n"); }
                    else{ sb.append("0\n"); }
                    break;
                case "7":
                    if(deque.isEmpty()){ sb.append("-1\n"); }
                    else{ sb.append(deque.peekFirst()).append("\n"); }
                    break;
                case "8":
                    if(deque.isEmpty()){ sb.append("-1\n"); }
                    else{ sb.append(deque.peekLast()).append("\n"); }
                    break;
            }
        }
        System.out.println(sb);
    }
}
