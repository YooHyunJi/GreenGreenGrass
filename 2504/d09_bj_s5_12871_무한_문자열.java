package a2504;

import java.io.*;
import java.util.*;

public class d09_bj_s5_12871_무한_문자열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        int lenS = S.length();
        int lenT = T.length();
        int gcd = getGCD(Math.max(lenS, lenT), Math.min(lenS, lenT));
        int lcm = (lenS * lenT) / gcd;
        int divS = lcm / lenS;
        int divT = lcm / lenT;
        String tmpS = "";
        String tmpT = "";
        for(int i=0; i<divS; i++){
            tmpS += S;
        }
        for(int i=0; i<divT; i++){
            tmpT += T;
        }
        if(tmpS.equals(tmpT)){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }

    static int getGCD(int a, int b){
        while(true){
            if(a % b == 0){
                return b;
            }
            int mod = a % b;
            a = b;
            b = mod;
        }
    }
}
