package a2411;

import java.io.*;

public class d15_bj_s4_1748_수_이어_쓰기_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        for (int n = 1; n <= N; n++) {
            if (n / 10 == 0) {
                answer++;
            } else if (n / 100 == 0) {
                answer += 2;
            } else if (n / 1000 == 0) {
                answer += 3;
            } else if (n / 10000 == 0) {
                answer += 4;
            } else if (n / 100000 == 0) {
                answer += 5;
            } else if (n / 1000000 == 0) {
                answer += 6;
            } else if (n / 10000000 == 0) {
                answer += 7;
            } else if (n / 100000000 == 0) {
                answer += 8;
            } else{
                answer += 9;
            }
        }
        System.out.println(answer);
    }
}