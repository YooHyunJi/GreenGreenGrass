package a2411;

import java.io.*;
import java.util.*;

public class d16_bj_s3_15815_천재_수학자_성필 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(char l: line) {
            if (isNumber(l)) {
                stack.offerFirst(l - '0');
            } else {
                int c = 0;
                int b = stack.pollFirst();
                int a = stack.pollFirst();
                switch (l){
                    case '+':
                        c = a + b;
                        break;
                    case '-':
                        c = a - b;
                        break;
                    case '*':
                        c = a * b;
                        break;
                    case '/':
                        c = a / b;
                        break;
                }
                stack.offerFirst(c);
            }
        }
        System.out.println(stack.pollFirst());
    }
    static boolean isNumber(char c){
        int num = c - '0';
        return 0 <= num && num <= 9;
    }
}
