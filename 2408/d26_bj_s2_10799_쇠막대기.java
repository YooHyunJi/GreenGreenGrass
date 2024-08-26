package a2408;

import java.io.*;
import java.util.*;

public class d26_bj_s2_10799_쇠막대기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int cntStick = 0, cntPoint = 0;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        stack.offerFirst('(');
        for(int i=1; i<arr.length; i++){
            char c = arr[i];
            if(c == '('){
                stack.offerFirst('(');
            }
            else{
                stack.pollFirst();
                if(arr[i-1] == '('){
                    cntPoint += stack.size();
                }
                else{
                    cntStick++;
                }
            }
        }
        System.out.println(cntPoint+cntStick);
    }
}