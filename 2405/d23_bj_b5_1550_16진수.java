package a2405;

import java.io.*;

public class d23_bj_b5_1550_16진수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        double L = arr.length-1;
        int answer = 0;
        for(char c: arr){
            int num = 10<c-'0'? c-'0'-7: c-'0';
            answer += (int) (num * Math.pow(16, L--));
        }
        System.out.println(answer);
    }
}