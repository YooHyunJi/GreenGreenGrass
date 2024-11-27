package a2411;

import java.io.*;

public class d28_bj_b3_2576_홀수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int min = 101;
        for(int i=0; i<7; i++){
            int num = Integer.parseInt(br.readLine());
            if(num % 2 == 0){ continue; }
            sum += num;
            min = Math.min(min, num);
        }
        if(sum == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
