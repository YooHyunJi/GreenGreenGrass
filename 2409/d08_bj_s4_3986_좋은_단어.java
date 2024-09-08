package a2409;

import java.io.*;
import java.util.*;

public class d08_bj_s4_3986_좋은_단어 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int n=0; n<N; n++){
            char[] word = br.readLine().toCharArray();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for(char w: word){
                if(stack.isEmpty() || stack.peekFirst() != w){
                    stack.offerFirst(w);
                }
                else{
                    stack.pollFirst();
                }
            }
            if(stack.isEmpty()){
                answer++;
            }
        }
        System.out.println(answer);
    }
}