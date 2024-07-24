package a2407;

import java.io.*;

public class d24_bj_s5_1543_문서_검색 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        int lenB = B.length();
        int answer = 0;
        while(A.contains(B)){
            answer++;
            int idx = A.indexOf(B);
            A = A.substring(idx+lenB);
        }
        System.out.println(answer);
    }
}
