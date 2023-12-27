package a2312;

import java.io.*;

public class d27_bj_g5_2023_신기한소수 {
    static void getSosu(int N, int cnt, int before){
        if(cnt==N){
            System.out.println(before );
            return;
        }
        for(int n=1; n<=9; n++){
            if(!isSosu(before*10+n)){ continue; }
            getSosu(N, cnt+1, before*10+n);
        }
    }

    static boolean isSosu(int num){
        if(num==1){ return false; }
        for(int n=2; n<=Math.sqrt(num); n++){ if(num%n==0){ return false; } }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        getSosu(N, 0, 0);
    }
}