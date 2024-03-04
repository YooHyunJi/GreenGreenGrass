import java.io.*;
import java.util.*;

public class d04_bj_b5_9086_문자열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++) {
            String word = br.readLine();
            sb.append(word.charAt(0)).append(word.charAt(word.length()-1)).append("\n");
        }
        System.out.println(sb);
    }
}
