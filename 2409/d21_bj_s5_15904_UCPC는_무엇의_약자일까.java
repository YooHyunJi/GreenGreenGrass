package a2409;

import java.io.*;

public class d21_bj_s5_15904_UCPC는_무엇의_약자일까 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] UCPC = {'U', 'C', 'P', 'C'};
        char[] str = br.readLine().toCharArray();
        int L = str.length;
        int ptr = 0;
        int cnt = 0;
        for(int i=0; i<4; i++){
            for(int j=ptr; j<L; j++){
                if(UCPC[i] == str[j]){
                    ptr = j;
                    cnt++;
                    break;
                }
            }
        }
        if(cnt == 4){
            System.out.println("I love UCPC");
        }
        else{
            System.out.println("I hate UCPC");
        }
    }
}
