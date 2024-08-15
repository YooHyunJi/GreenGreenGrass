package a2408;

import java.io.*;
import java.util.*;

public class d15_bj_b3_2566_최댓값 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1, R = -1, C = -1;
        for(int r=1; r<=9; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=1; c<=9; c++){
                int num = Integer.parseInt(st.nextToken());
                if(max < num){
                    max = num;
                    R = r;
                    C = c;
                }
            }
        }
        System.out.println(max);
        System.out.println(R+" "+C);
    }
}
