package a2411;

import java.io.*;
import java.util.*;

public class d07_bj_s4_2331_반복수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) Math.pow(i, P);
        }
        int num = A;
        int dupIdx = 0;
        list.add(num);
        while (true) {
            int next = 0;
            while (0 < num) {
                int idx = num % 10;
                next += arr[idx];
                num /= 10;
            }
            if (list.contains(next)) {
                dupIdx = list.indexOf(next);
                break;
            }
            list.add(next);
            num = next;
        }
        System.out.println(dupIdx);
    }
}