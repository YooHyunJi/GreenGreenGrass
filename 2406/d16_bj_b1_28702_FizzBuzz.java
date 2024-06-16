package a2406;

import java.io.*;

public class d16_bj_b1_28702_FizzBuzz {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = -1;
        for(int i=0; i<3; i++){
            String line = br.readLine();
            int num = line.toCharArray()[0]-'0';
            if(1 <= num && num <= 9){
                result = Integer.parseInt(line) + (3-i);
                break;
            }
        }
        if(result%3==0){
            if(result%5==0){
                System.out.println("FizzBuzz");
            }
            else{
                System.out.println("Fizz");
            }
        }
        else{
            if(result%5==0){
                System.out.println("Buzz");
            }
            else{
                System.out.println(result);
            }
        }
    }
}
