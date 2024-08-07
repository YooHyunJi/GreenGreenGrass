package a2408;

import java.io.*;

public class d07_bj_s3_20310_타노스 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = new StringBuffer(br.readLine()).reverse().toString();
        String no0 = S.replaceAll("0", "");
        String no1 = S.replaceAll("1", "");
        int cntS = S.length();
        int cnt0 = (cntS - no0.length()) / 2;
        int cnt1 = (cntS - no1.length()) / 2;
        for(int i=0; i<cnt0; i++){ S = S.replaceFirst("0", ""); }
        S = new StringBuffer(S).reverse().toString();
        for(int i=0; i<cnt1; i++){ S = S.replaceFirst("1", ""); }
        System.out.println(S);
    }
}