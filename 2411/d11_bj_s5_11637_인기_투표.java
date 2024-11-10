package a2411;

import java.io.*;

public class d11_bj_s5_11637_인기_투표 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int total = 0;
            int max = 0;
            for (int n = 0; n < N; n++) {
                arr[n] = Integer.parseInt(br.readLine());
                total += arr[n];
                max = Math.max(max, arr[n]);
            }
            total /= 2;
            boolean isSelected = false;
            int status = 0;
            int num = 0;
            for (int n = 0; n < N; n++) {
                if (arr[n] != max) {
                    continue;
                }
                if (isSelected) {
                    status = 3;
                    break;
                }
                if (total < arr[n]) {
                    status = 1;
                } else {
                    status = 2;
                }
                num = n + 1;
                isSelected = true;
            }
            if (status == 1) {
                sb.append("majority winner ").append(num).append("\n");
            } else if (status == 2) {
                sb.append("minority winner ").append(num).append("\n");
            } else if (status == 3) {
                sb.append("no winner\n");
            }
        }
        System.out.println(sb);
    }
}