package a2411;

import java.io.*;
import java.util.*;

public class d26_bj_s2_5397_키로거 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++)
        {
            char[] log = br.readLine().toCharArray();
            int L = log.length;
            ArrayDeque<Character> stack1 = new ArrayDeque<>();
            ArrayDeque<Character> stack2 = new ArrayDeque<>();
            for(int l=0; l<L; l++){
                char now = log[l];
                if(now == '<'){
                    if(stack1.isEmpty()){ continue; }
                    stack2.offerFirst(stack1.pollLast());
                }
                else if(now == '>'){
                    if(stack2.isEmpty()){ continue; }
                    stack1.offerLast(stack2.pollFirst());
                }
                else if(now == '-'){
                    if(stack1.isEmpty()){ continue; }
                    stack1.pollLast();
                }
                else{
                    stack1.offerLast(now);
                }
            }
            for(char c: stack1){
                sb.append(c);
            }
            for(char c: stack2){
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
