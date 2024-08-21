package a2408;

import java.io.*;

public class d21_bj_b4_10808_알파벳_개수 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        char[] word = br.readLine().toCharArray();
        for(char w: word){ arr[w-97]++; }
        for(int a: arr){ sb.append(a).append(" "); }
        System.out.println(sb);
    }
}
