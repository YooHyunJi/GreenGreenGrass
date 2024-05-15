package a2405;

import java.io.*;

public class d15_bj_b3_10988_팰린드롬인지_확인하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();
        int L = word.length;
        for(int i=0; i<L/2; i++){
            if(word[i] != word[L-1-i]){
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
