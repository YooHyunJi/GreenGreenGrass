package a2408;

import java.io.*;

public class d24_bj_s5_1789_수들의_합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        int cnt = 0, n=1;
        while(n <= N){
            N -= n;
            n++;
            cnt++;
        }
        System.out.println(cnt);
    }
}
