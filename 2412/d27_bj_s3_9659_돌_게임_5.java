package a2412;

import java.io.*;
import java.math.*;

public class d27_bj_s3_9659_돌_게임_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());
        BigInteger big = N.divide(new BigInteger("3"));
        BigInteger small = N.remainder(new BigInteger("3"));
        BigInteger player = ((big.remainder(new BigInteger("2"))).add(small)).remainder(new BigInteger("2"));
        System.out.println(player.equals(new BigInteger("1"))? "SK": "CY");
    }
}
