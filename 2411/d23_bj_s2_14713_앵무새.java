package a2411;

import java.io.*;
import java.util.*;

public class d23_bj_s2_14713_앵무새 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] idx = new int[N];
        int sCount = 0;
        int lCount = 0;
        ArrayList<String>[] sentences = new ArrayList[N];
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sentences[n] = new ArrayList<>();
            while (st.hasMoreTokens()) {
                sentences[n].add(st.nextToken());
                sCount++;
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isPossible = true;
        while (st.hasMoreTokens()) {
            lCount++;
            String now = st.nextToken();
            boolean hasNoRightToken = true;
            for (int n = 0; n < N; n++) {
                if (sentences[n].size() <= idx[n]) {
                    continue;
                }
                String token = sentences[n].get(idx[n]);
                if (now.equals(token)) {
                    idx[n]++;
                    hasNoRightToken = false;
                    break;
                }
            }
            if (hasNoRightToken) {
                isPossible = false;
                break;
            }
        }
        isPossible = isPossible && sCount == lCount;
        System.out.println(isPossible ? "Possible" : "Impossible");
    }
}