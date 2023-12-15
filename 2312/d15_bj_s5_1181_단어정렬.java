package etc;

import java.io.*;
import java.util.*;

public class d15_bj_s5_1181_단어정렬 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int n=0; n<N; n++) set.add(br.readLine());
        String[] arr = set.toArray(new String[0]);
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()) return o1.compareTo(o2);
                return o1.length()-o2.length();
            }
        });
        for(String word: arr) sb.append(word).append("\n");
        System.out.println(sb);
    }
}