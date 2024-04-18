package a2404;

import java.io.*;
import java.util.*;

public class d18_bj_s5_15719_중복된_숫자 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        long real = N * (N-1) / 2;
        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){ sum += Integer.parseInt(st.nextToken());  }
        System.out.println(sum - real);
    }
}
