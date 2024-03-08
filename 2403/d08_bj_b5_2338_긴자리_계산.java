package a2403;

import java.io.*;
import java.math.BigInteger;

public class d08_bj_b5_2338_긴자리_계산 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BigInteger A = new BigInteger(br.readLine());
        BigInteger B = new BigInteger(br.readLine());
        sb.append(A.add(B)).append("\n")
          .append(A.subtract(B)).append("\n")
          .append(A.multiply(B));
        System.out.println(sb);
    }
}