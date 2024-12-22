import java.io.*;
import java.util.*;

public class d22_bj_b3_5565_영수증 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i=0; i<9; i++){
            int num = Integer.parseInt(br.readLine());
            sum += num;
        }
        
        System.out.println(total - sum);
    }
}
