package a2406;

import java.io.*;
import java.util.*;

public class d28_bj_s5_25206_너의_평점은 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);
        map.put("P", -1.0);
        double up = 0.0;
        double down = 0.0;
        for(int i=0; i<20; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double a = Double.parseDouble(st.nextToken());
            double b = map.get(st.nextToken());
            if(b == -1.0){ continue; }
            up += a * b;
            down += a;
        }
        System.out.println(up/down);
    }
}
