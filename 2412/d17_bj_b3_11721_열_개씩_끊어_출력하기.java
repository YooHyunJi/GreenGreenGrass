import java.io.*;
import java.util.*;

public class d17_bj_b3_11721_열_개씩_끊어_출력하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] arr = br.readLine().toCharArray();
        int L = arr.length;
        int cnt = 0;
        for(char c : arr){
            sb.append(c);
            if(++cnt % 10 == 0){
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
