package a2404;

import java.io.*;
import java.util.*;

public class d22_bj_b3_27960_사격_내기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        System.out.println(A^B);
    }
}