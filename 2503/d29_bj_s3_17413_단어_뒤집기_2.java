package a2503;

import java.io.*;
import java.util.*;

public class d29_bj_s3_17413_단어_뒤집기_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        boolean isQueue = false;
        for(char c: line){
            switch (c){
                case '<':
                    while(!stack.isEmpty()){
                        sb.append(stack.pollFirst());
                    }
                    isQueue = true;
                    queue.offerLast(c);
                    break;
                case '>':
                    queue.offerLast(c);
                    while(!queue.isEmpty()){
                        sb.append(queue.pollFirst());
                    }
                    isQueue = false;
                    break;
                case ' ':
                    if(isQueue){
                        queue.offerLast(c);
                    }
                    else{
                        while(!stack.isEmpty()){
                            sb.append(stack.pollFirst());
                        }
                        sb.append(' ');
                    }
                    break;
                default:
                    if(isQueue){
                        queue.offerLast(c);
                    }
                    else{
                        stack.offerFirst(c);
                    }
                    break;
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }
        System.out.println(sb);
    }
}
