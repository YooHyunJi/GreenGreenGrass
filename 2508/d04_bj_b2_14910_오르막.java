package a2507;

import java.io.*;
import java.util.*;

public class d04_bj_b2_14910_오르막 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isBinaerim = true;
        int num = -1_000_001;
        while(st.hasMoreTokens()){
            int now = Integer.parseInt(st.nextToken());
            if(now < num){
                isBinaerim = false;
                break;
            }
            num = now;
        }
        System.out.println(isBinaerim? "Good": "Bad");
    }
}
