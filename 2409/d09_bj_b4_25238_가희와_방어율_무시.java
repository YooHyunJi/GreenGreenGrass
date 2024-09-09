package a2409;

import java.io.*;
import java.util.*;

public class d09_bj_b4_25238_가희와_방어율_무시 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int result = A * (100 - B) / 100;
        if(100 <= result){
            System.out.println(0);
        }
        else{
            System.out.println(1);
        }
    }
}
