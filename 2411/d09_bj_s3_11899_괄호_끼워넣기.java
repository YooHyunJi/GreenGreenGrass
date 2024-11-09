package a2411;

import java.io.*;
import java.util.*;

public class d09_bj_s3_11899_괄호_끼워넣기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        boolean isOpen = false;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int answer = 0;
        for (char c : line) {
            if (!isOpen) {
                if (c == '(') {
                    stack.offerFirst(c);
                    isOpen = true;
                } else {
                    answer++;
                }
            } else {
                if (c == '(') {
                    stack.offerFirst(c);
                } else {
                    if (!stack.isEmpty() && stack.peekFirst() == '(') {
                        stack.pollFirst();
                    } else if (stack.isEmpty()) {
                        answer++;
                    }
                }
            }
        }
        answer += stack.size();
        System.out.println(answer);
    }
}