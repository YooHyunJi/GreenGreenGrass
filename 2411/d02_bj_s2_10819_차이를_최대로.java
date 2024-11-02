package a2411;

import java.io.*;
import java.util.*;

public class d02_bj_s2_10819_차이를_최대로 {

    static int N, MAX = 0;
    static int[] arr, result;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = new int[N];
        visit = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        makePerm(0);
        System.out.println(MAX);
    }

    static void makePerm(int cnt) {
        if (cnt == N) {
            int sum = getSum();
            MAX = Math.max(MAX, sum);
            return;
        }
        for (int n = 0; n < N; n++) {
            if (visit[n]) {
                continue;
            }
            visit[n] = true;
            result[cnt] = arr[n];
            makePerm(cnt + 1);
            visit[n] = false;
        }
    }

    static int getSum() {
        int sum = 0;
        for (int n = 0; n < N - 1; n++) {
            sum += Math.abs(result[n] - result[n + 1]);
        }
        return sum;
    }
}