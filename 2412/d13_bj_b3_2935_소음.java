import java.io.*;
import java.util.*;
import java.math.*;

public class d13_bj_b3_2935_소음 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal A = new BigDecimal(br.readLine());
        String B = br.readLine();
        BigDecimal C = new BigDecimal(br.readLine());
        
        if(B.equals("+")){
           System.out.println(A.add(C));
        }
        else{
           System.out.println(A.multiply(C));
        }
    }
}
