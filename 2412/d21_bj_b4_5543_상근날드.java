import java.io.*;
import java.util.*;

public class d21_bj_b4_5543_상근날드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int minB = 10000;
        int minD = 10000;
        for(int i=0; i<3; i++){
            int b = Integer.parseInt(br.readLine());
            minB = Math.min(minB, b);
        }
        for(int i=0; i<2; i++){
            int d = Integer.parseInt(br.readLine());
            minD = Math.min(minD, d);
        }
        
        System.out.println(minB + minD - 50);
    }
}
