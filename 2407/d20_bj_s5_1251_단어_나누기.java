package a2407;

import java.io.*;
import java.util.*;

public class d20_bj_s5_1251_단어_나누기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<String> wordPQ = new PriorityQueue<>();

        char[] word = br.readLine().toCharArray();
        int L = word.length;
        for(int i=0; i<L-1; i++){
            for(int j=i+1; j<L-1; j++){
                System.out.println(i+" "+j);
                StringBuilder sb = new StringBuilder();
                for(int k=i; k>=0; k--){ sb.append(word[k]); }
                for(int k=j; k>i; k--){ sb.append(word[k]); }
                for(int k=L-1; k>j; k--){ sb.append(word[k]); }
                wordPQ.add(sb.toString());
            }
        }
        System.out.println(wordPQ.poll());
    }
}
