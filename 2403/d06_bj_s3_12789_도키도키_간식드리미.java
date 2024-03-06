package a2403;

import java.io.*;
import java.util.*;

public class d06_bj_s3_12789_도키도키_간식드리미 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int now = 1;
        for(int n=0; n<N; n++){
            int line = Integer.parseInt(st.nextToken());
            if(line > now){ stack.offerLast(line); }
            else if(line < now) {
                System.out.println("Sad");
                return;
            }
            else{
                now++;
                while (!stack.isEmpty() && stack.peekLast() == now) {
                    stack.pollLast();
                    now++;
                }
            }
        }
        while(!stack.isEmpty()){
            if(stack.pollLast() != now++){
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }
}
