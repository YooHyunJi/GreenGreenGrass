package a2410;

import java.io.*;
import java.util.*;

public class d24_bj_s2_2607_비슷한_단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
        }

        HashMap<Character, Integer> alpha = new HashMap<>();
        for (int i = 0; i < arr[0].length(); i++)
            alpha.put(arr[0].charAt(i), alpha.getOrDefault(arr[0].charAt(i), 0) + 1);

        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            String oriStr = arr[0];
            String compStr = arr[i];
            HashMap<Character, Integer> tempAlpha = new HashMap<Character, Integer>(alpha);

            int cnt = 0;
            for (int j = 0; j < compStr.length(); j++) {
                char key = compStr.charAt(j);
                if (tempAlpha.containsKey(key) && tempAlpha.get(key) > 0) {
                    tempAlpha.put(key, tempAlpha.get(key) - 1);
                    cnt++;
                }
            }

            if (compStr.length() == oriStr.length() - 1) {
                if (cnt == compStr.length()) ans++;
            } else if (compStr.length() == oriStr.length() + 1) {
                if (cnt == oriStr.length()) ans++;
            } else if (compStr.length() == oriStr.length()) {
                if (cnt == compStr.length() || cnt == compStr.length() - 1) ans++;
            }
        }
        System.out.println(ans);
    }
}
