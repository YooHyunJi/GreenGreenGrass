package a2411;

import java.io.*;
import java.util.*;

public class d12_bj_s5_2161_카드1 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for(int n=1; n<=N; n++){
            queue.offerLast(n);
        }
        while(1 < queue.size()){
            int num = queue.pollFirst();
            sb.append(num).append(" ");
            if(queue.size() == 1){
                break;
            }
            num = queue.pollFirst();
            queue.offerLast(num);
        }
        sb.append(queue.pollFirst());
        System.out.println(sb);
    }
}
