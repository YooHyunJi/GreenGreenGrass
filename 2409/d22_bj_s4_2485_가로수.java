package a2409;

import java.io.*;

public class d22_bj_s4_2485_가로수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] gaps = new int[N - 1];
        int first = Integer.parseInt(br.readLine());
        int prev = first;

        for (int n = 0; n < N - 1; n++) {
            int now = Integer.parseInt(br.readLine());
            gaps[n] = now - prev;
            prev = now;
        }
        int answer = getChoidaeGongbaesu(gaps[0], gaps[1]);
        for (int n = 2; n <= N - 2; n++) {
            answer = getChoidaeGongbaesu(answer, gaps[n]);
        }
        System.out.println((prev - first) / answer - N + 1);
    }

    static int getChoidaeGongbaesu(int A, int B) {
        int result = A;
        while (A % result != 0 || B % result != 0) {
            result--;
        }
        return result;
    }
}