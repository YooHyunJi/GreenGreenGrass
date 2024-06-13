package a2406;

import java.io.*;

public class d14_bj_s5_1436_영화감독_숌 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int n = 665;
        int cnt = 0;
        while(cnt < N){
            n++;
            if(is666(n)){
                cnt++;
            }
        }
        System.out.println(n);
    }

    static boolean is666(int num){
        int cnt = 0;
        boolean is6 = false;
        while(0 < num){
            if(num % 10 == 6){
               if(!is6){
                   is6 = true;
               }
               cnt++;
            }
            else{
                if(is6){
                    is6 = false;
                    cnt = 0;
                }
            }
            if(cnt == 3){ return true; }
            num /= 10;
        }
        return false;
    }
}
