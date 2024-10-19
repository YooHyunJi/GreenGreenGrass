package a2410;

import java.io.*;
import java.util.*;

public class d19_bj_s4_1835_카드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        }
        int num = N;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int n = 0; n < N; n++) {
            deque.offerFirst(num--);
            for (int m = 0; m <= num; m++) {
                int tmp = deque.pollLast();
                deque.offerFirst(tmp);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            sb.append(deque.pollFirst()).append(" ");
        }
        System.out.println(sb);
    }
}