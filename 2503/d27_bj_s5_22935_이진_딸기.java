package a2503;

import java.io.*;
import java.util.*;

public class d27_bj_s5_22935_이진_딸기 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = getResultNum(Integer.parseInt(br.readLine()));
            String[] result = new String[4];
            Arrays.fill(result, "V");
            int idx = 3;
            while(0 < N){
                if(N % 2 == 1){
                    result[idx] = "딸기";
                }
                --idx;
                N/=2;
            }
            for(String r: result){
                sb.append(r);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int getResultNum(int N){
        int num = N;
        while(28 < num){
            num -= 28;
        }
        num = 15 < num? 15 - num % 15: num;
        return num % 15 == 0? 15: num % 15;
    }
}
