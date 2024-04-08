package a2404;

import java.io.*;
import java.util.*;

public class d07_bj_b3_2010_플러그 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int n=0; n<N; n++){
            sum += Integer.parseInt(br.readLine());
        }
        System.out.println(sum - N + 1);
    }
}
