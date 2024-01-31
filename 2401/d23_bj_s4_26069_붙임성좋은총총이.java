package a2401;

import java.io.*;
import java.util.*;

public class d23_bj_s4_26069_붙임성좋은총총이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        list.add("ChongChong");
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            if(list.contains(A) && !list.contains(B)) { list.add(B); }
            else if (!list.contains(A) && list.contains(B)) { list.add(A); }
        }
        System.out.println(list.size());
    }
}
