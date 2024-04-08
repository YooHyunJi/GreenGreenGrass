package a2404;

import java.io.*;

public class d08_bj_b5_4999_아 {
    public static void main(String[] args) throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String jaehwan = br.readLine();
         String doctor = br.readLine();
         if(jaehwan.contains(doctor)){
             System.out.println("go");
         }else{
             System.out.println("no");
         }
    }
}
