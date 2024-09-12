package a2409;

import java.io.*;
import java.util.*;

public class d12_bj_s3_11478_서로_다른_부분_문자열의_개수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        String S = br.readLine();
        int L = S.length();
        for(int i=1; i<=L; i++){
            for(int j=0; j<=L-i; j++){
                set.add(S.substring(j, j+i));
            }
        }
        System.out.println(set.size());
    }
}