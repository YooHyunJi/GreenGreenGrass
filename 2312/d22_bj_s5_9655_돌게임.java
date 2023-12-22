package a2312;

import java.io.*;

public class d22_bj_s5_9655_돌게임 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine())%6;
        if(N%2==0) System.out.println("CY");
        else System.out.println("SK");
    }
}