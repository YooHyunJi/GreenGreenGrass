package a2411;

import java.io.*;
import java.util.*;

public class d01_bj_s2_6603_로또 {

    static int K;
    static int[] arr, result = new int[6];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) {
                break;
            }
            arr = new int[K];
            for (int k = 0; k < K; k++) {
                arr[k] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            makeComb(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void makeComb(int start, int cnt) {
        if (cnt == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int k = start; k < K; k++) {
            result[cnt] = arr[k];
            makeComb(k + 1, cnt + 1);
        }
    }
}