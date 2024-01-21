package a2401;

import java.io.*;
import java.util.*;

public class d21_bj_s4_25192_인사성밝은곰곰이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        Set<String> set = new HashSet<>();
        for(int n=0; n<N; n++) {
            String word = br.readLine();
            if(word.equals("ENTER")) {
                answer += set.size();
                set.clear();
                continue;
            }
            set.add(word);
        }
        answer += set.size();
        System.out.println(answer);
    }
}
