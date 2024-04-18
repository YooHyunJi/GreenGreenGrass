package a2404;

import java.io.*;
import java.util.*;

public class d19_bj_s4_1758_알바생_강호 {
    public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       Integer[] tips = new Integer[N];
       for(int n=0; n<N; n++){ tips[n] = Integer.parseInt(br.readLine()); }
       Arrays.sort(tips, Collections.reverseOrder());
       long sum = 0;
       for(int n=0; n<N; n++){
           if(tips[n] <= n) { break; }
           sum += tips[n] - n;
       }
        System.out.println(sum);
    }
}
