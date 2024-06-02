package a2406;

import java.io.*;

public class d02_bj_s5_1094_막대기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double X = Double.parseDouble(br.readLine());
        int answer = 0;
        for(int i=6; 0<=i; i--){
            if(X < Math.pow(2, i)){ continue; }
            for(int j=i; 0<=j; j--){
                if(X < Math.pow(2, j)){ continue; }
                answer++;
                X -= Math.pow(2, j);
            }
            break;
        }
        System.out.println(answer);
    }
}
