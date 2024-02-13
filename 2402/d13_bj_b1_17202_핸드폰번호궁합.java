package a2402;

import java.io.*;

public class d13_bj_b1_17202_핸드폰번호궁합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[16];
        char[] tmp = br.readLine().toCharArray();
        for(int n=0; n<8; n++){ num[2*n] = tmp[n]-'0'; }
        tmp = br.readLine().toCharArray();
        for(int n=0; n<8; n++){ num[2*n+1] = tmp[n]-'0'; }
        for(int n=0; n<14; n++){
            for(int r=0; r<15-n; r++){
                num[r] = (num[r]+num[r+1])%10;
            }
        }
        System.out.println(num[0] + "" + num[1]);
    }
}
