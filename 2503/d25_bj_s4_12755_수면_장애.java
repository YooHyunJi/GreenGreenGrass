package a2503;

import java.io.*;
import java.util.*;

public class d25_bj_s4_12755_수면_장애 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        int num = 0;
        int N = Integer.parseInt(br.readLine());
        StringBuilder str = new StringBuilder();
        while(n < N){
            str.delete(0, str.length());
            str.append(++num);
            n += str.length();
        }
        System.out.println(str.charAt(str.length() - n + N - 1));
    }
}
