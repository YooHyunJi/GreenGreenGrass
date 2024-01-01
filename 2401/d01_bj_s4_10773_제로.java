package a2401;

import java.io.*;
import java.util.*;

public class d01_bj_s4_10773_제로 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int K = Integer.parseInt(br.readLine());
        for(int k=0; k<K; k++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){ stack.pollLast(); }
            else{ stack.offerLast(num); }
        }
        int answer = 0;
        while(!stack.isEmpty()){ answer += stack.pollLast(); }
        System.out.println(answer);
    }
}