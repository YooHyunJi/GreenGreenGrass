package a2507;

import java.io.*;
import java.util.*;

public class d28_bj_g5_2504_괄호의_값 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int answer = 0;
        int num = 1;
        for(int i=0; i<line.length; i++){
            char c = line[i];
            if(c == '('){
                stack.offerFirst(c);
                num *= 2;
            }
            if(c == '['){
                stack.offerFirst(c);
                num *= 3;
            }
            if(c == ')'){
                if(stack.isEmpty() || stack.peekFirst() != '('){
                    System.out.println(0);
                    return;
                }
                if(line[i-1] == '('){
                    answer += num;
                }
                stack.pollFirst();
                num /= 2;
            }
            if(c == ']'){
                if(stack.isEmpty() || stack.peekFirst() != '['){
                    System.out.println(0);
                    return;
                }
                if(line[i-1] == '['){
                    answer += num;
                }
                stack.pollFirst();
                num /= 3;
            }
        }
        if(!stack.isEmpty()){
            System.out.println(0);
            return;
        }
        System.out.println(answer);
    }
}
