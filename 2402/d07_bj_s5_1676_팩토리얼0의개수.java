package a2402;

import java.io.*;
import java.util.*;

public class d07_bj_s5_1676_팩토리얼0의개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        while(N>=5){
            answer += N/5;
            N/=5;
        }
        System.out.println(answer);
    }
}
