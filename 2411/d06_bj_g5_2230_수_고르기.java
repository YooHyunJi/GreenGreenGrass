package a2411;

import java.io.*;
import java.util.*;

public class d06_bj_g5_2230_수_고르기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int startIdx = 0;
        int endIdx = 1;
        int MIN = Integer.MAX_VALUE;
        while (startIdx <= endIdx && endIdx < N) {
            int startNum = arr[startIdx];
            int endNum = arr[endIdx];
            int diff = endNum - startNum;
            if (diff < M) {
                endIdx++;
            } else {
                MIN = Math.min(MIN, diff);
                startIdx++;
            }
        }
        System.out.println(MIN);
    }
}