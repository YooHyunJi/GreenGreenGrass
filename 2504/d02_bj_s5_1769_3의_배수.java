package a2504;

import java.io.*;
import java.util.*;

public class d02_bj_s5_1769_3의_배수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int len = num.length();
        int cnt = 0;
        while(1 < len){
            cnt++;
            int sum = 0;
            for(int i=0; i<len; i++){
                sum += num.charAt(i) - '0';
            }
            num = "" + sum;
            len = num.length();
        }
        System.out.println(cnt);
        System.out.println(Integer.parseInt(num) % 3 == 0? "YES": "NO");
    }
}
