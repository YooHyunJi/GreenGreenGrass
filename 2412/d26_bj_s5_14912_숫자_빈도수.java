package a2412;

import java.io.*;
import java.util.*;

public class d26_bj_s5_14912_숫자_빈도수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int answer = 0;
        for(int i=1; i<=N; i++){
            int num = i;
            while(0 < num){
                if(num % 10 == D){
                    answer++;
                }
                num /= 10;
            }
        }
        System.out.println(answer);
    }
}
