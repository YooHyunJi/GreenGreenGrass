package a2411;

import java.io.*;
import java.util.*;

public class d21_bj_b4_10797_10부제 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int car = Integer.parseInt(st.nextToken());
            if(N == car){ answer++; }
        }
        System.out.println(answer);
    }
}
