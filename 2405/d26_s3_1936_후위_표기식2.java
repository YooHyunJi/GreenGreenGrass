package a2405;

import java.io.*;
import java.util.*;

public class d26_s3_1936_후위_표기식2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Double> stack = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        double[] nums = new double[N];
        for(int i=0; i<N; i++) {
            nums[i] = Double.parseDouble(br.readLine());
        }
        for(char now: arr){
            int num = now-'A';
            if(0 <= num){
                stack.offerFirst(nums[num]);
            }
            else{
                double b = stack.pollFirst();
                double a = stack.pollFirst();
                switch (now){
                    case '+':
                        stack.offerFirst(a+b);
                        break;
                    case '-':
                        stack.offerFirst(a-b);
                        break;
                    case '*':
                        stack.offerFirst(a*b);
                        break;
                    case '/':
                        stack.offerFirst(a/b);
                        break;
                }
            }
        }
        System.out.printf("%.2f", stack.pollFirst());
    }
}
//123*+45/-
