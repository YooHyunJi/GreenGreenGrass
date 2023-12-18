package a2312;

import java.io.*;
import java.util.*;

public class d18_bj_b3_5073_삼각형과세변 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()),
                b = Integer.parseInt(st.nextToken()),
                c = Integer.parseInt(st.nextToken());
            if(a+b+c == 0) break;
            int max = Math.max(Math.max(a, b), c);
            if(2*max>=a+b+c) sb.append("Invalid\n");
            else if (a==b && b==c) sb.append("Equilateral\n");
            else if (a==b || b==c || c==a) sb.append("Isosceles\n");
            else sb.append("Scalene\n");
        }
        System.out.println(sb);
    }
}
