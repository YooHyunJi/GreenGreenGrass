package a2404;

import java.io.*;

public class d09_bj_b5_2744_대소문자_바꾸기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String word = br.readLine();
        int len = word.length();
        for(int i=0; i<len; i++){
            String w = word.substring(i, i+1);
            if(w.equals(w.toUpperCase())){
                sb.append(w.toLowerCase());
            }
            else{
                sb.append(w.toUpperCase());
            }
        }
        System.out.println(sb);
    }
}
