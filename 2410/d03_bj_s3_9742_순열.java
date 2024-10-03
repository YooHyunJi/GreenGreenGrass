package a2410;

import java.io.*;
import java.util.*;

public class d03_bj_s3_9742_순열 {

    static char[] arr;
    static boolean[] visit;
    static int N, C, K;
    static boolean isFinished;
    static String result;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(str);
            String word = st.nextToken();
            arr = word.toCharArray();
            N = arr.length;
            visit = new boolean[N];
            C = Integer.parseInt(st.nextToken());
            K = 0;
            isFinished = false;
            getPermutation(new char[N], 0);
            if (!isFinished) {
                result = "No permutation";
            }
            sb.append(word).append(" ").append(C).append(" = ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    static void getPermutation(char[] str, int cnt) {
        if (isFinished) {
            return;
        }
        if (cnt == N) {
            K++;
            if (K == C) {
                isFinished = true;
                result = String.valueOf(str);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            str[cnt] = arr[i];
            getPermutation(str, cnt + 1);
            visit[i] = false;
        }
    }
}