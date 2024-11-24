package a2411;

import java.io.*;
import java.util.*;

public class d25_bj_s3_1448_삼각형_만들기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = -1;
        Integer[] arr = new Integer[N];
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < N - 2; i++) {
            if (isAvailable(arr[i], arr[i + 1], arr[i + 2])) {
                answer = arr[i] + arr[i + 1] + arr[i + 2];
                break;
            }
        }
        System.out.println(answer);
    }

    private static boolean isAvailable(int a, int b, int c) {
        return a < b + c;
    }
}