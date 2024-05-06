package a2405;

import java.io.*;
import java.util.*;

public class d06_bj_b3_30979_유치원생_파댕이_돌보기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int n=0; n<N; n++){
            sum += Integer.parseInt(st.nextToken());
            if(sum >= T){
                System.out.println("Padaeng_i Happy");
                return;
            }
        }
        System.out.println("Padaeng_i Cry");
    }
}
