package a2404;

import java.io.*;
import java.util.*;

public class d24_bj_s5_28445_알록달록_앵무새 {
    public static void main(String[] args) throws Exception{
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        set.add(st.nextToken());
        set.add(st.nextToken());
        st = new StringTokenizer(br.readLine());
        set.add(st.nextToken());
        set.add(st.nextToken());
        String[] arr = set.toArray(new String[]{""});
        Arrays.sort(arr);
        for (String i : arr) {
            for (String j : arr) {
                sb.append(i).append(" ").append(j).append("\n");
            }
        }
        System.out.println(sb);
    }
}
