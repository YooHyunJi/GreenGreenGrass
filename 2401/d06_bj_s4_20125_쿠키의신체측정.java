package a2401;

import java.io.*;
import java.util.*;

public class d06_bj_s4_20125_쿠키의신체측정 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        int hr = 0, hc = 0;
        for(int n=0; n<N; n++) { map[n] = br.readLine().toCharArray(); }

        boolean star = false;
        for(int n=0; n<N; n++) {
            for(int nn=0; nn<N; nn++) {
                if(map[n][nn] != '*') { continue; }
                star = true;
                hr = n+2;
                hc = nn+1;
                System.out.println(hr+" "+hc);
            }
            if(star) { break; }
        }
        char[] line = map[hr-1];
        star = false;
        int start = 0, end = 0;
        for(int n=0; n<N; n++) {
            if(!star && line[n] == '*') {
                star = true;
                start = n+1;
            }
            if(star && (n==N-1 || line[n+1] != '*')) {
                end = n+1;
                break;
            }
        }
        System.out.print((hc-start)+" "+(end-hc)+" ");
        int nr = hr;
        int cnt = 0;
        while(map[nr++][hc-1]=='*'){ cnt++; }
        System.out.print(cnt+" ");
        int cntl = 1;
        int cntr = 1;
        while(nr<N){
            if(map[nr][hc-2]=='*') { cntl++; }
            if(map[nr++][hc]=='*') { cntr++; }
        }
        System.out.println(cntl+" "+cntr);
    }
}