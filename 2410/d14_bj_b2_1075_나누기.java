package a2410;

import java.io.*;

public class d14_bj_b2_1075_나누기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        int M = N / 100 * 100;
        while(!(M % F == 0)){
            M++;
        }
        System.out.println(((M / 10) % 10) + "" + (M % 10));
    }
}
