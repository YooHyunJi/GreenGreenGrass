package a2406;

import java.io.*;

public class d13_bj_b4_31403_A_B_C {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();
        System.out.println(Integer.parseInt(A)+Integer.parseInt(B)-Integer.parseInt(C));
        System.out.println(Integer.parseInt(A.concat(B))-Integer.parseInt(C));
    }
}
