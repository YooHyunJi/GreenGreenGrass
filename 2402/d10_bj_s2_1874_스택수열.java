package a2402;

import java.io.*;
import java.util.*;

public class d10_bj_s2_1874_스택수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        for(int n=0; n<N; n++) {
            int num = Integer.parseInt(br.readLine());
            if(num > max) {
                while(num > max){
                    stack.offerLast(++max);
                    sb.append("+\n");
                }
                stack.pollLast();
                sb.append("-\n");
                continue;
            }
            while(stack.peekLast()!=null && num <= stack.peekLast()){
                if(stack.peekLast() > num){
                    System.out.println("NO");
                    return;
                }
                stack.pollLast();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
}