package a2407;

import java.io.*;
import java.util.*;

public class d14_bj_s2_16953_A_B {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int cnt = 1;
        boolean isAvailable = false;
        while(A < B){
            int b = B % 10;
            if(b%2 == 1 && b != 1){ break; }
            cnt++;
            if(b == 1){ B /= 10; }
            else{ B /= 2; }
            if(A == B){
                isAvailable = true;
                break;
            }
        }
        if(isAvailable){ System.out.println(cnt); }
        else{ System.out.println(-1); }
    }
}
