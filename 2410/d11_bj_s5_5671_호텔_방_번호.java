package a2410;

import java.io.*;
import java.util.*;

public class d11_bj_s5_5671_호텔_방_번호 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int answer = 0;
            for (int i = N; i <= M; i++) {
                if (isSafe(i)) {
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isSafe(int num) {
        int[] arr = new int[10];
        while (num != 0) {
            if (++arr[num % 10] == 2) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
