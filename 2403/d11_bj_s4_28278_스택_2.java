package a2403;

import java.io.*;
import java.util.*;

public class d11_bj_s4_28278_스택_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "1": stack.offerLast(st.nextToken()); break;
                case "2": sb.append(stack.isEmpty()? "-1": stack.pollLast()).append("\n"); break;
                case "3": sb.append(stack.size()).append("\n"); break;
                case "4": sb.append(stack.isEmpty()? "1": "0").append("\n"); break;
                case "5": sb.append(stack.isEmpty()? "-1": stack.peekLast()).append("\n"); break;
            }
        }
        System.out.println(sb);
    }
}
